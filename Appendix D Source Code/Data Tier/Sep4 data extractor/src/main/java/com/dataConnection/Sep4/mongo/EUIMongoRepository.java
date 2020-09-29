package com.dataConnection.Sep4.mongo;


import com.dataConnection.Sep4.mongo.MongoModel.EUIMongo;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface EUIMongoRepository extends MongoRepository<EUIMongo, String> {
}
