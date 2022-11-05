package com.byteCoder.hrms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {


	final static String EmailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
			+ "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	final static String mobileRegexPattern = "(0/91)?[7-9][0-9]{9}";

	public static boolean isValidEmail(String emailAddress) {
		return Pattern.compile(EmailRegexPattern)
				.matcher(emailAddress)
				.matches();
	}
	public static boolean isValidMobileNo(String str)
	{
		Pattern ptrn = Pattern.compile(mobileRegexPattern);  
		Matcher match = ptrn.matcher(str); 

		return (match.find() && match.group().equals(str)); 
	}

}
