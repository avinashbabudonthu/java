package com.cerebro.component;

import java.io.BufferedReader;
import java.io.File;
import java.io.RandomAccessFile;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Component
public class CustomItemReader implements org.springframework.batch.item.ItemReader<com.cerebro.model.ContentModel> {

    private List<com.cerebro.model.ContentModel> contentModelList;
    private int nextIndex;
    @org.springframework.beans.factory.annotation.Value("${app.input}")
    private String filePath;

    public CustomItemReader(){
        initializeV2();
    }

    // read using RandomAccessFile
    @lombok.SneakyThrows
    private void initializeV1(){
        int position = 0;
        RandomAccessFile randomAccessFile = new RandomAccessFile(filePath, "r");
        randomAccessFile.seek(position);
        byte[] bytes = new byte[1024];
        randomAccessFile.read(bytes);
        randomAccessFile.close();
    }

    @lombok.SneakyThrows
    private void initializeV2(){
        URL url = getClass().getClassLoader().getResource("file1.txt");
        File file = new File(url.getPath());
        contentModelList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(file));) {
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                com.cerebro.model.ContentModel contentModel = new com.cerebro.model.ContentModel();
                contentModel.setContent(line);
                contentModelList.add(contentModel);
            }
        }
        nextIndex = 0;
    }

    @Override
    public com.cerebro.model.ContentModel read() throws Exception {
        com.cerebro.model.ContentModel contentModel = null;

        if(nextIndex < contentModelList.size()){
            contentModel = contentModelList.get(nextIndex);
            nextIndex++;
        }else {
            nextIndex = 0;
        }

        return contentModel;
    }

}