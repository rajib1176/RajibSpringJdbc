package com.zensar.training.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.zensar.training.bean.Employee;
import com.zensar.training.bean.Gender;

public class EmployeeSpringJdbcImpl implements EmployeeDAO{

	@Override
	public boolean addEmployee(JdbcTemplate jdbcTemplate, Employee employee) throws Exception {
		boolean result=true;
		Object []rowData= {employee.getName(),
				employee.getHiredDate(),
				employee.getGrade(),
				employee.getBasicSalary(),
				employee.getGender().toString().charAt(0)};
		int r=jdbcTemplate.update(INSERT_QRY,rowData);
		if(r>0)
			result=true;
		else
			result=false;
		return result;
	}

	@Override
	public boolean updateEmployee(JdbcTemplate jdbcTemplate, Employee employee) throws Exception {
		boolean result=true;
		Object []rowData= {employee.getName(),
				employee.getHiredDate(),
				employee.getGrade(),
				employee.getBasicSalary(),
				employee.getGender().toString().charAt(0)};
		int r=jdbcTemplate.update(UPDATE_QRY,rowData);
		if(r>0)
			result=true;
		else
			result=false;
		return result;
	}

	@Override
	public boolean deleteEmployee(JdbcTemplate jdbcTemplate, Employee employee) throws Exception {
		boolean result=true;
		Object []rowData= {employee.getId()};
		int r=jdbcTemplate.update(DELETE_QRY,rowData);
		if(r==0)
			result=false;
		return false;
	}

	@Override
	public Employee findEmployee(JdbcTemplate jdbcTemplate, int empId) throws Exception {
		Employee employee=jdbcTemplate.queryForObject(FIND_QRY,new Object[] {empId},new EmployeeRowMapper());
		return employee;
	}

	@Override
	public List<Employee> findAllEmployees(JdbcTemplate jdbcTemplate) throws Exception {
		List<Employee> list=jdbcTemplate.query(FIND_ALL_QRY, new EmployeeRowMapper());
		return list;
	}
	
	private class EmployeeRowMapper implements RowMapper<Employee>{

		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee=new Employee();
			employee.setId(rs.getInt(1));
			employee.setName(rs.getString(2));
			
			java.sql.Date doj=rs.getDate(3);
			LocalDate date=DateConversion.convertToLocalDate(doj);
			employee.setHiredDate(date);
			employee.setGrade(rs.getString(4).charAt(0));
			employee.setBasicSalary(rs.getDouble(5));
			char gender=rs.getString(6).charAt(0);
			if(gender=='M')
				employee.setGender(Gender.MALE);
			else
				employee.setGender(Gender.FEMALE);
			return employee;
		}
		
	}

}
