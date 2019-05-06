package com.dataConnection.Sep4.mongo;


import org.springframework.data.mongodb.repository.MongoRepository;


public interface TemperatureMongoRepository extends MongoRepository<TemperatureMongo, String> {

}
