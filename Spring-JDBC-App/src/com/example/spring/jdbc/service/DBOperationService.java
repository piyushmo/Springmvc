package com.example.spring.jdbc.service;

import java.util.List;
import java.util.Map;

import com.example.spring.jdbc.inter.DBOperationDAO;

public class DBOperationService {

	private DBOperationDAO dao;

	public void setDao(DBOperationDAO dao) {
		this.dao = dao;
	}

	public String createEmployee(int no, String name, String job, long salary) {
		int result = dao.insert(no, name, job, salary);
				
				if(result == 0) {
					
					return result +" Employee not registred";
				}else {
					
					return result +" Employee is egistred ";
				}
	}
	
	public String hikeSalary(int no) {
		int newSalary = 0;
		try {
		int salary = dao.getSalaryById(no);
		
		System.out.println();
		
		
		 if(salary < 52800) {
			 
			 newSalary = Math.round(salary+(salary*0f));
			 System.out.println("1% "+newSalary);
		 }else {
			 
			 newSalary = Math.round(salary+(salary*0.20f));
			 System.out.println("2% "+newSalary);
		 }
		
		 
		}catch(Exception e) {
			e.printStackTrace();
		}
		int result = dao.updateEmployeeSalaryById(no, newSalary);
		 if(result == 0) {
				
				return no +" Employee Salary not hiked";
		}else {
				
				return no +" Employee Salary is hike ";
			}
		 
		
	}
	
	public Map<String, Object> getEmployeeDetails(int no)throws Exception{
		System.out.println("**** ****************** "+no);
		Map<String, Object> employeeDetails = dao.listEmployeeList(no);
		
		if(employeeDetails!=null) {
			
			return employeeDetails;
		}else {
			
			throw new  Exception(no +" Employee found in DB");
		}
	}
	
	public List<Map<String, Object>> getAllEmployeeDetails()throws Exception{
		List<Map<String, Object>>  employeeDetailsList = dao.listAllEmployee();
		
		if(employeeDetailsList!=null) {
			
			return employeeDetailsList;
		}else {
			
			throw new  Exception(" Employees found in DB");
		}
	}

	public String removeEmployeeDetails(int no) {
		
		
		int result = dao.delete(no);
			
		if(result==0) {
			
			return no+" Employee record not found";
		}else {
			
			return " Employee record removed from DB";
		}
	}
}

