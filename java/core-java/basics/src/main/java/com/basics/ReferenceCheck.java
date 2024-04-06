package com.basics;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReferenceCheck {

    private static final Logger log = LoggerFactory.getLogger(ReferenceCheck.class);

    @Test
    public void referenceCheck() {
        Course course = new Course();
        course.setName("java");
        course.setGrade(4.10D);
//        Student student = Student.builder()
//                .id(1)
//                .name("Ram")
//                .course(course)
//                .build();
        Student student = new Student();
        student.setId(1);
        student.setName("Ram");
        student.setCourse(course);

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
