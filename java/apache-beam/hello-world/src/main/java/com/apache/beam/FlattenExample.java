package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Flatten;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionList;

public class FlattenExample {

	public static void main(String[] args) {
		Pipeline pipeline = Pipeline.create();

		PCollection<String> pCollection1 = pipeline
				.apply(TextIO.read().from("C:\\practice-projects\\apache-beam\\hello-world\\files\\input.csv"));
		PCollection<String> pCollection2 = pipeline
				.apply(TextIO.read().from("C:\\practice-projects\\apache-beam\\hello-world\\files\\input2.csv"));
		PCollection<String> pCollection3 = pipeline
				.apply(TextIO.read().from("C:\\practice-projects\\apache-beam\\hello-world\\files\\input3.csv"));

		PCollectionList<String> pCollectionList = PCollectionList.of(pCollection1).and(pCollection2).and(pCollection3);
		PCollection<String> pCollection4 = pCollectionList.apply(Flatten.pCollections());
		pCollection4.apply(TextIO.write().to("C:\\practice-projects\\apache-beam\\hello-world\\files\\output.csv")
				.withNumShards(1).withSuffix(".csv"));

		pipeline.run();
	}
}
