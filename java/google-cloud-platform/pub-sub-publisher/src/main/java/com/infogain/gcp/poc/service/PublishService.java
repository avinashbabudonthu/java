package com.infogain.gcp.poc.service;

import com.infogain.gcp.poc.component.MessageConverter;
import com.infogain.gcp.poc.entity.PNREntity;
import com.infogain.gcp.poc.entity.PNROutBoxEntity;
import com.infogain.gcp.poc.model.PNRModel;
import com.infogain.gcp.poc.model.PublishMessageModel;
import com.infogain.gcp.poc.repository.PNROutBoxRepository;
import com.infogain.gcp.poc.repository.PNRRepository;
import com.infogain.gcp.poc.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gcp.pubsub.core.PubSubTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
public class PublishService {

    @Value("${app.topic.name}")
    private String topicName;

    @Autowired
    private MessageConverter messageConverter;

    @Autowired
    private PubSubTemplate pubSubTemplate;

    @Autowired
    private PNRRepository pnrRepository;

    @Autowired
    private PNROutBoxRepository pnrOutBoxRepository;

    private String processMessage(PNREntity pnrEntity, Map<String, String> attributes) {
        log.info("Processing PNREntity={}", pnrEntity);

        if (StringUtils.isNotBlank(pnrEntity.getRemark())) {
            attributes.put("remark", pnrEntity.getRemark());
        }

        if (StringUtils.isNotBlank(pnrEntity.getMobileNumber())) {
            attributes.put("mobileNumber", pnrEntity.getMobileNumber());
        }

        String messageJson = messageConverter.convertToJsonString(pnrEntity);
        log.info("Processed PNREntity={}, messageJson={}", pnrEntity, messageJson);
        return messageJson;
    }

    private void publishMessage(String message, Map<String, String> attributes) {
        log.info("publishing message {} to topic {}", message, topicName);
        pubSubTemplate.publish(topicName, message, attributes);
        log.info("published message {} to topic {}", message, topicName);
    }

    private PNROutBoxEntity savePNROutBoxEntity(PNROutBoxEntity pnrOutBoxEntity) {
        return pnrOutBoxRepository.save(pnrOutBoxEntity);
    }

    private List<PNROutBoxEntity> saveOrUpdatePNROutBoxEntityList(List<PNROutBoxEntity> pnrOutBoxEntityList) {
        return IterableUtils.toList(pnrOutBoxRepository.saveAll(pnrOutBoxEntityList));
    }

    private List<PNROutBoxEntity> findPNROutBoxEntityListByPnrIdList(List<String> pnrIdList) {
        return IterableUtils.toList(pnrOutBoxRepository.findAllById(pnrIdList));
    }

    @Transactional
    public String publish(PNRModel pnrModel) {
        String pnrId = pnrModel.getPnrId();
        String pnrOutBoxId = pnrModel.getPnrOutBoxId();

        try{
            if (StringUtils.isEmpty(pnrId)) {
                log.info("pnrId is null or empty");
                return "pnrId is null or empty";
            }

            PNREntity pnrEntity = pnrModel.buildEntity();
            Map<String, String> attributes = new HashMap<>();
            String messageJson = processMessage(pnrEntity, attributes);
            publishMessage(messageJson, attributes);

            // TODO added to simulate duplicate message scenario - start
            String remark = pnrEntity.getRemark();
            if(StringUtils.equals("duplicate", remark)){
                String message = String.format("failed to update out box. remark == duplicate. pnr-id=%s", pnrId);
                log.info(message);
                return message;
            }

            if(StringUtils.equals("exception", remark)){
                String message = String.format("failed to update out box. remark == exception. pnr-id=%s", pnrId);
                log.info(message);
                throw new RuntimeException(message);
            }
            // TODO added to simulate duplicate message scenario - end

            // update PNROutBoxEntity.isProcessed to true, retryCount = retryCount + 1
            log.info("updating PNROutBoxEntity.isProcessed to true, retryCount = retryCount + 1");
            // Optional<PNROutBoxEntity> pnrOutBoxEntityOptional = pnrOutBoxRepository.findById(pnrId);
            Optional<PNROutBoxEntity> pnrOutBoxEntityOptional = pnrOutBoxRepository.findById(pnrOutBoxId);

            if (pnrOutBoxEntityOptional.isPresent()) {
                PNROutBoxEntity pnrOutBoxEntity = pnrOutBoxEntityOptional.get();
                if(!Constants.RETRY_PNR_ID_LIST.contains(pnrOutBoxEntity.getPnrId())){
                    pnrOutBoxEntity.setIsProcessed(true);
                    pnrOutBoxEntity.setProcessedBy(Constants.API);
                }

                savePNROutBoxEntity(pnrOutBoxEntity);
            }
            log.info("updated PNROutBoxEntity.isProcessed to true, retryCount = retryCount + 1");

            return String.format("success. pnr-id=%s", pnrId);
        }catch(Exception e){
            log.error("Exception while processing, publishing, update", e);
            return e.getMessage();
        }
    }

    public String publishFailedRecords() {
        List<PNREntity> pnrEntityList = ListUtils.emptyIfNull(pnrRepository.findPNREntityListByIsProcessedAndRetryCount(false, 5));

        if (CollectionUtils.isEmpty(pnrEntityList)) {
            log.info("No failed PNREntity records to process");
            return "success";
        }

        List<String> pnrOutBoxIdList = new ArrayList<>();
        List<PublishMessageModel> publishMessageModelList = new ArrayList<>();

        pnrEntityList.forEach(pnrEntity -> {
            Map<String, String> attributes = new HashMap<>();
            String messageJson = processMessage(pnrEntity, attributes);
            PublishMessageModel publishMessageModel = PublishMessageModel.builder().message(messageJson).attributes(attributes).build();
            publishMessageModelList.add(publishMessageModel);
            pnrOutBoxIdList.add(pnrEntity.getPnrOutBoxId());
        });

        // TODO check to publish in batch rather than iterating
        publishMessageModelList.forEach(publishMessageModel -> {
            publishMessage(publishMessageModel.getMessage(), publishMessageModel.getAttributes());
        });

        // update PNROutBoxEntity.isProcessed to true, retryCount = retryCount + 1
        log.info("updating isProcessed to true, retryCount = retryCount + 1");
        List<PNROutBoxEntity> pnrOutBoxEntityList = findPNROutBoxEntityListByPnrIdList(pnrOutBoxIdList);
        pnrOutBoxEntityList.forEach(pnrOutBoxEntity -> {
            if(!Constants.RETRY_PNR_ID_LIST.contains(pnrOutBoxEntity.getPnrId())){
                pnrOutBoxEntity.setIsProcessed(true);
            }

            if(Constants.RETRY_PNR_ID_LIST.contains(pnrOutBoxEntity.getPnrId()) && pnrOutBoxEntity.getRetryCount() > 2){
                pnrOutBoxEntity.setIsProcessed(true);
            }

            pnrOutBoxEntity.setRetryCount(pnrOutBoxEntity.getRetryCount() + 1);
            pnrOutBoxEntity.setProcessedBy(Constants.CLOUD_SCHEDULER);
        });
        saveOrUpdatePNROutBoxEntityList(pnrOutBoxEntityList);
        log.info("updated isProcessed to true, retryCount = retryCount + 1");

        return "success";
    }

}