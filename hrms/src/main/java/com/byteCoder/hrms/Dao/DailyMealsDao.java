package com.byteCoder.hrms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteCoder.hrms.model.DailyMeals;

@Repository
public interface DailyMealsDao extends JpaRepository<DailyMeals, Integer> {

}
