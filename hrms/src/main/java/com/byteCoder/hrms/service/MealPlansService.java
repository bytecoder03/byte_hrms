package com.byteCoder.hrms.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.byteCoder.hrms.model.MealPlans;

public interface MealPlansService 
{

	List<MealPlans> getMealPlans();
}
