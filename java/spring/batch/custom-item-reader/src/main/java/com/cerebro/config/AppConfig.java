package com.cerebro.config;

@org.springframework.context.annotation.Configuration
@org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
public class AppConfig {

    @org.springframework.beans.factory.annotation.Autowired
    private com.cerebro.component.CustomItemReader customItemReader;

    @org.springframework.context.annotation.Bean
    public org.springframework.batch.core.Job job(org.springframework.batch.core.configuration.annotation.JobBuilderFactory jobBuilderFactory,
                                                  org.springframework.batch.core.configuration.annotation.StepBuilderFactory stepBuilderFactory,
                                                  org.springframework.batch.item.ItemReader<com.cerebro.model.ContentModel> itemReader,
                                                  org.springframework.batch.item.ItemProcessor<com.cerebro.model.ContentModel, com.cerebro.model.ContentModel> itemProcessor,
                                                  org.springframework.batch.item.ItemWriter<com.cerebro.model.ContentModel> itemWriter){
        org.springframework.batch.core.Step step = stepBuilderFactory.get("csvFileLoad")
                .<com.cerebro.model.ContentModel, com.cerebro.model.ContentModel>chunk(100)
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
    public com.cerebro.component.CustomItemReader itemReader(@org.springframework.beans.factory.annotation.Value("${app.input}")org.springframework.core.io.Resource resource){
        /*org.springframework.batch.item.file.FlatFileItemReader<com.cerebro.model.ContentModel> flatFileItemReader = new org.springframework.batch.item.file.FlatFileItemReader<>();
        flatFileItemReader.setResource(resource);
        flatFileItemReader.setName("csv-reader");
        flatFileItemReader.setLinesToSkip(1); // skip 1st line because it is header
        flatFileItemReader.setLineMapper(lineMapper());
        return flatFileItemReader;*/

       /* com.cerebro.component.CustomItemReader customItemReader = new com.cerebro.component.CustomItemReader();
        return  customItemReader;*/

       return customItemReader;
    }

    @org.springframework.context.annotation.Bean
    public org.springframework.batch.item.file.LineMapper<com.cerebro.model.ContentModel> lineMapper(){
        org.springframework.batch.item.file.mapping.DefaultLineMapper<com.cerebro.model.ContentModel> defaultLineMapper = new org.springframework.batch.item.file.mapping.DefaultLineMapper<>();
        org.springframework.batch.item.file.transform.DelimitedLineTokenizer lineTokenizer = new org.springframework.batch.item.file.transform.DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("id", "name", "dept", "salary");

        org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper<com.cerebro.model.ContentModel> beanWrapperFieldSetMapper = new org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper<>();
        beanWrapperFieldSetMapper.setTargetType(com.cerebro.model.ContentModel.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(beanWrapperFieldSetMapper);

        return defaultLineMapper;
    }
}