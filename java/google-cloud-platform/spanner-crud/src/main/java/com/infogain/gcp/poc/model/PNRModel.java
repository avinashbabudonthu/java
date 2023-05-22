package com.infogain.gcp.poc.model;

import com.google.cloud.Timestamp;
import com.infogain.gcp.poc.entity.PNREntity;
import lombok.*;
import org.apache.commons.beanutils.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"pnrId"})
public class PNRModel {

    private String pnrId;
    private String mobileNumber;
    private String remark;
    private Timestamp lastUpdateTimestamp;
    private String pnrOutBoxId;

    @SneakyThrows
    public PNREntity buildEntity(){
        PNREntity pnrEntity = new PNREntity();
        BeanUtils.copyProperties(pnrEntity, this);
        return pnrEntity;
    }

    public void updateEntity(PNREntity pnrEntity){
        pnrEntity.setMobileNumber(mobileNumber);
        pnrEntity.setRemark(remark);
    }

}