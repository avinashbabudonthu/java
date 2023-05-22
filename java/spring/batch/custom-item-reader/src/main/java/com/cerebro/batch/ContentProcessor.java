package com.cerebro.batch;

@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Component
public class ContentProcessor implements org.springframework.batch.item.ItemProcessor<com.cerebro.model.ContentModel, com.cerebro.model.ContentModel> {

    @Override
    public com.cerebro.model.ContentModel process(com.cerebro.model.ContentModel contentModel) throws Exception {
        log.info("ContentModel={}", contentModel);
        return contentModel;
    }

}
