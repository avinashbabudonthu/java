package com.custom.annotations;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

//@Slf4j
public class TableTest {

    private Logger log = LoggerFactory.getLogger(TableTest.class);

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

    @Test
    public void setAnnotationPropertyValueUsingReflection() throws Exception {
        Field column1Field = Table.class.getDeclaredField("column1");
        Column columnAnnotation= column1Field.getAnnotation(Column.class);
        log.info("columnAnnotation={}", columnAnnotation);

        Field[] fields = columnAnnotation.annotationType().getDeclaredFields();
        for(Field field : fields) {
            log.info("field.name={}", field.getName());
        }

        Method[] methods = columnAnnotation.annotationType().getDeclaredMethods();
        for(Method method: methods) {
            log.info("method.name={}, value={}", method.getName(), method.invoke(columnAnnotation));
        }

//        Method method = Class.class.getDeclaredMethod("annotationData");
//        method.setAccessible(true);
        //Since AnnotationData is a private class we cannot create a direct reference to it. We will have to
        //manage with just Object
//        Object annotationData = method.invoke(columnAnnotation);
        //We now look for the map called "annotations" within AnnotationData object.
//        Field annotations = annotationData.getClass().getDeclaredField("annotations");
//        annotations.setAccessible(true);
//        Map<Class<? extends Annotation>, Annotation> map =
//                (Map<Class<? extends Annotation>, Annotation>) annotations.get(annotationData);
//        map.put(columnAnnotation, null);
//        System.out.println(field);
//        field.setAccessible(true);
//        Map<Class<? extends Annotation>, Annotation> annotations = (Map<Class<? extends Annotation>, Annotation>) field.get(Column.class);
//        annotations.put(Column.class, newAnnotation);
    }
}
