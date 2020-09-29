package com.dataConnection.Sep4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Sep4ApplicationClient {
	public static void main(String[] args) {

		SpringApplication.run(Sep4ApplicationClient.class, args);
		System.out.println(" Welcome to Java Extractor");
	}
}
