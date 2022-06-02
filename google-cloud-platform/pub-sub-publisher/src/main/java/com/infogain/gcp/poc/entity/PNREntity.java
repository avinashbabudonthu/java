package com.infogain.gcp.poc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PNREntity {

    private String pnrId;
    private String mobileNumber;
    private String remark;
    private String pnrOutBoxId;
    ;
}
