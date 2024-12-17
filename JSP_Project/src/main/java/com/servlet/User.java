package com.servlet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User 
{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String password;
	private String email;
	private String gender;
	private String country;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String name, String password, String email, String gender, String country) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
		this.gender = gender;
		this.country = country;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", email=" + email + ", gender=" + gender
				+ ", country=" + country + "]";
	}
	
	
	
}
