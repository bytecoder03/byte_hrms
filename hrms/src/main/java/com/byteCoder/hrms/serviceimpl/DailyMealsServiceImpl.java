package com.byteCoder.hrms.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.byteCoder.hrms.Dao.DailyMealsDao;
import com.byteCoder.hrms.model.DailyMeals;
import com.byteCoder.hrms.service.DailyMealsService;


import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class DailyMealsServiceImpl implements DailyMealsService{
	@Autowired 
	DailyMealsDao dailyMealsDao;

	@Override
	public DailyMeals addDailyMeals(DailyMeals dailyMealsPlans) {

		log.info("addDailyMeals : start");
		dailyMealsPlans=dailyMealsDao.save(dailyMealsPlans);
		log.info("addDailyMeals:end");
		return dailyMealsPlans;
	}

	@Override
	public boolean deleteDailyMeals(int dailyMealsId) {

		Optional<DailyMeals> dailyMealsIds=dailyMealsDao.findById(dailyMealsId);


		if(dailyMealsIds.isPresent())
		{
			log.info("deleteDailyMeals : start");
			dailyMealsDao.deleteById(dailyMealsId);
			log.info("deleteDailyMeals : end");
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public List<DailyMeals> getDailyMeals() {
		log.info("getDailyMeals : start");
		List<DailyMeals> listDailyMeals=dailyMealsDao.findAll();
		log.info("getDailyMeals : end");
		return listDailyMeals;

	}

	@Override
	public Optional<DailyMeals> getDailyMealsById(int dailyMealsId) {
		log.info("getDailyMealsById : start");
		Optional<DailyMeals> listDailyMealsId=dailyMealsDao.findById(dailyMealsId);
		log.info("getDailyMealsById : end");
		return listDailyMealsId;
	}




}
