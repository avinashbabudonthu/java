package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class CustomerFilter extends DoFn<String, String> {

	private static final long serialVersionUID = 4729118751499987481L;

	@ProcessElement
	public void processElement(ProcessContext processContext) {
		String line = processContext.element();
		log.info("line: {}", line);

		String[] lineArray = line.split(",");
		if (lineArray[1].startsWith("a")) {
			processContext.output(line);
		}
	}
}

public class ParDoExample {

	public static void main(String[] args) {
		Pipeline pipeline = Pipeline.create();
		PCollection<String> pCollection1 = pipeline
				.apply(TextIO.read().from("C:\\practice-projects\\apache-beam\\hello-world\\files\\input.csv"));
		PCollection<String> pCollection2 = pCollection1.apply(ParDo.of(new CustomerFilter()));
		pCollection2.apply(TextIO.write().to("C:\\practice-projects\\apache-beam\\hello-world\\files\\output.csv")
				.withHeader("id,name").withNumShards(1).withSuffix(".csv"));

		pipeline.run();
	}
}