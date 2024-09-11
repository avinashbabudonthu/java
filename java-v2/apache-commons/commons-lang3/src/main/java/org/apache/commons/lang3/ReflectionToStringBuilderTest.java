package org.apache.commons.lang3;

import com.java.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;

@Slf4j
public class ReflectionToStringBuilderTest {

    record Student2(Integer id, String name,String course){}

    @Test
    void toStringTest() {
        Student student = Student.builder().id(1).name("a").course("c1").build();
        String studentToString = ReflectionToStringBuilder.toString(student, ToStringStyle.JSON_STYLE);
        // {"course":"c1","id":1,"name":"a"}
        log.info("{}", studentToString);

        String studentToString2 = ReflectionToStringBuilder.toString(student, ToStringStyle.SIMPLE_STYLE);
        // c1,1,a
        log.info("{}", studentToString2);

        Student2 student2 = new Student2(2, "b", "c2");
        String output3 = ReflectionToStringBuilder.toString(student2, ToStringStyle.JSON_STYLE);
        // {"course":"c2","id":2,"name":"b"}
        log.info("{}", output3);
    }
}
