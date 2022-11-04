package com.byteCoder.hrms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.byteCoder.hrms.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Integer> {
public Customer findByMobileNoOrEmail(long  mobileNo,String email);
	
}

