package com.rest.api.util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum {

    MALE("male"),
    FEMALE("female");

    private final String value;

    /**
     * To Deserialize (JSON to object) -> this method used to convert String in request body to Enum
     * @param value
     * @return
     */
    @JsonCreator
    public static GenderEnum getGender(String value){
        for(GenderEnum genderEnum : GenderEnum.values()){
            if(value.equalsIgnoreCase(genderEnum.getValue())){
                return genderEnum;
            }
        }
        return null;
    }

    /**
     * this method annotated with @JsonValue is called While serializing (object to JSON)
     * Default enum name will be returned
     */
    @JsonValue
    public String getValue(){
        return this.value;
    }

}