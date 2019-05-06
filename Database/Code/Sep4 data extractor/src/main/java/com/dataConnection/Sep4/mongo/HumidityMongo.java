package com.dataConnection.Sep4.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.*;

@Document(collection = "Humidity")
public class HumidityMongo {

	@Id
	private ObjectId _id;



	@Field("percentage")
	private String percentage;

	public HumidityMongo() {

	}

	public HumidityMongo(String percentage) {

		this.percentage = percentage;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
	}

	public String getPercentage() { return percentage; }

	public void setPercentage(String percentage) { this.percentage = percentage; }

	@Override
	public String toString() {
		return "Humidity [id=" + _id + ", percentage=" + percentage + "]";
	}

}