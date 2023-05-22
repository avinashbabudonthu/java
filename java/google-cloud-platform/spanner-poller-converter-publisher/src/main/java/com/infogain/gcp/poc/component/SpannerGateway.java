package com.infogain.gcp.poc.component;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gcp.data.spanner.core.SpannerTemplate;
import org.springframework.stereotype.Component;

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;

@Component
public class SpannerGateway {

    @Autowired
    private SpannerTemplate spannerTemplate;

    public Timestamp getTimestampRecord(Statement statement) {
        Timestamp timestamp = null;
        ResultSet rs = spannerTemplate.executeQuery(statement, null);
        if (rs.next()) {
            timestamp = rs.isNull(0) ? timestamp : rs.getTimestamp(0);
        }

        return timestamp;
    }

}
