package com.dataConnection.Sep4.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection = "CO2")
public class Co2Mongo {


    @Id
    private ObjectId _id;

    @Field("ppm")
    private String ppm;

    public Co2Mongo() {

    }

    @PersistenceConstructor
    public Co2Mongo(String ppm) {

        this.ppm = ppm;
    }
    public String getPpm() {
        return ppm;
    }

    public void setPpm(String ppm) {
        this.ppm = ppm;
    }

    public ObjectId getId() {
        return _id;
    }

    public void setId(ObjectId id) {
        this._id = id;
    }

    @Override
    public String toString() {
        return "Co2 [id=" + _id + ", ppm=" + ppm + "]";
    }
}