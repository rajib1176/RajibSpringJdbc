package com.zensar.training.ui;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.zensar.training.bean.Employee;
import com.zensar.training.bean.Gender;
import com.zensar.training.config.JdbcConfig;
import com.zensar.training.db.EmployeeSpringJdbcImpl;
import com.zensar.training.service.EmployeeService;
import com.zensar.training.service.EmployeeServiceImpl;

public class UIModule {
	
	static DataSource datasource = new JdbcConfig().dataSource();
	private final static JdbcTemplate jdbcTemplate= new JdbcTemplate(datasource);;
	private static void blankLines(int num) {
		for(int i=1;i<=num; i++)
			System.out.println();
	}
	public static void addInfo() {
        
		blankLines(3);
		InputPrompter prompter= new InputPrompter();
		
		String name= prompter.promptForStringInput("Enter Name");
		char grade=prompter.promptForCharInput("Enter Grade[A,B,C]");
		LocalDate hiredDate=prompter.promptForDateInput("Enter DOJ", "dd-MM-yyyy");
		double salary=prompter.promptForDoubleInput("Enter Basic Salary");
		Gender gender=prompter.promptForGenderInput("Enter Gender [1.MALE 2.FEMALE]");
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setBasicSalary(salary);
		employee.setGrade(grade);
		employee.setHiredDate(hiredDate);
		employee.setGender(gender);
		
		EmployeeSpringJdbcImpl employeeService=new EmployeeSpringJdbcImpl();
		try {
			boolean result=employeeService.addEmployee(jdbcTemplate, employee);
			if(result)
				System.out.println("\t\tAdded Succesfully.");
			else
				System.out.println("Not added.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void updateInfo() {
		blankLines(3);
		InputPrompter prompter= new InputPrompter();
		
		int editableID=prompter.promptForIntInput("Enter ID to Update");
		String name= prompter.promptForStringInput("Enter Name");
		char grade=prompter.promptForCharInput("Enter Grade [A,B,C]");
		LocalDate hiredDate=prompter.promptForDateInput("Enter DOJ", "dd-MMM-yyyy");
		double salary=prompter.promptForDoubleInput("Enter Basic Salary");
		Gender gender=prompter.promptForGenderInput("Enter Gender [1.MALE 2.FEMALE]");
		
		Employee employee=new Employee();
		employee.setName(name);
		employee.setBasicSalary(salary);
		employee.setGrade(grade);
		employee.setHiredDate(hiredDate);
		employee.setGender(gender);
		employee.setId(editableID);
		
		EmployeeSpringJdbcImpl employeeService=new EmployeeSpringJdbcImpl();
		try {
			boolean result=employeeService.updateEmployee(jdbcTemplate,employee);
			if(result)
				System.out.println("\t\tUpdated Succesfully.");
			else
				System.out.println("ID not found !!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void searchInfo() {
		blankLines(3);
		InputPrompter prompter= new InputPrompter();
		int searchId=prompter.promptForIntInput("Enter ID to Search");
		
		Consumer<Employee> consumer=(e)->{
			System.out.println("\t\t ID: "+e.getId());
			System.out.println("\t\t NAME: "+e.getName());
			System.out.println("\t\t HIRE DATE: "+e.getHiredDate().toString());
			System.out.println("\t\t SALARY: "+e.getBasicSalary());
			System.out.println("\t\t GRADE: "+e.getGrade());
			System.out.println("\t\t GENDER: "+e.getGender().toString());
			System.out.println();
		};
		
		EmployeeSpringJdbcImpl employeeService=new EmployeeSpringJdbcImpl();
		try {
			Employee employee=employeeService.findEmployee(jdbcTemplate, searchId);
			if(employee==null) {
				System.out.println("\n\t\t NOT FOUND.\n\n");
				return;
			}
			consumer.accept(employee);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  void listInfo() {
		blankLines(3);
		
		EmployeeSpringJdbcImpl employeeService=new EmployeeSpringJdbcImpl();
		List<Employee> allEmployees=null;
		try {
			allEmployees=employeeService.findAllEmployees(jdbcTemplate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Consumer<Employee> consumer=(e)->{
			System.out.printf("%-5d",e.getId());
			System.out.printf("%-25s",e.getName());
			System.out.printf("%-15s",e.getHiredDate().toString());
			System.out.printf("%-15.2f",e.getBasicSalary());
			System.out.printf("%-5s",e.getGrade());
			System.out.printf("%-10s",e.getGender().toString());
			System.out.println();
		};
		
		allEmployees.stream().forEach(consumer);
	}
	
	public static void deleteInfo() {
		blankLines(3);
		InputPrompter prompter= new InputPrompter();
		int searchId=prompter.promptForIntInput("Enter ID to Delete");
		boolean result=false;
		EmployeeSpringJdbcImpl employeeService=new EmployeeSpringJdbcImpl();
		try {
			result=employeeService.deleteEmployee(jdbcTemplate, new Employee(searchId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(result)
			System.out.println("\t\tDeleted successfully.");
		else
			System.out.println("\t\tNot deleted.");
	}
}
