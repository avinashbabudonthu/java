package com.infogain.gcp.poc.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.infogain.gcp.poc.entity.PNREntity;
import lombok.*;
import org.apache.commons.beanutils.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"pnrId"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PNRModel {

    private String pnrId;
    private String mobileNumber;
    private String remark;
    private String pnrOutBoxId;

    @SneakyThrows
    public PNREntity buildEntity(){
        PNREntity pnrEntity = new PNREntity();
        BeanUtils.copyProperties(pnrEntity, this);
        return pnrEntity;
    }
}
