package com.rest.api.config;

import com.rest.api.util.GenderEnum;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Map;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ListableBeanFactory beanFactory;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        Map<String, Object> components = beanFactory.getBeansWithAnnotation(ParameterConverter.class);
        components.values().parallelStream().forEach((Object c) -> {
            if(c instanceof Converter){
                registry.addConverter((Converter<String, GenderEnum>) c);
            }
        });
    }
}