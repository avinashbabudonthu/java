package com.custom.annotations;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;

@Slf4j
public class TableTest {

    @Test
    public void fieldAnnotation() throws NoSuchFieldException{
        Class<Table> tableClass = Table.class;
        Field column1Field = tableClass.getDeclaredField("column1");

        log.info("field name={}", column1Field.getName());

        Annotation[] column1FieldAnnotations = column1Field.getAnnotations();
        log.info("length={}", column1FieldAnnotations.length);

        Column columnAnnotation= column1Field.getAnnotation(Column.class);
        log.info("columnAnnotation={}", columnAnnotation);
        log.info("name={}, date={}, aliasNames={}", columnAnnotation.name(),
                columnAnnotation.date(), columnAnnotation.aliasNames());

        Arrays.stream(column1FieldAnnotations).forEach(column1FieldAnnotation -> {
            log.info("annotation name={}", column1FieldAnnotation.getClass().getName());
        });
    }
}
