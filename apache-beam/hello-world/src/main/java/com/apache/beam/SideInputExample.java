package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.View;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionView;

import java.util.Map;

public class SideInputExample {

    public static void main(String[] args) {

        Pipeline pipeline = Pipeline.create();

        PCollection<KV<String, String>> pCollection1 = pipeline.apply(TextIO.read().from(Constants.INPUT_OUTPUT_FILES_PATH + "returns.csv"))
                .apply(ParDo.of(
                        new DoFn<String, KV<String, String>>() {

                            @ProcessElement
                            public void process(ProcessContext processContext) {
                                String[] arr = processContext.element().split(",");
                                processContext.output(KV.of(arr[0], arr[1]));
                            }
                        }));

        PCollectionView<Map<String, String>> pCollectionView = pCollection1.apply(View.asMap());

        PCollection<String> pCollectionCustomers = pipeline.apply(TextIO.read().from(Constants.INPUT_OUTPUT_FILES_PATH + "customers.csv"));

        pCollectionCustomers.apply(ParDo.of(new DoFn<String, Void>() {

            @ProcessElement
            public void process(ProcessContext processContext) {
                java.util.Map<String, String> returnsMap = processContext.sideInput(pCollectionView);
                String[] arr = processContext.element().split(",");
                String customerName = returnsMap.get(arr[0]);

                if(null == customerName){
                    System.out.println(arr[0] + "," + arr[1]);
                }
            }

        }).withSideInputs(pCollectionView));

        pipeline.run();
    }

}