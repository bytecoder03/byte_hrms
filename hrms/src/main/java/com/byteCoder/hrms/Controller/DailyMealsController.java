package com.byteCoder.hrms.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.byteCoder.hrms.Dto.Response;
import com.byteCoder.hrms.model.DailyMeals;
import com.byteCoder.hrms.service.DailyMealsService;
import com.byteCoder.hrms.util.Constants;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
public class DailyMealsController 
{
	@Autowired
	DailyMealsService dailyMealsService;
	
	Response response= new Response();
	@PostMapping("/add-daily-meals")
	public Response addDailyMeals(@RequestBody DailyMeals dailyMeals)
	{
		log.info("addDailyMeals");
		DailyMeals addDailyMealss=dailyMealsService.addDailyMeals(dailyMeals);
		try {
		if(addDailyMealss.getTodaysMeal().isEmpty()) {
		
		
		response  = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "Empty Data", null);
		log.info("addDailyMeals: No data");
		
		return response;
		}
		else
		{
			response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "Added Successfully", addDailyMealss);
			log.info("addDailyMeals: Data Added Successfully");
			return response;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "failed", null);
			log.error("exception in addDailyMeals " + e.getMessage());
			return response;
		}
		
	}
	
	
	@DeleteMapping("/delete-daily-meals-by-id")
    public Response deleteDailyMeals(@RequestParam(required = true) int dailyMealsId)
	{
		log.info("deleteDailyMeals");
		try
		{
			
		boolean s=dailyMealsService.deleteDailyMeals(dailyMealsId);
		if(s==true)
		{
		response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "deleted Successfully",null);
		log.info("deleteMealPlans: Data deleted Successfully"+dailyMealsId);
		return response;
		}
		else
		{
			response = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "No data found",null);
			log.info("deleteMealPlans: No data found"+dailyMealsId);
			return response;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "failed",null);
			log.error("exception in deleteMealPlans " + e.getMessage());
			return response;
		}
		
	}
	@GetMapping("/get-daily-meals")
	public Response getDailyMeals()
	{
		List<DailyMeals> dailyMealsList= dailyMealsService.getDailyMeals();
		
		try
		{
			log.info("getDailyMeals");
			if(dailyMealsList.isEmpty()==false)
			{
				response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "Daily Meals Plan", dailyMealsList);
				log.info("getDailyMeals: Data Fetched Successfully");

				return response;
			}
			else
			{
				response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "No Daily Meal Plans ", null);
				log.info("getDailyMeals: Data Fetched Successfully: No data Found");
				return response;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "failed",null);
			log.error("exception in deleteMealPlans " + e.getMessage());
			return response;
		}
		
		
	}
	
	@GetMapping("/get-daily-meals-by-id")
	public Response getDailyMealsById(@RequestParam(required = true) int dailyMealsId)
	{
		Optional<DailyMeals> dailyMealsOpt= dailyMealsService.getDailyMealsById(dailyMealsId);
		
		try
		{
			log.info("getDailyMealsById");
			if(dailyMealsOpt.isEmpty()==false)
			{
				response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "Daily Meals Plans By Id", dailyMealsOpt);
				log.info("getDailyMealsById: Data Fetched Successfully");

				return response;
			}
			else
			{
				response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "No Daily Meal Plans found with this id", dailyMealsOpt);
				log.info("getDailyMealsById: Data Fetched Successfully: No data Found");
				return response;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "failed",null);
			log.error("exception in getDailyMealsById " + e.getMessage());
			return response;
		}
		
		
	}
	
	@PutMapping("/update-daily-meals")
	public Response updateDailyMeals(@RequestBody DailyMeals dailyMeals)
	{
		log.info("updateDailyMeals");
		DailyMeals updateDailyMealss=dailyMealsService.addDailyMeals(dailyMeals);
		try {
		if(updateDailyMealss.getTodaysMeal().isEmpty()) {
		
		
		response  = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "Empty Data", null);
		log.info("updateDailyMeals: No data");
		
		return response;
		}
		else
		{
			response  = new Response(Constants.SUCCESSCODE, Constants.SUCCESS, "updated Successfully", updateDailyMealss);
			log.info("updateDailyMeals: Data updated Successfully");
			return response;
		}
		}
		catch (Exception e) {
			e.printStackTrace();
			response = new Response(Constants.EXCEPTIONCODE, Constants.FAILED, "failed", null);
			log.error("exception in updateDailyMeals " + e.getMessage());
			return response;
		}
		
	}

	

}
