package serialization.practice;

import java.io.File;

import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import org.junit.Test;

import emp.schema.classes.Employee;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Serialization {

	@SneakyThrows
	@Test
	public void serialize() {
		Employee employee1 = Employee.newBuilder().setId(1).setName("Ava").setAge(21).setSalary(12345)
				.setAddress("address-1").build();
		Employee employee2 = Employee.newBuilder().setId(2).setName("Amelia").setAge(21).setSalary(12345)
				.setAddress("address-1").build();
		Employee employee3 = Employee.newBuilder().setId(3).setName("Avery").setAge(21).setSalary(12345)
				.setAddress("address-1").build();
		String absoluteFilePath = "C:\\practice-projects\\others\\avro\\serialization-by-generating-class\\files\\Employee.avro";

		DatumWriter<Employee> employeeDatumWriter = new SpecificDatumWriter<>(Employee.class);
		DataFileWriter<Employee> employeeDataFileWriter = new DataFileWriter<>(employeeDatumWriter);

		employeeDataFileWriter.create(employee1.getSchema(), new File(absoluteFilePath));
		employeeDataFileWriter.append(employee1);
		employeeDataFileWriter.append(employee2);
		employeeDataFileWriter.append(employee3);

		employeeDataFileWriter.close();

		log.info("data serialized");
	}
}
