package deserialization.practice;

import java.io.File;

import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;
import org.junit.Test;

import emp.schema.classes.Employee;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeserializationPractice {

	@SneakyThrows
	@Test
	public void deserialize() {
		String absoluteFilePath = "C:\\practice-projects\\others\\avro\\serialization-by-generating-class\\files\\Employee.avro";
		DatumReader<Employee> employeeDatumReader = new SpecificDatumReader<>(Employee.class);
		DataFileReader<Employee> employeeDataFileReader = new DataFileReader<>(new File(absoluteFilePath),
				employeeDatumReader);
		Employee employee = null;
		while (employeeDataFileReader.hasNext()) {
			employee = employeeDataFileReader.next();
			log.info("employee={}", employee);
		}

		employeeDataFileReader.close();
	}
}
