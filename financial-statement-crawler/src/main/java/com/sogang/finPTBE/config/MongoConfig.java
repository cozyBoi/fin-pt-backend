package com.sogang.finPTBE.config;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;

@Configuration
public class MongoConfig {
    @Primary
    @Bean(name = "studioMongoProperties")
    @ConfigurationProperties(prefix = "spring.data.mongodb")
    public MongoProperties getStudioMongo() {
        return new MongoProperties();
    }

    @Primary
    @Bean(name = "studioMongoTemplate")
    public MongoTemplate studioMongoTemplate() throws Exception {
        return new MongoTemplate(studioFactory(getStudioMongo()));
    }

    @Bean
    @Primary
    public MongoDatabaseFactory studioFactory(MongoProperties mongo) throws Exception {
        return new SimpleMongoClientDatabaseFactory(mongo.getUri());
    }
}