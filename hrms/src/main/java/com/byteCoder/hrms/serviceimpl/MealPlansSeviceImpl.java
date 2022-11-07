package com.byteCoder.hrms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteCoder.hrms.Dao.MealPlansDao;
import com.byteCoder.hrms.model.MealPlans;
import com.byteCoder.hrms.service.MealPlansService;

import lombok.extern.slf4j.Slf4j;
@Service
@Slf4j
public class MealPlansSeviceImpl implements MealPlansService{
	
	@Autowired
	MealPlansDao mealPlansDao;


	@Override
	public List<MealPlans> getMealPlans() {
		log.info("getMealPlans : start");
		List<MealPlans> mealPlansList=mealPlansDao.findAll();
		log.info("getMealPlans : end");
		return mealPlansList;
	}

}
