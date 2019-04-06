package com.dataConnection.Sep4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClient;

@Configuration
public class AppConfig {

  /*
   * Use the standard Mongo driver API to create a com.mongodb.MongoClient instance.
   */
   public @Bean MongoClient mongoClient() {
       return new MongoClient("localhost");
   }
}
