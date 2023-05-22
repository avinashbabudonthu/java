package com.serialization;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class Serialize {

	/**
	 * @see DeSerialize#readEmployee()
	 */
	@Test
	public void saveEmployeeObject() {
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				Files.newOutputStream(Paths.get("src/main/resources/emp.dat")))) {
			Employee employee = Employee.builder().id("1").grade(3.5).build();
			objectOutputStream.writeObject(employee);
		} catch (IOException e) {
			log.error("exception", e);
		}
	}
}
