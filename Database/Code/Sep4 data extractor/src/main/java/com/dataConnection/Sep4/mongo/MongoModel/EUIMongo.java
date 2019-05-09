package com.dataConnection.Sep4.mongo.MongoModel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.sql.Timestamp;
import java.util.Date;


@Document(collection = "EUI")
public class EUIMongo {

    @Id
    private ObjectId _id;

    @Field("UIE")
    private String uie;

    @Field("Name")
    private String name;

    @Field("Timestamp")
    private Date timestamp;

    @Field("CO2")
    private String co2;

    @Field("Humidity")
    private String humidity;

    @Field("Temperature")
    private String temperature;

    public EUIMongo() { }

    @PersistenceConstructor
    public EUIMongo(ObjectId _id) {
        this._id=_id;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getUie() {
        return uie;
    }

    public void setUie(String eui) {
        this.uie = eui;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getCo2() {
        return co2;
    }

    public void setCo2(String co2) {
        this.co2 = co2;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) { this.temperature = temperature; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EUIMongo{" +
                "_id=" + _id +
                ", uie='" + uie + '\'' +
                ", name='" + name + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", co2='" + co2 + '\'' +
                ", humidity='" + humidity + '\'' +
                ", temperature='" + temperature + '\'' +
                '}';
    }

}