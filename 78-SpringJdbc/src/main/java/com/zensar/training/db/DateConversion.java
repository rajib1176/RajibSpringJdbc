package com.zensar.training.db;

import java.sql.Date;
import java.time.LocalDate;

public class DateConversion {
	public static Date convertToSQLDate(LocalDate localDate){
		Date date=Date.valueOf(localDate);
		return date;
	}
	
	public static LocalDate convertToLocalDate(Date date) {
		LocalDate localDate=date.toLocalDate();
		return localDate;
	}
}
