package com.infogain.gcp.poc.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublishMessageModel {

    private String message;
    private Map<String, String> attributes;

}