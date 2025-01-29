package com.serialization;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

@Slf4j
public class SerializationTest {

    /**
     * studentModel1 object=StudentModel(id=1, name=a)
     * Creating file
     * File created=true, file-path=[path-value]
     * Serializing student model
     * De-serializing student model
     * de-serialized studentModel1 object=StudentModel(id=1, name=a)
     */
    @Test
    void serialize() throws IOException, ClassNotFoundException {
        StudentModel studentModel1 = new StudentModel();
        studentModel1.setId(1);
        studentModel1.setName("a");
        log.info("studentModel1 object={}", studentModel1);

        log.info("Creating file");
        File file = new File(
                "C:\\github\\java\\java-v2\\core-java\\core-java\\files\\file-" + UUID.randomUUID() + ".txt");
        boolean isFile2Created = file.createNewFile();
        log.info("File created={}, file-path={}", isFile2Created, file.getAbsolutePath());

        log.info("Serializing student model");
        writeObject(studentModel1, file);

        log.info("De-serializing student model");
        StudentModel studentModel2 = readObject(file);
        log.info("de-serialized studentModel1 object={}", studentModel2);
    }

    private void writeObject(StudentModel studentModel, File file) throws IOException {
        try(FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(studentModel);
            objectOutputStream.flush();
        }
    }

    private StudentModel readObject(File file) throws IOException, ClassNotFoundException{
        StudentModel studentModel;
        try(FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            studentModel = (StudentModel) objectInputStream.readObject();
        }
        return studentModel;
    }
}
