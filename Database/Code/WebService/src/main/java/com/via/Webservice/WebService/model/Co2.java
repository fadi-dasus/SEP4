package com.via.Webservice.WebService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Co2")
public class Co2 extends ResourceSupport{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer Id;
	
	
	static final transient String higheAcceptableValue = "some value ";

	static final transient String lowAcceptableValue = "another value ";

	@Column(name = "B_ID")
	private String businessKey;
	@Column(name = "value")
	private String value;
	@Column(name = "timestamp")
	private String timestamp;

	

	public Co2() {

	}
	 @JsonCreator
	public Co2(@JsonProperty("co2") String businessKey, String value, String timestamp) {

		this.businessKey = businessKey;
		this.value = value;
		this.timestamp = timestamp;
	}
	 
	public String getBusinessKey() {
		return businessKey;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public static String getHigheacceptablevalue() {
		return higheAcceptableValue;
	}

	public static String getLowacceptablevalue() {
		return lowAcceptableValue;
	}

	@Override
	public String toString() {
		return "Co2 [Id=" + Id + ", businessKey=" + businessKey + ", value=" + value + ", timestamp=" + timestamp + "]";
	}

}
