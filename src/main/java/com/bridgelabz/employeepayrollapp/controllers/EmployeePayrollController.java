package com.bridgelabz.employeepayrollapp.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.employeepayrollapp.dto.EmployeePayrollDTO;
import com.bridgelabz.employeepayrollapp.dto.ResponseDTO;
import com.bridgelabz.employeepayrollapp.model.EmployeePayrollData;
import com.bridgelabz.employeepayrollapp.services.IEmployeePayrollService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	@Autowired
	private IEmployeePayrollService employeePayrollService;
	
	//curl localhost:8080/employeepayrollservice/ -w "\n"
	@RequestMapping(value = {"", "/", "/get"})
	public ResponseEntity<ResponseDTO> getEmployeePayrollData() {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeePayrollData();
		ResponseDTO respDTO = new ResponseDTO("Get Call Successful", empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	//curl localhost:8080/employeepayrollservice/get/1 -w "\n"
	@GetMapping("/get/{empId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("empId")int empId) {
		EmployeePayrollData empData = employeePayrollService.getEmployeePayrollDataById(empId);
		ResponseDTO respDTO = new ResponseDTO("Get Call For ID Successful", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	@GetMapping("/department/{department}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("department") String department) {
		List<EmployeePayrollData> empDataList = null;
		empDataList = employeePayrollService.getEmployeesByDepartment(department);
		ResponseDTO respDTO = new ResponseDTO("Get Call For Department Successful", empDataList);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/*
	 * curl -X POST -H "Content-Type:application/json" -d '{"name":"Lisa","salary":2000}' 
	 * "http://localhost:8080/employeepayrollservice/create" -w "\n"
	 */
		
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(
					@Valid
					@RequestBody EmployeePayrollDTO empPayrollDTO) {
		log.debug("Employee DTO" +empPayrollDTO.toString());
		EmployeePayrollData empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Created Employee Payroll Data Successfully", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/*
	 * curl -X PUT -H "Content-Type:application/json" -d '{"name":"Lisa","salary":3000}'
	 * "http://localhost:8080/employeepayrollservice/update/1" -w "\n"
	 */
	
	@PutMapping("/update/{empId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(
					@Valid
					@PathVariable("empId") int empId,
					@RequestBody EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = employeePayrollService.updateEmployeePayrollData(empId, empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO("Updated Employee Payroll Data Successfully", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
	/*
	 * curl -X DELETE -H "Content-Type:application/json"
	 * "http://localhost:8080/employeepayrollservice/delete/1" -w "\n"
	 */
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<ResponseDTO> deleteEmployeePayrollData(@PathVariable("empId")int empId) {
		employeePayrollService.deleteEmployeePayrollData(empId);
		ResponseDTO respDTO = new ResponseDTO("Deleted Successfully", "Deleted id: " +empId);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
}
