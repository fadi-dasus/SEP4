package com.via.Webservice.WebService.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Co2")
public class Co2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;

	@Column(name = "higheAcceptableValue")
	private final double higheAcceptableValue = 5.5;
	@Column(name = "lowAcceptableValue")
	private final double lowAcceptableValue = 0.1;

	@Column(name = "B_ID")
	private String businessKey;
	@Column(name = "value")
	private String value;
	@Column(name = "timestamp")
	private Date timestamp;

	public Co2() {

	}

	public Co2(String businessKey, String value, Date timestamp) {

		this.businessKey = businessKey;
		this.value = value;
		this.timestamp = timestamp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBusinessKey() {
		return businessKey;
	}

	public void setBusinessKey(String businessKey) {
		this.businessKey = businessKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public double getHigheAcceptableValue() {
		return higheAcceptableValue;
	}

	public double getLowAcceptableValue() {
		return lowAcceptableValue;
	}

	@Override
	public String toString() {
		return "Co2 [id=" + id + ", higheAcceptableValue=" + higheAcceptableValue + ", lowAcceptableValue="
				+ lowAcceptableValue + ", businessKey=" + businessKey + ", value=" + value + ", timestamp=" + timestamp
				+ "]";
	}

}