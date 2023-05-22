package com.infogain.gcp.poc.repository;

import com.infogain.gcp.poc.entity.PNREntity;
import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;
import org.springframework.cloud.gcp.data.spanner.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PNRRepository extends SpannerRepository<PNREntity, String> {

//    @Query(value = "select p.pnr_id as pnrId, p.mobileNumber as mobileNumber, p.remark as remark from pnr p join pnr_out_box pob on p.pnr_id = pob.pnr_id and p.pnr_id = @pnrId")
//    Optional<PNREntity> findPNREntityByPnrId(@Param("pnrId")String pnrId);

    @Query(value = "select p.pnr_id as pnrId, p.mobileNumber as mobileNumber, p.remark as remark, pob.id as pnrOutBoxId from pnr p join pnr_out_box pob on p.pnr_id = pob.pnr_id and pob.is_processed = @isProcessed and pob.retry_count < @retryCount")
    List<PNREntity> findPNREntityListByIsProcessedAndRetryCount(@Param("isProcessed")Boolean isProcessed, @Param("retryCount")Integer retryCount);
}