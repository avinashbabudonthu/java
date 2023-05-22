package deserialization.using.parsers;

import java.io.File;

import org.apache.avro.Schema;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.DatumReader;
import org.junit.Test;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeSerializePractice {

	@SneakyThrows
	@Test
	public void deserialize() {
		String filePath = "C:\\practice-projects\\others\\avro\\serialization-using-parsers\\src\\main\\resources\\emp.avsc";
		String destinationFilePath = "C:\\practice-projects\\others\\avro\\serialization-using-parsers\\files\\emp.txt";
		Schema schema = new Schema.Parser().parse(new File(filePath));
		DatumReader<GenericRecord> datumReader = new GenericDatumReader<>(schema);
		DataFileReader<GenericRecord> dataFileReader = new DataFileReader<>(new File(destinationFilePath), datumReader);
		GenericRecord genericRecord = null;

		while (dataFileReader.hasNext()) {
			genericRecord = dataFileReader.next();
			log.info("generic-record={}", genericRecord);
		}

		dataFileReader.close();
	}
}
