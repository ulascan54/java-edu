package com.example;

import java.text.DecimalFormat;
import java.util.Locale;

public class StudyInternationalization {
	public static void main(String[] args) {
		Locale locale = new Locale("tr","TR");
		String city = "izmir";
		System.out.println(city.toUpperCase(locale));
		double money = 123456.78;
		DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
		System.out.println(df.format(money));
	}
}
