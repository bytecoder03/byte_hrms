package com.byteCoder.hrms.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.byteCoder.hrms.model.MealPlans;

@Repository
public interface MealPlansDao extends JpaRepository<MealPlans, Integer> {

}
