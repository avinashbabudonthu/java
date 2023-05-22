package com.infogain.gcp.poc.repository;

import com.infogain.gcp.poc.entity.PNROutBoxEntity;
import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PNROutBoxRepository extends SpannerRepository<PNROutBoxEntity, String> {

    List<PNROutBoxEntity> findByPnrId(String pnrId);

}