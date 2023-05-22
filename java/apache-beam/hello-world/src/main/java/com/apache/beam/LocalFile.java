package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.values.PCollection;

public class LocalFile {

    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();

        // to achieve transform we need to use apply method
        PCollection<String> pCollection1 = pipeline.apply(TextIO.read().from("C:\\practice-projects\\apache-beam\\hello-world\\files\\returns.csv"));

        // create output.csv
        pCollection1.apply(
                TextIO.write().to("C:\\practice-projects\\apache-beam\\hello-world\\files\\output.csv")
                .withNumShards(1).withSuffix(".csv")
                );

        pipeline.run();
    }
}
