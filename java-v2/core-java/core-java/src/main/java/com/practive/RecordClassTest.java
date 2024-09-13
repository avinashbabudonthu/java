package com.practive;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@Slf4j
@SuppressWarnings("all")
public class RecordClassTest {

    private record Student(Integer id, String name, String course){}

    @Test
    void method1(){
        Student student = new Student(1, "a", "c1");
        // [RecordClassTest.method1] - student, id=1, name=a, course=c1
        log.info("student, id={}, name={}, course={}", student.id(), student.name(), student.course());
    }

    // with compact constructor
    private record Employee(Long id, String name, String dept){
        public Employee {
            if(null == id || name == null || dept == null)
                throw new RuntimeException("Missing id or name or dept");
        }
    }

    /**
     * [RecordClassTest.method2] - exception message=Missing id or name or dept
     */
    @Test
    void method2() {
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            Employee employee = new Employee(null, "a", "d1");
        });
        log.info("exception message={}", exception.getMessage());
    }

    // with static fields, static initializers and toString
    private record Employee2(Long id, String name, String dept){
        private static String address;

        static {
            if(address == null) {
                address = "UNKNOWN";
            }
        }

        public Employee2 {
            if(null == id || name == null || dept == null)
                throw new RuntimeException("Missing id or name or dept");
        }

        @Override
        public String toString() {
            return "Employee2 {" +
                    "id=" + id +
                    ", name='" + name + "'" +
                    ", dept='" + dept + "'" +
                    ", address='" + address + "'" +
                    '}';
        }
    }

    /**
     * [RecordClassTest.method3] - employee=Employee2 {id=1, name='a', dept='d1', address='UNKNOWN'}
     */
    @Test
    void method3() {
        Employee2 employee = new Employee2(1L, "a", "d1");
        log.info("employee={}", employee);
    }

}