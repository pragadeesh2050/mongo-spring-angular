package com.experiment.mongoexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.experiment.mongoexample")
public class MongoexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoexampleApplication.class, args);
	}

}
