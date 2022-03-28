package com.zensar.training.bean;

import java.time.LocalDate;
import java.util.Objects;

public class Employee implements Comparable<Employee> {
	private int id;
	private String name;
	private char grade;
	private LocalDate hiredDate;
	private double basicSalary;
	private Gender gender;
	
		
	public Employee(int id, String name, char grade, LocalDate hiredDate, double basicSalary, Gender gender) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.hiredDate = hiredDate;
		this.basicSalary = basicSalary;
		this.gender = gender;
	}

	public Employee() {
		super();
	}
	
	
	

	public Employee(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGrade() {
		return grade;
	}

	public void setGrade(char grade) {
		this.grade = grade;
	}

	public LocalDate getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(LocalDate hiredDate) {
		this.hiredDate = hiredDate;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee other = (Employee) obj;
		return id == other.id;
	}
	
	

	@Override
	public String toString() {
		return "\nEmployee [id=" + id + ", name=" + name + ", grade=" + grade + ", hiredDate=" + hiredDate
				+ ", basicSalary=" + basicSalary + ", gender=" + gender + "]";
	}

	@Override
	public int compareTo(Employee o) {
		if(this.id<o.id)
			return -1;
		if(this.id>o.id)
			return 1;
		return 0;
	}
	
	public double computeAllowance() {
		if(this.grade=='A')
			return this.basicSalary*0.40;
		if(this.grade=='B')
			return this.basicSalary*0.30;
		if(this.grade=='C')
			return this.basicSalary*0.10;
		return 0;
		
	}
	
	public double getNetSalary() {
		return this.basicSalary+this.computeAllowance();
	}

}
