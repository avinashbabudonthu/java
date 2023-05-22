package com.rest.api.config;

import com.rest.api.util.GenderEnum;
import org.springframework.core.convert.converter.Converter;

@ParameterConverter
public class StringToGenderEnumConverter implements Converter<String, GenderEnum> {

    @Override
    public GenderEnum convert(String s) {
        return GenderEnum.getGender(s);
    }

}
