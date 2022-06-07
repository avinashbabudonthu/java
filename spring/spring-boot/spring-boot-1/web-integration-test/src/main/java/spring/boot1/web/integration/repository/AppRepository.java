package spring.boot1.web.integration.repository;

import org.springframework.stereotype.Repository;
import spring.boot1.web.integration.model.Student;

import java.util.Arrays;
import java.util.List;

@Repository
public class AppRepository {

    public List<Student> findAllStudens(){
        Student student1 = Student.builder().id(1L).name("jack").grade(3.24).build();
        Student student2 = Student.builder().id(2L).name("jill").grade(3.25).build();
        Student student3 = Student.builder().id(3L).name("jim").grade(3.26).build();

        return Arrays.asList(student1, student2, student3);
    }
}
