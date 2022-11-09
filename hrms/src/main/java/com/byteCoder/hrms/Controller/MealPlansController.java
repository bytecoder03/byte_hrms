package com.byteCoder.hrms.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byteCoder.hrms.Dto.Response;
import com.byteCoder.hrms.model.MealPlans;
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
	
	
	
	@PostMapping("/add-meal-plans")
	public Response addMealPlans(@RequestBody List<MealPlans> listofMealPlans)
	{
		log.info("addMealPlans");
		List<MealPlans> addmealplansList=mealPlansService.addMealPlans(listofMealPlans);
		try {
		if(addmealplansList.isEmpty()) {
		
		
		response  = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "Empty Data", null);
		log.info("addMealPlans: No data");
		
		return response;
		}
		else
		{
			response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "Added Successfully", addmealplansList);
			log.info("addMealPlans: Data Added Successfully");
			return response;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "failed", null);
			log.error("exception in addMealPlans " + e.getMessage());
			return response;
		}
		
	}
	
	
	@PutMapping("/update-meal-plans")
	public Response updateMealPlans(@RequestBody List<MealPlans> listofMealPlans)
	{
		log.info("updateMealPlans");
		List<MealPlans> updatemealplansList=mealPlansService.addMealPlans(listofMealPlans);
		try {
		if(updatemealplansList.isEmpty()) {
		
		
		response  = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "Empty Data", null);
		log.info("updateMealPlans: No data");
		
		return response;
		}
		else
		{
			response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "updated Successfully", updatemealplansList);
			log.info("updateMealPlans: Data Updated Successfully");
			return response;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "failed", null);
			log.error("exception in updateMealPlans " + e.getMessage());
			return response;
		}
		
		
		
		
	}
	@DeleteMapping("/delete-meals-plan-by-id")
    public Response deleteMealPlans(@RequestParam(required = true) int mealsPlanId)
	{
		log.info("deleteMealPlans");
		try
		{
		boolean s=mealPlansService.deleteMealPlans(mealsPlanId);
		if(s==true)
		{
		response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "delete Successfully",null);
		log.info("deleteMealPlans: Data deleted Successfully"+mealsPlanId);
		return response;
		}
		else
		{
			response = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "No data found",null);
			log.info("deleteMealPlans: No data found"+mealsPlanId);
			return response;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "No data found",null);
			log.error("exception in deleteMealPlans " + e.getMessage());
			return response;
		}
		
	}

}
