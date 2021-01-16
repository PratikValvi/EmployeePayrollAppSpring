package com.bridgelabz.employeepayrollapp.controllers;

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

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {
	
	//curl localhost:8080/employeepayrollservice/ -w "\n"
	@RequestMapping(value = {"", "/", "/get"})
	public ResponseEntity<String> getEmployeePayrollData() {
		return new ResponseEntity<String>("Get Call Success", HttpStatus.OK);
	}
	
	//curl localhost:8080/employeepayrollservice/get/1 -w "\n"
	@GetMapping("/get/{empId}")
	public ResponseEntity<String> getEmployeePayrollData(@PathVariable("empId")int empId) {
		return new ResponseEntity<String>("Get Call Success for id: "+empId, HttpStatus.OK);
	}
	
	/*
	 * curl -X POST -H "Content-Type:application/json" -d '{"name":"Lisa","salary":2000}' 
	 * "http://localhost:8080/employeepayrollservice/create" -w "\n"
	 */
		
	@PostMapping("/create")
	public ResponseEntity<String> addEmployeePayrollData(
								  @RequestBody EmployeePayrollDTO empPayrollDTO) {
		return new ResponseEntity<String>("Created Employee Payroll Data for: "+
								  		  empPayrollDTO, HttpStatus.OK);
	}
	
	/*
	 * curl -X PUT -H "Content-Type:application/json" -d '{"name":"Lisa","salary":3000}' 
	 * "http://localhost:8080/employeepayrollservice/update" -w "\n"
	 */
	
	@PutMapping("/update")
	public ResponseEntity<String> updateEmployeePayrollData(
								  @RequestBody EmployeePayrollDTO empPayrollDTO) {
		return new ResponseEntity<String>("Updated Employee Payroll Data for: "+
								  		  empPayrollDTO, HttpStatus.OK);
	}
	
	/*
	 * curl -X DELETE -H "Content-Type:application/json"
	 * "http://localhost:8080/employeepayrollservice/delete/1" -w "\n"
	 */
	
	@DeleteMapping("/delete/{empId}")
	public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable("empId")int empId) {
		return new ResponseEntity<String>("Delete Call Success for id: "+empId, HttpStatus.OK);
	}
}
