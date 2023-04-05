package com.example.spring.jdbc.inter;

import java.util.List;
import java.util.Map;

public interface DBOperation {
	
	public int insert(int no, String name, String job, long salary);
	
	public int getSalaryById(int no);
	
	public Map<String, Object> listEmployeeList(int no);
	
	public List<Map<String, Object>> listAllEmployee();
	
	public int updateEmployeeSalaryById(int no, int newSalary);
	
	public int delete(int no);
}
