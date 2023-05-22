package com.gcp.practice.repository;

import com.gcp.practice.entity.Emp2Entity;
import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Emp2Repository extends SpannerRepository<Emp2Entity, Long> {
}