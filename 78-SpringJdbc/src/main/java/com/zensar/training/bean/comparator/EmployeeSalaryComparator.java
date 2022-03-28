package com.zensar.training.bean.comparator;

import java.util.Comparator;

import com.zensar.training.bean.Employee;

public class EmployeeSalaryComparator implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		if(o1.getBasicSalary()<o2.getBasicSalary())
			return -1;
		if(o1.getBasicSalary()>o2.getBasicSalary())
			return 1;
		return 0;
	}

}
