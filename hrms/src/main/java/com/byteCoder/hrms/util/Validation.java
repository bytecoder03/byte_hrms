package com.byteCoder.hrms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	
	
	     public static boolean patternMatches(String emailAddress, String regexPattern) {
	     return Pattern.compile(regexPattern)
	          .matcher(emailAddress)
	          .matches();
	 }
	     public static boolean isValidMobileNo(String str)
	 {
		 Pattern ptrn = Pattern.compile("(0/91)?[7-9][0-9]{9}");  
		 Matcher match = ptrn.matcher(str); 
		    
		 return (match.find() && match.group().equals(str)); 
	 }
	    
}
