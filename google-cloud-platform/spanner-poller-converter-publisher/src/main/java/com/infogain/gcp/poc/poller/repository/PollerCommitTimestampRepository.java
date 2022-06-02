package com.infogain.gcp.poc.poller.repository;

import com.google.cloud.Timestamp;
import com.infogain.gcp.poc.poller.entity.PollerCommitTimestampEntity;
import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PollerCommitTimestampRepository extends SpannerRepository<PollerCommitTimestampEntity, Timestamp> {

    Optional<PollerCommitTimestampEntity> findFirstByOrderByLastCommitTimestampDesc();

}