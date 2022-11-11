package com.byteCoder.hrms.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class DailyMeals 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int dailyMealsId;
	private String todaysMeal;
}
