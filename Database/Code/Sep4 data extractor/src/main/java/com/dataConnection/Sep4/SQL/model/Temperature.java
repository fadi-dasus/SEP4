package com.dataConnection.Sep4.SQL.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Temperature")
public class Temperature {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "temperature_id")
	private Integer id;



	@Column(name = "timestamp")
	private Date date;

	@Column(name = "tempInC")
	private String tempInC;

	public Temperature() {

	}

	public Temperature(Date date, String tempInC) {

		this.date=date;
		this.tempInC = tempInC;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTempInC() { return tempInC; }

	public void setTempInC(String ppm) {
		this.tempInC = tempInC;
	}

	public Date getDate() { return date; }

	public void setDate(Date date) { this.date = date; }

	@Override
	public String toString() {
		return "Temperature [id=" + id + ", tempInC=" + tempInC + "]";
	}

}