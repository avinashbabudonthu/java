package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.values.PCollection;

public class PrintElementsInPCollection {

    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();

        PCollection<String> pCollectionCustomers = pipeline.apply(org.apache.beam.sdk.io.TextIO.read().from(com.apache.beam.Constants.INPUT_OUTPUT_FILES_PATH + "customers.csv"));

        pCollectionCustomers.apply(org.apache.beam.sdk.transforms.ParDo.of(new org.apache.beam.sdk.transforms.DoFn<String, Void>() {

            @ProcessElement
            public void process(ProcessContext processContext){
                System.out.println(processContext.element());
            }

        }));

        pipeline.run();
    }
}
