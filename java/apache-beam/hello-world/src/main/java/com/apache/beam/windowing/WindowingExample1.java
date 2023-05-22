package com.apache.beam.windowing;

import com.apache.beam.Constants;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.PCollection;
import org.joda.time.Duration;

public class WindowingExample1 {

    public static void main(String[] args) {
        Pipeline pipeline = Pipeline.create();

        PCollection<String> pCollectionInput = pipeline.apply(TextIO.read().from(Constants.INPUT_OUTPUT_FILES_PATH + "input4.csv"));

        pCollectionInput.apply(Window.into(FixedWindows.of(Duration.millis(1000))));
        pipeline.run();
    }
}
