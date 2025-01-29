package com.serialization;

import lombok.Data;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serial;
import java.io.Serializable;

@Data
public class StudentModel implements Serializable {


    @Serial
    private static final long serialVersionUID = 2212582558567071472L;

    private Integer id;
    private String name;

    public void defaultWriteObject(ObjectOutputStream objectOutputStream) {
        System.out.println("serializing");
    }

    public void defaultReadObject(ObjectInputStream objectInputStream) {
        System.out.println("de-serializing");
    }

}