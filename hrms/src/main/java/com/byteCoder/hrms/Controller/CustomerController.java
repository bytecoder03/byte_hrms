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
import com.byteCoder.hrms.util.Validation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerServicelmpl customerServiceImpl;

	@PostMapping("/do_reg")
	public Response doCustomerRegistration(@RequestBody Customer customer) {

		Response response = null;

		try {
			
			String EmailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
                    + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
			
            String PhoneRegexPattern= Long.toString(customer.getMobileNo());
            
            boolean mobVal=Validation.isValidMobileNo(PhoneRegexPattern);
            boolean mailVal=Validation.patternMatches(customer.getEmail(),EmailRegexPattern );
            
            boolean fnameVal=customer.getFname().isBlank();
            boolean lnameVal=customer.getLname().isBlank();
            
            if(mobVal==false)
            {
                response= new Response(Constant.EXCEPTIONCODE, Constant.FAILED, "Invalid phone number", null);
                return response;
            }
            else if(mailVal==false)
            {
                response= new Response(Constant.EXCEPTIONCODE, Constant.FAILED, "Invalid EmailId ", null);
                 return response;
            }
            else if(fnameVal==true)
            {
            	response= new Response(Constant.EXCEPTIONCODE, Constant.FAILED, "first name is blank", null);
            }
            else if(lnameVal==true)
            {
            	response= new Response(Constant.EXCEPTIONCODE,Constant.FAILED, "last name is blank", null);
            }
            else
            
            {
			Customer c= customerServiceImpl.doCustomerRegistration(customer);
			response = new Response(Constant.SUCCESSCODE,Constant.SUCCESS,"RegistrationSuccessfull",c);
			return response;
            }
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
		return response; 


	}


}
