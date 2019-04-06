package com.dataConnection.Sep4.SQL.model;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "co2_id")
	private Integer id;

	@Column(name = "ppm")
	private String ppm;

	public Co2() {

	}

	public Co2(String ppm) {

		
		this.ppm = ppm;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPpm() {
		return ppm;
	}

	public void setPpm(String ppm) {
		this.ppm = ppm;
	}

	@Override
	public String toString() {
		return "Co2 [id=" + id + ", ppm=" + ppm + "]";
	}

}