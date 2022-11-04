package com.byteCoder.hrms.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteCoder.hrms.Dao.CustomerDao;
import com.byteCoder.hrms.exception.UserAlreadyRegistered;
import com.byteCoder.hrms.model.Customer;
import com.byteCoder.hrms.service.CustomerService;

@Service
public class CustomerServicelmpl implements CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	
	@Override
    public Customer doCustomerRegistration(Customer customer) {

        Customer alredyPresent = customerDao.findByMobileNoOrEmail(customer.getMobileNo(),customer.getEmail());
        if(alredyPresent ==null)
        {    
            customer = customerDao.save(customer);
            return customer;
        }

        else
        {
            throw new UserAlreadyRegistered();
        }

    }

}
