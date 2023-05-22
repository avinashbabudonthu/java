package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;

/**
 * Group customers by id
 * sum the amount paid by that customer
 */
public class GroupByKeyExample {

    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();

        // Step 1 - read input file
        PCollection<String> pCollectionCustomerOrders = pipeline.apply(TextIO.read().from(com.apache.beam.Constants.INPUT_OUTPUT_FILES_PATH + "customer-orders.csv"));

        // Step 2 - transform to key, value where key == id, value == amount
        PCollection<KV<String, Long>> pCollectionCustomerIdToAmount = pCollectionCustomerOrders.apply(ParDo.of(new DoFn<String, KV<String, Long>>() {
            @ProcessElement
            public void process(ProcessContext processContext) {
                String[] row = processContext.element().split(",");
                String id = row[0];

                if (!"id".equals(id)) {
                    Long amount = Long.parseLong(row[2]);
                    processContext.output(KV.of(id, amount));
                }
            }

        }));

        // step 3 - apply GroupByKey and build KV<String, Iterable<Long>>
        PCollection<KV<String, Iterable<Long>>> pCollectionGroupById = pCollectionCustomerIdToAmount.apply(org.apache.beam.sdk.transforms.GroupByKey.<String, Long>create());

        // step 4 - sum the elements of each key
        PCollection<String> pCollectionSums = pCollectionGroupById.apply(ParDo.of(new DoFn<KV<String, Iterable<Long>>, String>() {

            @ProcessElement
            public void process(ProcessContext processContext) {
                String key = processContext.element().getKey();
                Iterable<Long> values = processContext.element().getValue();
                Long sum = 0L;
                for (Long value : values) {
                    sum = sum + value;
                }

                processContext.output(key + "," + sum.toString());
            }

        }));

        pCollectionSums.apply(TextIO.write().to(com.apache.beam.Constants.INPUT_OUTPUT_FILES_PATH + "output.csv").withNumShards(1).withSuffix(".csv"));

        pipeline.run();
    }
}
