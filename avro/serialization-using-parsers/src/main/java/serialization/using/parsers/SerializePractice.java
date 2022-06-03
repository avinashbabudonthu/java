package serialization.using.parsers;

import java.io.File;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumWriter;
import org.junit.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SerializePractice {

	@SneakyThrows
	@Test
	public void serialize() {
		String filePath = "C:\\practice-projects\\others\\avro\\serialization-using-parsers\\src\\main\\resources\\emp.avsc";
		String destinationFilePath = "C:\\practice-projects\\others\\avro\\serialization-using-parsers\\files\\emp.txt";

		Schema schema = new Schema.Parser().parse(new File(filePath));
		GenericRecord employee1 = new GenericData.Record(schema);
		employee1.put("name", "Ava");
		employee1.put("id", 1);
		employee1.put("age", 21);
		employee1.put("salary", 12345);
		employee1.put("address", "address-1");

		GenericRecord employee2 = new GenericData.Record(schema);
		employee2.put("name", "Amelia");
		employee2.put("id", 1);
		employee2.put("age", 21);
		employee2.put("salary", 12345);
		employee2.put("address", "address-1");

		GenericRecord employee3 = new GenericData.Record(schema);
		employee3.put("name", "Avery");
		employee3.put("id", 1);
		employee3.put("age", 21);
		employee3.put("salary", 12345);
		employee3.put("address", "address-1");

		DatumWriter<GenericRecord> employeeDatumWriter = new GenericDatumWriter<>(schema);
		DataFileWriter<GenericRecord> employeeDataFileWriter = new DataFileWriter<>(employeeDatumWriter);
		employeeDataFileWriter.create(schema, new File(destinationFilePath));
		employeeDataFileWriter.append(employee1);
		employeeDataFileWriter.append(employee2);
		employeeDataFileWriter.append(employee3);

		employeeDataFileWriter.close();

		log.info("data serialized");
	}

}
