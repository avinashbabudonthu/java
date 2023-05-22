package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.SerializableFunction;
import org.apache.beam.sdk.values.PCollection;

import lombok.extern.slf4j.Slf4j;

@Slf4j
class MyFilter implements SerializableFunction<String, Boolean> {

	private static final long serialVersionUID = 4598298001341443671L;

	@Override
	public Boolean apply(String input) {
		log.info("input: {}", input);
		String[] lineArray = input.split(",");
		return lineArray[1].startsWith("a");
	}

}

public class FilterExample {

	public static void main(String[] args) {
		Pipeline pipeline = Pipeline.create();
		PCollection<String> pCollection1 = pipeline
				.apply(TextIO.read().from("C:\\practice-projects\\apache-beam\\hello-world\\files\\input.csv"));
		PCollection<String> pCollection2 = pCollection1.apply(Filter.by(new MyFilter()));
		pCollection2.apply(TextIO.write().to("C:\\practice-projects\\apache-beam\\hello-world\\files\\output.csv")
				.withHeader("Id,Name").withNumShards(1).withSuffix(".csv"));

		pipeline.run();
	}

}