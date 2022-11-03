package com.byteCoder.hrms.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byteCoder.hrms.Dto.Response;
import com.byteCoder.hrms.exception.UserAlreadyRegistered;
import com.byteCoder.hrms.model.Customer;
import com.byteCoder.hrms.serviceimpl.CustomerServicelmpl;
import com.byteCoder.hrms.util.Constant;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServicelmpl customerServiceImpl;

	@PostMapping("/do_reg")
	public Response doCustomerRegistration(@RequestBody Customer customer) {

		Response response = null;

		try {
			Customer c= customerServiceImpl.doCustomerRegistration(customer);
			response = new Response(Constant.SUCCESSCODE,Constant.SUCCESS,"RegistrationSuccessfull",c);
			return response;
		}
        catch(UserAlreadyRegistered e)
		{
        	e.printStackTrace();
            response = new Response(Constant.EXCEPTIONCODE,Constant.FAILED, "Email or mobile no already register.", null);
            return response;
		}
		catch (Exception e)
		{
			
			e.printStackTrace();
			response = new Response(Constant.EXCEPTIONCODE,Constant.FAILED, "registration failed", null);
			return response;
		} 


	}


}
