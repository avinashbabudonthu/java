package com.cerebro.batch;

@lombok.extern.slf4j.Slf4j
@org.springframework.stereotype.Component
public class ContentWriter implements org.springframework.batch.item.ItemWriter<com.cerebro.model.ContentModel> {

    @Override
    public void write(java.util.List<? extends com.cerebro.model.ContentModel> list) throws Exception {
        log.info("users={}", list);
    }
}