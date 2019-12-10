package com.onlineShoping.demo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
public class MongoDBCustomConfig extends AbstractMongoClientConfiguration {

	@Value("${spring.data.mongodb.database}")
	String dbName;

	@Value("${spring.data.mongodb.host}")
	String host;

	@Value("${spring.data.mongodb.port}")
	Integer port;

	@Bean
	MongoTransactionManager transactionManager(MongoDbFactory dbFactory) {
		return new MongoTransactionManager(dbFactory);
	}

	@Override
	@Bean
	public MongoClient mongoClient() {
		// TODO Auto-generated method stub

		MongoClient mongoClient = MongoClients.create(MongoClientSettings.builder()
				.applyToClusterSettings(builder -> builder.hosts(Arrays.asList(new ServerAddress(host, port))))
				.build());
		return mongoClient;

	}

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return dbName;
	}

}
