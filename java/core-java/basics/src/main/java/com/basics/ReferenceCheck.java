package com.basics;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ReferenceCheck {

    @Test
    public void referenceCheck() {
        Course course = Course.builder().name("java").grade(4.0D).build();
        Student student = Student.builder()
                .id(1)
                .name("Ram")
                .course(course)
                .build();
        // before - student=Student(id=1, name=Ram, course=Course(name=java, grade=4.0))
        log.info("before - student={}", student);
        setCourseToNull(student.getCourse());
        //after1 - student=Student(id=1, name=Ram, course=Course(name=java, grade=4.0))
        log.info("after1 - student={}", student);
        setCourseNameToNull(student.getCourse().getName());
        //after2 - student=Student(id=1, name=Ram, course=Course(name=java, grade=4.0))
        log.info("after2 - student={}", student);
        setCourseNameToNull(course);
        //after3 - student=Student(id=1, name=Ram, course=Course(name=null, grade=4.0))
        log.info("after3 - student={}", student);
        setCourseToNull(student);
        // after4 - student=Student(id=1, name=Ram, course=null)
        log.info("after4 - student={}", student);
    }

    private void setCourseToNull(Course course) {
        course = null;
    }

    private void setCourseToNull(Student student) {
        student.setCourse(null);
    }

    private void setCourseNameToNull(String courseName) {
        courseName = null;
    }

    private void setCourseNameToNull(Course course) {
        course.setName(null);
    }
}
