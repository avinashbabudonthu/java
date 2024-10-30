package com.java;

import com.java.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Date;

@Slf4j
public class LombokTest {

    @Test
    void builderWithToBuilderTrue() {
        Student student = Student.builder()
                .id(1)
                .name("a")
                .joiningDate(new Date())
                .build();
        // student=Student(id=1, name=a, joiningDate=Wed Oct 30 14:50:49 IST 2024)
        log.info("student={}", student);

        student.toBuilder()
                .name("b")
                .build();
        // student=Student(id=1, name=a, joiningDate=Wed Oct 30 14:50:49 IST 2024)
        log.info("student={}", student);

        student = student.toBuilder()
                .name("b")
                .build();
        // student=Student(id=1, name=b, joiningDate=Wed Oct 30 14:50:49 IST 2024)
        log.info("student={}", student);
    }
}
