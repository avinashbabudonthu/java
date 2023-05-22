package com.gcp.practice.repository;

import com.gcp.practice.entity.EmpEntity;
import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends SpannerRepository<EmpEntity, Long> {
}
