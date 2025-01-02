package com.example.airline.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "passengers")
public class Passengers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passenger_id")
	private Long passengersId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "passport_number")
	private String passportNumber;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	public Passengers(Long passengersId, String name, String passportNumber, int age, String email,
			String phoneNumber) {
		super();
		this.passengersId = passengersId;
		this.name = name;
		this.passportNumber = passportNumber;
		this.age = age;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	public Passengers() {
		
	}

	public Long getPassengersId() {
		return passengersId;
	}

	public void setPassengersId(Long passengersId) {
		this.passengersId = passengersId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
}
