package br.com.personalPrpject.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Utils {
	private static final Logger logger = LoggerFactory.getLogger(Utils.class);

	public static Date stringFormatToDate(String data, String format) {
		if (data == null || data.equals(""))
			return null;

		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat(format);
			formatter.setLenient(false);
			date = (java.util.Date) formatter.parse(data);
		} catch (ParseException e) {
			logger.error(e.getMessage());
			return null;
		}
		return date;
	}
	
	public static String dateFormatToString(Date date, String format) {		
		if(date == null) 
			return "";
	     
		SimpleDateFormat out = new SimpleDateFormat(format);  
		
		try {
			return out.format(date);  
		} catch(Exception e) {
			return null;
		}
	}
	
	public static Date dateZeroHourToRange(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return calendar.getTime();
	}
	
	public static Date dateLastHourToRange(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		
		return calendar.getTime();
	}
	public static boolean isThisDateValid(String dateToValidate, String dateFromat){
		 
		if(dateToValidate == null){
			return false;
		} 
		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false); 
		try {
			Date date = sdf.parse(dateToValidate);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	public static String retiraCaracteresEspeciais(String stringFonte) {
		String passa = stringFonte;
		passa = passa.replaceAll("[�����]", "A");
		passa = passa.replaceAll("[�����]", "a");
		passa = passa.replaceAll("[����]", "E");
		passa = passa.replaceAll("[����]", "e");
		passa = passa.replaceAll("����", "I");
		passa = passa.replaceAll("����", "i");
		passa = passa.replaceAll("[�����]", "O");
		passa = passa.replaceAll("[�����]", "o");
		passa = passa.replaceAll("[����]", "U");
		passa = passa.replaceAll("[����]", "u");
		passa = passa.replaceAll("�", "C");
		passa = passa.replaceAll("�", "c");
		/*passa = passa.replaceAll("[��]", "y");
		passa = passa.replaceAll("�", "Y");
		passa = passa.replaceAll("�", "n");
		passa = passa.replaceAll("�", "N");
		passa = passa.replaceAll("[-+=*&amp;%$#@!_]", "");
		passa = passa.replaceAll("['\"]", "");
		passa = passa.replaceAll("[<>()\\{\\}]", "");
		passa = passa.replaceAll("['\\\\.,()|/]", "");
		passa = passa.replaceAll("[^!-�]{1}[^ -�]{0,}[^!-�]{1}|[^!-�]{1}", " ");*/
		return passa;
	}
	
/*	public static String retiraCaracteresEspeciais(String stringFonte) {
		String passa = stringFonte;
		passa = passa.replaceAll("[�����]", "A");
		passa = passa.replaceAll("[�����]", "a");
		passa = passa.replaceAll("[����]", "E");
		passa = passa.replaceAll("[����]", "e");
		passa = passa.replaceAll("����", "I");
		passa = passa.replaceAll("����", "i");
		passa = passa.replaceAll("[�����]", "O");
		passa = passa.replaceAll("[�����]", "o");
		passa = passa.replaceAll("[����]", "U");
		passa = passa.replaceAll("[����]", "u");
		passa = passa.replaceAll("�", "C");
		passa = passa.replaceAll("�", "c");
		passa = passa.replaceAll("[��]", "y");
		passa = passa.replaceAll("�", "Y");
		passa = passa.replaceAll("�", "n");
		passa = passa.replaceAll("�", "N");
		passa = passa.replaceAll("[-+=*&amp;%$#@!_]", "");
		passa = passa.replaceAll("['\"]", "");
		passa = passa.replaceAll("[<>()\\{\\}]", "");
		passa = passa.replaceAll("['\\\\.,()|/]", "");
		passa = passa.replaceAll("[^!-�]{1}[^ -�]{0,}[^!-�]{1}|[^!-�]{1}", " ");
		return passa;
	}*/
}