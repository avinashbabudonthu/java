package com.spring.integration.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Constants {

    public static final String GATEWAY_CHANNEL_STUDENT_INPUT = "gateway.channel.student.input";
    public static final String GATEWAY_CHANNEL_OBJECT_TO_JSON = "gateway.channel.objectToJson";
    public static final String GATEWAY_CHANNEL_JSON_TO_OBJECT = "gateway.channel.jsonToObject";
    public static final String GATEWAY_CHANNEL_JSON_TO_OBJECT_TO_RESPONSE = "gateway.channel.jsonToObject.to.response";

}