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
@Table(name = "Device")
public class Device extends ResourceSupport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private int Id;
	@Column(name = "deviceName")
	private String deviceName;
	@Column(name = "UIE")
	private String uie;

	public Device() {
	
	}

	@JsonCreator
	public Device(@JsonProperty("device") String deviceName, String uie) {
		super();
		this.deviceName = deviceName;
		this.uie = uie;
	}

	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getUie() {
		return uie;
	}

	public void setUie(String uie) {
		this.uie = uie;
	}

	public void setId(int id) {
		Id = id;
	}

	@Override
	public String toString() {
		return "Device [Id=" + Id + ", deviceName=" + deviceName + ", uie=" + uie + "]";
	}

}
