package com.bridgelabz.employeepayrollapp.services;

import java.util.List;
import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.model.*;


public interface IEmployeePayrollService {
	
	List<EmployeePayrollData> getEmployeePayrollData();
	
	EmployeePayrollData getEmployeePayrollDataById(int empId);
	
	List<EmployeePayrollData> getEmployeesByDepartment(String department);
	
	EmployeePayrollData createEmployeePayrollData(
			EmployeePayrollDTO empPayrollDTO);
	
	EmployeePayrollData updateEmployeePayrollData(int empId,
			EmployeePayrollDTO empPayrollDTO);
	
	void deleteEmployeePayrollData(int empId);
	
}
