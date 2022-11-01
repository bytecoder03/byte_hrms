package com.byteCoder.hrms.Controller;

import java.util.Base64;

public class DecoderCode {

	public static boolean validToken(String token)
	{
		byte[] b=Base64.getDecoder().decode(token);
		String s= new String(b);
	     Long tokenTime = Long.parseLong(s);
	     
	     Long current_time = System.currentTimeMillis();
		if(tokenTime>current_time)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
