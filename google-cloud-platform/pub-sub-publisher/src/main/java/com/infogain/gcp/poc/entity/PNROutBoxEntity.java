package com.infogain.gcp.poc.entity;

import lombok.*;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"pnrId"})
@Table(name = "pnr_out_box")
public class PNROutBoxEntity {

    @PrimaryKey
    @Column(name = "id")
    private String id;

    @Column(name = "pnr_id")
    private String pnrId;

    @Column(name = "is_processed")
    private Boolean isProcessed;

    @Column(name = "retry_count")
    private Integer retryCount;

    @Column(name = "event_type")
    private String eventType;

    @Column(name = "processed_by")
    private String processedBy;

}
