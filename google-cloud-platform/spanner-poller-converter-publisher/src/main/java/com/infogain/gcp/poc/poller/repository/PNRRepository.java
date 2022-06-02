package com.infogain.gcp.poc.poller.repository;

import com.google.cloud.Timestamp;
import com.infogain.gcp.poc.poller.entity.PNREntity;
import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PNRRepository extends SpannerRepository<PNREntity, String> {

    List<PNREntity> findAllByOrderByLastUpdateTimestamp();

    List<PNREntity> findByLastUpdateTimestampGreaterThanOrderByLastUpdateTimestamp(Timestamp lastUpdateTimestamp);

}