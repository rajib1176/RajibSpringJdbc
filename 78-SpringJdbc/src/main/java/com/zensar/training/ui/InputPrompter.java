package com.zensar.training.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.zensar.training.bean.Gender;

public class InputPrompter {
	public int promptForIntInput(String promptMessage) {
		System.out.printf("\t\t %-50s : ", promptMessage);
		Scanner scanner=new Scanner(System.in);
		int input=scanner.nextInt();
		return input;
	}
	
	public double promptForDoubleInput(String promptMessage) {
		System.out.printf("\t\t %-50s : ", promptMessage);
		Scanner scanner=new Scanner(System.in);
		double input=scanner.nextDouble();
		return input;
	}
	
	public LocalDate promptForDateInput(String promptMessage, String format) {
		System.out.printf("\t\t %-50s"+" : ", promptMessage+" "+format);
		Scanner scanner=new Scanner(System.in);
		String str=scanner.next();
		LocalDate localDate=LocalDate.parse(str, DateTimeFormatter.ofPattern(format));
		return localDate;
	}
	
	public Gender promptForGenderInput(String promptMessage) {
		int input=this.promptForIntInput(promptMessage);
		if(input==1)
			return Gender.MALE;
		return Gender.FEMALE;
	}
	
	
	public String promptForStringInput(String promptMessage) {
		System.out.printf("\t\t %-50s : ", promptMessage);
		Scanner scanner=new Scanner(System.in);
		String str=scanner.next();
		
		return str;
	}
	
	public char promptForCharInput(String promptMessage) {
		System.out.printf("\t\t %-50s : ", promptMessage);
		Scanner scanner=new Scanner(System.in);
		String str=scanner.next();
		
		return str.charAt(0);
	}
}
