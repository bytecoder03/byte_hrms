package com.byteCoder.hrms.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {
    
	
	private int code;
	private String status;
	private String message;
	private Object payload;
	
	  
	    
	
}
