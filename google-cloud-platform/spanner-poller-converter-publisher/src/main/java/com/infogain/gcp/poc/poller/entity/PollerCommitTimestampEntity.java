package com.infogain.gcp.poc.poller.entity;

import com.google.cloud.Timestamp;
import lombok.*;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"lastCommitTimestamp"})
@Table(name = "POLLER_COMMIT_TIMESTAMPS")
public class PollerCommitTimestampEntity {

    @PrimaryKey
    @Column(name = "last_commit_timestamp")
    private Timestamp lastCommitTimestamp;

}
