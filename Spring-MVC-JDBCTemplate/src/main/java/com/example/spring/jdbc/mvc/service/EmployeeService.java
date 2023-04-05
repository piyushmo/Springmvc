package com.example.spring.jdbc.mvc.service;

import java.util.ArrayList;
import java.util.List;

import com.example.spring.jdbc.mvc.bean.EmployeeBean;
import com.example.spring.jdbc.mvc.dao.EmployeeDAO;
import com.example.spring.jdbc.mvc.dto.EmployeeDTO;

public class EmployeeService {

	private EmployeeDAO employeeDAO;

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

	public List<EmployeeDTO> getAllEmployeeRecord(){
		
		List<EmployeeBean> employeeBeansList = employeeDAO.retriveAllEmployee();
		
		List<EmployeeDTO> employeeDTOsList = new ArrayList<EmployeeDTO>();
		
		for(EmployeeBean employeeList : employeeBeansList) {
			
			EmployeeDTO dto = new EmployeeDTO(employeeList.getEmployee_id(),
											  employeeList.getEmployee_name(),
											  employeeList.getEmploye_job(),
											  employeeList.getEmployee_salary());
			employeeDTOsList.add(dto);
		}
		
		return employeeDTOsList;
		
	}
	
}
