package com.rest.api.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum {

    MALE("male"),
    FEMALE("female");

    private final String value;

    @JsonCreator
    public static GenderEnum getGender(String value){
        for(GenderEnum genderEnum : GenderEnum.values()){
            if(value.equalsIgnoreCase(genderEnum.getValue())){
                return genderEnum;
            }
        }
        return null;
    }

}