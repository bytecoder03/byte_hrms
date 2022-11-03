package com.byteCoder.hrms.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name= "customer_details")
public class Customer {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customerId;
    private String fname;
    private String lname;    
    private long  mobileNo;
    private String email;
    private String address;
	
	
	
}
