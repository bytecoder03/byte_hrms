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
	public Response(int code, String status, String message, Object payload) {
		super();
		this.code = code;
		this.status = status;
		this.message = message;
		this.payload = payload;
	}
	public int getCode() {
		return code;
	}
	public String getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public Object getPayload() {
		return payload;
	}
	
	  
	    
	
}
