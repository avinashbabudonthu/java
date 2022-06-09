package com.cerebro.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;

@org.springframework.context.annotation.Configuration
@org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
public class AppConfig {

    @org.springframework.context.annotation.Bean
    public Job job(org.springframework.batch.core.configuration.annotation.JobBuilderFactory jobBuilderFactory,
                   org.springframework.batch.core.configuration.annotation.StepBuilderFactory stepBuilderFactory,
                   org.springframework.batch.item.ItemReader<com.cerebro.model.UserEntity> itemReader,
                   org.springframework.batch.item.ItemProcessor<com.cerebro.model.UserEntity, com.cerebro.model.UserEntity> itemProcessor,
                   org.springframework.batch.item.ItemWriter<com.cerebro.model.UserEntity> itemWriter){
        Step step = stepBuilderFactory.get("csvFileLoad")
                .<com.cerebro.model.UserEntity, com.cerebro.model.UserEntity>chunk(100)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        // if we don't have multiple steps
        return jobBuilderFactory.get("csvReaderJob")
                .incrementer(new org.springframework.batch.core.launch.support.RunIdIncrementer())
                .start(step).build();

        // if we have multiple steps
        /*return jobBuilderFactory.get("csvReader").incrementer(new org.springframework.batch.core.launch.support.RunIdIncrementer())
                .flow(step).next(step).build();*/
    }

    @org.springframework.context.annotation.Bean
    public FlatFileItemReader<com.cerebro.model.UserEntity> itemReader(@org.springframework.beans.factory.annotation.Value("${app.input}")org.springframework.core.io.Resource resource){
        FlatFileItemReader<com.cerebro.model.UserEntity> flatFileItemReader = new org.springframework.batch.item.file.FlatFileItemReader<>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("csv-reader");
        flatFileItemReader.setLinesToSkip(1); // skip 1st line because it is header
        flatFileItemReader.setLineMapper(lineMapper());

        return flatFileItemReader;
    }

    @org.springframework.context.annotation.Bean
    public LineMapper<com.cerebro.model.UserEntity> lineMapper(){
        DefaultLineMapper<com.cerebro.model.UserEntity> defaultLineMapper = new org.springframework.batch.item.file.mapping.DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "name", "dept", "salary");

        BeanWrapperFieldSetMapper<com.cerebro.model.UserEntity> beanWrapperFieldSetMapper = new org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(com.cerebro.model.UserEntity.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        return defaultLineMapper;
    }
}