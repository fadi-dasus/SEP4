package com.dataConnection.Sep4.mongo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Document(collection = "Temperature")
public class TemperatureMongo {

	@Id
	private ObjectId _id;



	@Field("tempInC")
	private String tempInC;

	public TemperatureMongo() {

	}

	public TemperatureMongo(String tempInC) {

		this.tempInC = tempInC;
	}

	public ObjectId getId() {
		return _id;
	}

	public void setId(ObjectId id) {
		this._id = id;
	}

	public String getTempInC() { return tempInC; }

	public void setTempInC(String tempInC) { this.tempInC = tempInC; }

	@Override
	public String toString() {
		return "Temperature [id=" + _id + ", tempInC=" + tempInC + "]";
	}

}