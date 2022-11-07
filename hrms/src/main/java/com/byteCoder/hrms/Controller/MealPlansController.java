package com.byteCoder.hrms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.byteCoder.hrms.Dto.Response;
import com.byteCoder.hrms.model.MealPlans;
import com.byteCoder.hrms.service.CustomerService;
import com.byteCoder.hrms.service.MealPlansService;
import com.byteCoder.hrms.util.Constants;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController

public class MealPlansController 
{
	@Autowired
	MealPlansService mealPlansService;
	

	Response response= new Response();

	@GetMapping("/meal-plans")
	public Response getMealPlans()
	{
		log.info("getMealPlans");
		List<MealPlans> mealplansList=mealPlansService.getMealPlans();

		try

		{
		if(mealplansList.isEmpty()==false)

		{
			response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "Meal Plans--", mealplansList);
			log.info("getMealPlans: Data Fetched Successfully");

			return response;
		}
		else
		{
			response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "No Meal Plans ", null);
			log.info("getMealPlans: Data Fetched Successfully: No data Found");
			return response;
		}

		}
		catch(Exception e)
		{
			e.printStackTrace();
			response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "failed", null);
			log.error("exception in getMealPlans " + e.getMessage());
			return response;
		
		}

	}

}
