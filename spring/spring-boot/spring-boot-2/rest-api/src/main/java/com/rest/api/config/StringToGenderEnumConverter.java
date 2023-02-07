package com.rest.api.config;

import com.rest.api.util.GenderEnum;
import org.springframework.core.convert.converter.Converter;

@ParameterConverter
public class StringToGenderEnumConverter implements Converter<String, GenderEnum> {

    @Override
    public GenderEnum convert(String s) {
        return GenderEnum.getGender(s);
    }

//    @Override
//    public JavaType getInputType(TypeFactory typeFactory) {
//        return SimpleType.constructUnsafe(String.class);
//    }
//
//    @Override
//    public JavaType getOutputType(TypeFactory typeFactory) {
//        return SimpleType.constructUnsafe(GenderEnum.class);
//    }
}
