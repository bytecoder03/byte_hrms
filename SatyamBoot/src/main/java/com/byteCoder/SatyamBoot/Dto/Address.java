package com.byteCoder.SatyamBoot.Dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address_details")
public class Address {
	
	@Id
	@GeneratedValue
	private int aid;
	
	private String city;
	private String state;
	private String country;
	
	@OneToOne(mappedBy = "address")
	private StudentDetails std;
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public StudentDetails getStd() {
		return std;
	}
	public void setStd(StudentDetails std) {
		this.std = std;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

}
