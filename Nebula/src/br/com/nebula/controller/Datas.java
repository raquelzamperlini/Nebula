package br.com.nebula.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
 * @author Raquel Zamperlini
 * 
 */

public class Datas {
	
	public LocalDate stringParaLocalDate(String string) {
		
		DateTimeFormatter formatadorBarra = 
				  DateTimeFormatter.ofPattern("dd/MM/[uuuu][uu]");
		
		DateTimeFormatter formatadorHifen = 
				  DateTimeFormatter.ofPattern("[uuuu][uu]-MM-dd");
		
		LocalDate localDate = null;
		
		if (string.contains("/") )
		{
			 localDate = LocalDate.parse(string, formatadorBarra);
		}
		
		if (string.contains("-") )
		{
			localDate = LocalDate.parse(string, formatadorHifen);
		}
		
		return localDate;
		
	}
	
	public String localDateParaString(LocalDate localDate) {
		
		DateTimeFormatter formatador = 
		  DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String string = localDate.format(formatador);
		
		return string;
		
	}
	
	/*
	public static Date asDate(LocalDate localDate) {
		return Date.from(localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static Date asDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	}
	
	public static LocalDate asLocalDate(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
	}
	
	public static LocalDateTime asLocalDateTime(Date date) {
		return Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDateTime();
	}
	*/
	
}
