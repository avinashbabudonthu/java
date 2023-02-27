package com.app.repository;

import com.app.entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {

    // find by name
    List<Student> findByName(String name);

    @Query("{\"name\": \"?0\"}")
    List<Student> findByNameByNativeQuery(String name);

    // find by name and email
    List<Student> findByNameAndEmail(String name, String email);

    List<Student> findByNameOrEmail(String name, String email);

    List<Student> findByDepartmentName(String departmentName);

    List<Student> findByEmailLike(String email);

    List<Student> findByNameStartsWith(String name);

}