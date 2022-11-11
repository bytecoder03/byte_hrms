package com.byteCoder.hrms.service;

import java.util.List;
import java.util.Optional;

import com.byteCoder.hrms.model.DailyMeals;

public interface DailyMealsService 
{
	DailyMeals addDailyMeals(DailyMeals dailyMealsPlans);
	boolean deleteDailyMeals(int dailyMealsId);
	List<DailyMeals> getDailyMeals();
	Optional<DailyMeals> getDailyMealsById(int dailyMealsId);

}
