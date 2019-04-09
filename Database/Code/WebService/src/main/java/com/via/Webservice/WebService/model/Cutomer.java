package com.via.Webservice.WebService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Cutomer")
public class Cutomer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int ID;

	@Column(name = "userame")
	private String userame;
	@Column(name = "password")
	private String password;
	@Column(name = "email")
	private String email;
	@Column(name = "phoneNumber")
	private String phoneNumber;

	public Cutomer() {

	}

	public Cutomer(String userame, String password, String email, String phoneNumber) {

		this.userame = userame;
		this.password = password;
		this.email = email;
		this.phoneNumber = phoneNumber;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Cutomer [ID=" + ID + ", userame=" + userame + ", password=" + password + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + "]";
	}

}
