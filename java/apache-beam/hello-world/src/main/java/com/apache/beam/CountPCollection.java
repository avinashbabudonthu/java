package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.PCollection;

public class CountPCollection {

    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();

        PCollection<String> pCollectionCustomers = pipeline.apply(TextIO.read().from(Constants.INPUT_OUTPUT_FILES_PATH + "customers.csv"));
        PCollection<Long> pCollectionLong = pCollectionCustomers.apply(Count.globally());
        pCollectionLong.apply(ParDo.of(new DoFn<Long, Void>() {

            @org.apache.beam.sdk.transforms.DoFn.ProcessElement
            public void process(ProcessContext processContext){
                System.out.println("number-of-elements: "+processContext.element());
            }

        }));

        pipeline.run();
    }
}
