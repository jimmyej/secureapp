package pe.com.jse.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static Date convertStringToDate(String dateString) {
		Date date = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = df.parse(dateString);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return date;
	}
	public static String convertDateToString(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return df.format(date);
	}
	public static Date getCurrentDate(){
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}
	public static void main(String[] args) {
		System.out.println("Current Date: "+convertDateToString(getCurrentDate()));
	}
}
