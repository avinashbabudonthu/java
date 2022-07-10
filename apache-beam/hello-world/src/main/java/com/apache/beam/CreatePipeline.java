package com.apache.beam;


import org.apache.beam.sdk.Pipeline;

public class CreatePipeline {

    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();
        System.out.println("Done");
        System.out.println(pipeline);
    }

}