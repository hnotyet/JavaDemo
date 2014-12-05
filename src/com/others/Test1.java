package com.others;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {

	
	public static void main(String[] args) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		//	System.out.println(format.format(new Date()));
			
		 Date now = 	new Date();
		 
		Date today =  format.parse(format.format(new Date()));
		
		System.out.println(format.format(new Date()));
		
		System.out.println(now.before(today));
		 
		
	}
}
