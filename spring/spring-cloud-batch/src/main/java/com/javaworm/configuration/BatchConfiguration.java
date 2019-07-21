package com.javaworm.configuration;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.javaworm.itemprocessor.FurnitureItemProcessor;
import com.javaworm.listener.JobCompletionNotificationListener;
import com.javaworm.model.Furniture;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {
	
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;
    
    @Bean
    public FlatFileItemReader<Furniture> reader() {
        return new FlatFileItemReaderBuilder<Furniture>()
            .name("furnitureItemReader")
            .resource(new ClassPathResource("sample-data.csv"))
            .delimited()
            .names(new String[]{"name", "price"})
            .fieldSetMapper(new BeanWrapperFieldSetMapper<Furniture>() {{
                setTargetType(Furniture.class);
            }})
            .build();
    }
    
    
    @Bean
    public FurnitureItemProcessor processor() {
        return new FurnitureItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<Furniture> writer(DataSource dataSource) {
        return new JdbcBatchItemWriterBuilder<Furniture>()
            .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
            .sql("INSERT INTO furniture (name, price) VALUES (:name, :price)")
            .dataSource(dataSource)
            .build();
    }
    
    
    @Bean
    public Job importUserJob(JobCompletionNotificationListener listener, Step step1) {
        return jobBuilderFactory.get("importUserJob")
            .incrementer(new RunIdIncrementer())
            .listener(listener)
            .flow(step1)
            .end()
            .build();
    }

    @Bean
    public Step step1(JdbcBatchItemWriter<Furniture> writer) {
        return stepBuilderFactory.get("step1")
            .<Furniture, Furniture> chunk(10)
            .reader(reader())
            .processor(processor())
            .writer(writer)
            .build();
    }
    
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
