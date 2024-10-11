package com.java.config;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString(of = {"id"})
@Configuration
@ConfigurationProperties("student")
public class StudentConfiguration {

    private Long id;
    private String name;
    private String course;

}