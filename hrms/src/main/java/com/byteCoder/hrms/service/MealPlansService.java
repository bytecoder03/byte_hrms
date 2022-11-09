package com.byteCoder.hrms.service;

import java.util.List;

import com.byteCoder.hrms.model.MealPlans;

public interface MealPlansService 
{

	List<MealPlans> getMealPlans();
	
	List<MealPlans> addMealPlans(List<MealPlans> listofMealPlans);
	
	boolean deleteMealPlans(int mealPlanId);
	
}
