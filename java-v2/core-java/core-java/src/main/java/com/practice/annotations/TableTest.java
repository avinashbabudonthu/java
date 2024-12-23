package com.practice.annotations;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

@Slf4j
public class TableTest {

    /**
     * field name=column1
     * isColumnAnnotationPresent=true
     * length=1
     * annotation name=jdk.proxy2.$Proxy10
     * columnAnnotation=@com.practice.annotations.Column(name="col_1", date="27-08-2019", aliasNames={"column_1", "column1"})
     * name=col_1, date=27-08-2019, aliasNames=[column_1, column1]
     * method.name=name, value=col_1
     * method.name=date, value=27-08-2019
     * method.name=aliasNames, value=[column_1, column1]
     * column2Annotation=@com.practice.annotations.Column(name="unknown", date="23-Dec-2024", aliasNames={"column_2", "COLUMN_2"})
     */
    @Test
    public void fieldAnnotation() throws NoSuchFieldException, InvocationTargetException, IllegalAccessException {
        Class<Table> tableClass = Table.class;

        Field column1Field = tableClass.getDeclaredField("column1");
        log.info("field name={}", column1Field.getName());

        boolean isColumnAnnotationPresent = column1Field.isAnnotationPresent(Column.class);
        log.info("isColumnAnnotationPresent={}", isColumnAnnotationPresent);

        Annotation[] column1FieldAnnotations = column1Field.getAnnotations();
        log.info("length={}", column1FieldAnnotations.length);
        Arrays.stream(column1FieldAnnotations).forEach(column1FieldAnnotation -> {
            log.info("annotation name={}", column1FieldAnnotation.getClass().getName());
        });

        Column columnAnnotation= column1Field.getAnnotation(Column.class);
        log.info("columnAnnotation={}", columnAnnotation);
        log.info("name={}, date={}, aliasNames={}", columnAnnotation.name(),
                columnAnnotation.date(), columnAnnotation.aliasNames());
        Method[] methods = columnAnnotation.annotationType().getDeclaredMethods();
        for(Method method: methods) {
            log.info("method.name={}, value={}", method.getName(), method.invoke(columnAnnotation));
        }

        // column2
        Field column2Field = tableClass.getDeclaredField("column2");
        Column column2Annotation = column2Field.getAnnotation(Column.class);
        log.info("column2Annotation={}", column2Annotation);
    }

}
