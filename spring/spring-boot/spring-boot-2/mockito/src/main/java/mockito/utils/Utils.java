package mockito.utils;

import java.util.Random;

import org.springframework.stereotype.Component;

import mockito.model.Student;

@Component
public class Utils {

	public Student createStudent() {
		long nextLong = new Random().nextLong();
		return Student.builder().id(nextLong).name("name-" + nextLong).build();
	}
}
