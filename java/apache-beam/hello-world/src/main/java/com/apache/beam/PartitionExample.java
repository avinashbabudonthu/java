package com.apache.beam;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.Partition;
import org.apache.beam.sdk.transforms.Partition.PartitionFn;
import org.apache.beam.sdk.values.PCollection;
import org.apache.beam.sdk.values.PCollectionList;

class MyPartition implements PartitionFn<String>{

    @Override
    public int partitionFor(String elem, int numPartitions) {
        String[] array = elem.split(",");

        if(array[1].startsWith("j")){
            return 0;
        }else if(array[1].startsWith("a")){
            return 1;
        }else{
            return 2;
        }
    }

}

public class PartitionExample {

    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();
        PCollection<String> pCollection1 = pipeline.apply(TextIO.read().from("C:\\practice-projects\\apache-beam\\hello-world\\files\\input.csv"));
        PCollectionList<String> pCollectionList = pCollection1.apply(Partition.of(3, new MyPartition()));

        PCollection<String> pCollection2 = pCollectionList.get(0);
        PCollection<String> pCollection3 = pCollectionList.get(1);
        PCollection<String> pCollection4 = pCollectionList.get(2);
    }
}