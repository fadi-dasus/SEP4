package com.via.Webservice.WebService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "userame")
	private String userame;
	@Column(name = "password")
	private String password;

	public Admin(String userame, String password) {

		this.userame = userame;
		this.password = password;
	}

	public int getID() {
		return ID;
	}

	public String getUserame() {
		return userame;
	}

	public void setUserame(String userame) {
		this.userame = userame;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Admin [ID=" + ID + ", userame=" + userame + ", password=" + password + "]";
	}

}
