package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.values.PCollection;

import static org.apache.beam.sdk.io.TextIO.*;

public class PipeLineOptionsExample {

    public static void main(String[] args) {
        MyPipelineOptions myPipelineOptions = PipelineOptionsFactory.fromArgs(args).withValidation().as(MyPipelineOptions.class);

        Pipeline pipeline = Pipeline.create(myPipelineOptions);

        PCollection<String> pCollection1 = pipeline.apply(read().from(myPipelineOptions.getInputFile()));
        pCollection1.apply(write().to(myPipelineOptions.getOutputFile()).withNumShards(1).withSuffix(myPipelineOptions.getExtension()));

        pipeline.run();
    }
}
