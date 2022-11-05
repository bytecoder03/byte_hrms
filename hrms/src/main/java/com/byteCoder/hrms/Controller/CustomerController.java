package com.byteCoder.hrms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byteCoder.hrms.Dto.Response;
import com.byteCoder.hrms.exception.UserAlreadyRegistered;
import com.byteCoder.hrms.model.Customer;
import com.byteCoder.hrms.service.CustomerService;
import com.byteCoder.hrms.util.Constants;
import com.byteCoder.hrms.util.Validation;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {


	@Autowired
	CustomerService customerservice;

		@PostMapping("/do-reg")
		public Response doCustomerRegistration(@RequestBody Customer customer)
		{
			log.info("doCustomerRegistration : " + customer);
			Response response = null;
			try
			{

				if(customer.getFname() == null || customer.getFname().trim() == ""  ||
						customer.getLname() == null || customer.getLname().trim() == "" ||
						customer.getEmail()==null || customer.getEmail().trim()=="")
				{
					response  = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "Missing Input details", null);
					return response;
				}

				String mobileNo= Long.toString(customer.getMobileNo());
				boolean mobVal=Validation.isValidMobileNo(mobileNo);
				boolean mailVal=Validation.isValidEmail(customer.getEmail());

				if(mobVal==false)
				{
					response  = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "Invalid mobile number", null);
					log.debug("doCustomerRegistration : Invalid mobile number" + customer.getMobileNo());
					return response;
				}
				if(mailVal==false)
				{
					response  = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "Invalid email", null);
					log.debug("doCustomerRegistration : Invalid email" + customer.getEmail());
					return response;
				}

				Customer c =  customerservice.doCustomerRegistration(customer);
				response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "Registraion successful", c);
				log.info("doCustomerRegistration : Registraion successful");
				return response;
			}

			catch (UserAlreadyRegistered e) {
				e.printStackTrace();
				response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "Email or mobile no already register.", null);
				log.error("exception in doCustomerRegistration " + e.getMessage());
				return response;
			}

			catch (Exception e) {
				e.printStackTrace();
				response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "Registraion failed", null);
				log.error("exception in doCustomerRegistration " + e.getMessage());
				return response;
			}
		}

	}
