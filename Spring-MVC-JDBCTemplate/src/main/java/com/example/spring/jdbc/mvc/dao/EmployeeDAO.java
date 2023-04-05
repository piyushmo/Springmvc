package com.example.spring.jdbc.mvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.example.spring.jdbc.mvc.bean.EmployeeBean;

public class EmployeeDAO {
	
	private static final String GET_ALL_EMPLOYEE_DETAILS = "SELECT EMP_ID,EMP_NAME,EMP_JOB,EMP_SALARY FROM EMPLOYEE_JDBC";
	
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public List<EmployeeBean> retriveAllEmployee(){
		
		List<EmployeeBean> employeeBeansList = (List<EmployeeBean>)jdbcTemplate.query(GET_ALL_EMPLOYEE_DETAILS,new EmployeeRowMapper());
		
		return employeeBeansList;
	}
	
	private class EmployeeRowMapper implements RowMapper<EmployeeBean>{

		@Override
		public EmployeeBean mapRow(ResultSet resultSet, int position) throws SQLException {
			
			EmployeeBean employeeBean = new EmployeeBean(resultSet.getInt(1),
														 resultSet.getString(2),
														 resultSet.getString(3),
														 resultSet.getFloat(4));
			
			return employeeBean;
		}
		
	}
}
