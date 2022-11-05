package com.byteCoder.hrms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteCoder.hrms.Dao.CustomerDao;
import com.byteCoder.hrms.exception.UserAlreadyRegistered;
import com.byteCoder.hrms.model.Customer;
import com.byteCoder.hrms.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerServicelmpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;

	@Override
	public Customer doCustomerRegistration(Customer customer) throws UserAlreadyRegistered {

		log.info("doCustomerRegistration : start");

		Customer alreadyPresent =	  customerDao.findByMobileNoOrEmail(customer.getMobileNo(), customer.getEmail());
		if(alreadyPresent == null)
		{	
			customer = customerDao.save(customer);
			log.info("doCustomerRegistration : end");
			return customer;
		}

		else
		{
			log.debug("doCustomerRegistration : user already exist"  + alreadyPresent);
			throw new UserAlreadyRegistered();

		}


	}
}