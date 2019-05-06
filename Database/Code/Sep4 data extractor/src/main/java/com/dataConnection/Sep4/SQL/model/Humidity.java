package com.dataConnection.Sep4.SQL.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Humidity")
public class Humidity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "humidity_id")
	private Integer id;



	@Column(name = "timestamp")
	private Date date;

	@Column(name = "percentage")
	private String percentage;

	public Humidity() {

	}

	public Humidity(Date date, String percentage) {

		this.date=date;
		this.percentage = percentage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPercentage() { return percentage; }

	public void setPercentage(String percentage) { this.percentage = percentage; }

	public Date getDate() { return date; }

	public void setDate(Date date) { this.date = date; }

	@Override
	public String toString() {
		return "Humidity [id=" + id + ", percentage=" + percentage + "]";
	}

}