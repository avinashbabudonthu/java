package com.infogain.gcp.poc.repository;

import com.infogain.gcp.poc.entity.PNREntity;
import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PNRRepository extends SpannerRepository<PNREntity, String> {
}