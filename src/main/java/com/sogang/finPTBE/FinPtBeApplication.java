package com.sogang.finPTBE;

import com.sogang.finPTBE.utils.secUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.sogang.finPTBE.repository",
		mongoTemplateRef = "studioMongoTemplate")
public class FinPtBeApplication {
	//TODO SEC API

	public static void main(String[] args) {
		System.out.println(SpringApplication.run(FinPtBeApplication.class, args).getBean(secUtil.class).getCikByTicker("GOOGL"));
	}

}
