package com.genericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNo()
	{
	Random ran = new Random();
	int random = ran.nextInt(500);
	return random;
	}

		
		
	public String getSystemDate()
	{
	Date dt = new Date();
	String date = dt.toString();
	return date;
	}
	
	
	
	public String getSystemDateInformat()
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dt = new Date();
		String sysDateInFormat = dateFormat.format(dt);
		return sysDateInFormat;
		
	}
}
