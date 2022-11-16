package com.medplus.employee.utils;

import java.sql.Date;

public class DateConversion {
	public static Date convertDate(String strdate) {
		Date sqldate= Date.valueOf(strdate);
		return sqldate;
		
	}
}
