package borrow.configuration;

import java.time.LocalDate;

public class TextClass {
	public static void main(String arg[]) {
		
		LocalDate date = LocalDate.now();
		date = date.minusDays(7);
		System.out.println(date);
	}
}
