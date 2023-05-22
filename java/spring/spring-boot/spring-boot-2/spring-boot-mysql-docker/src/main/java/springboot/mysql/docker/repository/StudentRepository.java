package springboot.mysql.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.mysql.docker.entity.StudentEntity;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, String> {

}
