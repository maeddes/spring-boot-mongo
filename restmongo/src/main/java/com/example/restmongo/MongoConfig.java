package com.example.restmongo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableMongoRepositories(basePackages = "com.example")
public class MongoConfig{

    /* 
    private final List<Converter<?, ?>> converters = new ArrayList<Converter<?, ?>>();

    @Override
    protected String getDatabaseName() {
        return "spring";
    }

    @Override
    public Collection<String> getMappingBasePackages() {
        return Collections.singleton("com.example");
    }

    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }
    */
}
