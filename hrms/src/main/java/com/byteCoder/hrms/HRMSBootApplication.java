package com.byteCoder.hrms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class HRMSBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HRMSBootApplication.class, args);
		System.out.println("start");
		log.info("HRMSBootApplication stated");
	}

}
