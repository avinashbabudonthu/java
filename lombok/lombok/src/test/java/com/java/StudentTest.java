package com.java;

import org.junit.Test;

public class StudentTest {

    @Test
    public void student(){
        Student student = new Student();
        student.getId();
        student.getName();
    }

    @Test
    public void nonNullAnnotation(){
        // Student2 student2 = new Student2(); // causes compilation error

        Student2 student2 = new Student2(100L);
        student2.print(null); // java.lang.NullPointerException: course is marked non-null but is null
    }
}
