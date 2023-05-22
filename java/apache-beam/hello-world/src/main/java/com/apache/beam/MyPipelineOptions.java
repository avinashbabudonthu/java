package com.apache.beam;

import org.apache.beam.sdk.options.PipelineOptions;

public interface MyPipelineOptions extends PipelineOptions {

    void setInputFile(String inputFile);
    String getInputFile();

    void setOutputFile(String outputFile);
    String getOutputFile();

    void setExtension(String extension);
    String getExtension();

}