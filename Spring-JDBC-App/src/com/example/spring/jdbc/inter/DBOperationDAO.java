package com.example.spring.jdbc.inter;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class DBOperationDAO implements DBOperation {

	private static final String INSERT_EMPLOYEE = "INSERT INTO EMPLOYEE_JDBC(EMP_ID,EMP_NAME,EMP_JOB,EMP_SALARY)VALUES(?,?,?,?)";
	
	private static final String GET_EMPLOYEE_SALARY_BY_ID = "SELECT EMP_SALARY FROM  EMPLOYEE_JDBC WHERE EMP_ID=?";
	
	private static final String GET_EMPLOYEE_DETAILS_BY_ID = "SELECT * FROM EMPLOYEE_JDBC WHERE EMP_ID=?";
	
	private static final String GET_ALL_EMPLOYEE_DATAILS = "SELECT EMP_ID,EMP_NAME,EMP_JOB,EMP_SALARY FROM EMPLOYEE_JDBC";
	
	private static final String UPDATE_EMPLOYE_SALARY_BY_ID = "UPDATE EMPLOYEE_JDBC  SET EMP_SALARY=? WHERE EMP_ID=?";
	
	private static final String  DELETE_EMPLOYEE_JDBC ="DELETE FROM EMPLOYEE_JDBC  WHERE EMP_ID = ?";
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insert(int no, String name, String job, long salary) {
		
		int result = jdbcTemplate.update(INSERT_EMPLOYEE,no,name,job,salary);
		
		return result;
	}

	@Override
	public int getSalaryById(int no) {

		int salary = jdbcTemplate.queryForInt(GET_EMPLOYEE_SALARY_BY_ID,no);
		System.out.println("*******DAO******** "+salary);
		return salary;
	}

	@Override
	public Map<String, Object> listEmployeeList(int no) {

		Map<String, Object> map = jdbcTemplate.queryForMap(GET_EMPLOYEE_DETAILS_BY_ID,no);
		
		
		return map;
	}

	@Override
	public List<Map<String, Object>> listAllEmployee() {

		List<Map<String, Object>> map = jdbcTemplate.queryForList(GET_ALL_EMPLOYEE_DATAILS);
		
		return map;
	}

	@Override
	public int updateEmployeeSalaryById(int no, int newSalary) {
System.out.println(no +"     "+newSalary);
		int result = jdbcTemplate.update(UPDATE_EMPLOYE_SALARY_BY_ID,newSalary,no);
		
		return result;
	}

	@Override
	public int delete(int no) {

		int result = jdbcTemplate.update(DELETE_EMPLOYEE_JDBC,no);
		
		return result;
	}

}
