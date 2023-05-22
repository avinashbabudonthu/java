package com.infogain.gcp.poc.entity;

import com.google.cloud.Timestamp;
import com.infogain.gcp.poc.model.PNRModel;
import lombok.*;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"pnrId"})
@Table(name = "pnr")
public class PNREntity {

    @PrimaryKey
    @Column(name = "pnr_id")
    private String pnrId;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "remark")
    private String remark;

    @Column(name = "lastUpdateTimestamp", spannerCommitTimestamp = true)
    private Timestamp lastUpdateTimestamp;

    @SneakyThrows
    public PNRModel buildModel(){
        PNRModel pnrModel = new PNRModel();
        BeanUtils.copyProperties(pnrModel, this);
        return pnrModel;
    }

}