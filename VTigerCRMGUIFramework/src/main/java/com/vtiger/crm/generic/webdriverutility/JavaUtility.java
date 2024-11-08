package com.vtiger.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * this class is for to work with java
 * 
 * @author Mayur
 */
public class JavaUtility {
	
	/**this method is for to Generate Random Number */
	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(5000);
		return randomNumber;
	}
	
	/**this method is for to Get Current Date in "yyyy-MM-dd" this format */
	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String actDate = sim.format(dateObj);
		return actDate;
	}
	
	/**this method is for to Get Required Date in "yyyy-MM-dd" this format */
	public String getRequiredDateYYYYMMDD(int days) {
		Date dObj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		sim.format(dObj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requireDate = sim.format(cal.getTime());
		return requireDate;
	}

}
