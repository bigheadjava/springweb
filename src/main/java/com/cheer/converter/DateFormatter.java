package com.cheer.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

public class DateFormatter implements Formatter<Date> {

	private String pattern;

	private SimpleDateFormat sdf;

	public DateFormatter() {
		super();
	}

	public DateFormatter(String pattern) {
		super();
		this.pattern = pattern;
		sdf = new SimpleDateFormat(pattern);
	}

	@Override
	public String print(Date object, Locale locale) {
		return sdf.format(object);
	}

	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		return sdf.parse(text);
	}

}
