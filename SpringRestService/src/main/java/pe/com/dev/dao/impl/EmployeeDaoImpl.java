package pe.com.dev.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import pe.com.dev.dao.EmployeeDao;
import pe.com.dev.domain.Employee;
import pe.com.dev.domain.Employees;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MessageSource messageSource;
	
    public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

	public Employee getEmployee(int employeeId) {
		Employee employee = (Employee) getJdbcTemplate().queryForObject(getEmployeeSql(), new Object[] { employeeId }, new BeanPropertyRowMapper<Employee>(Employee.class));
        return employee;
	}
	
	public Employees getAllEmployees() {
		List<Employee> employees = (ArrayList<Employee>) getJdbcTemplate().query(getAllEmployeesSql(), new BeanPropertyRowMapper<Employee>(Employee.class));
		Employees result = new Employees();
		result.setEmployeeList(employees);
		return result;
	}

	public int addEmployee(Employee employee) {
		int result = 0;
		result = getJdbcTemplate().update(insEmployeeSql(), new Object[] { employee.getEmployeeId(), employee.getFirstName(), employee.getLastName(), employee.getPhone(), employee.getAddress()});
		return result;
	}

	public int updEmployee(Employee employee) {
		int result = 0;
		result = getJdbcTemplate().update(updEmployeeSql(), new Object[] { employee.getFirstName(), employee.getLastName(), employee.getPhone(), employee.getAddress(), employee.getEmployeeId()});
		return result;
	}

	public int delEmployee(int employeeId) {
		int result = 0;
		result = jdbcTemplate.update(delEmployeeSql(), new Object[] { employeeId });
		if(result!=0)
			System.out.println("Employee deleted successfully.");
		else
			System.out.println("Couldn't delete employee with given id as it doesn't exist");
		return result;
	}

	private String getTableName(String table){
		/*
		 * METHOD: getMessageSource
		 * parameters:
		 * - property key
		 * - property parameters e.g: new Object[]{value1,value2,...}
		 * - default value
		 * - Location e.g: _US, _ES, ....
		 * 
		 * */
		String schema = getMessageSource().getMessage("jdbc.driverClassName", null,"postgresql",null);//"postgresql";
		if(schema.contains("postgresql")){
			table = "\"public\".\"" + table + "\"";
		}
		return table;
	}
	private String getEmployeeSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append(getTableName("EMPLOYEE"));
		sql.append(" WHERE employeeId = ?");
		return sql.toString();
	}
	private String getAllEmployeesSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM ");
		sql.append(getTableName("EMPLOYEE"));
		return sql.toString();
	}
	private String insEmployeeSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO ");
		sql.append(getTableName("EMPLOYEE"));
		sql.append(" (employeeId, firstName, lastName, phone, address) VALUES (?, ?, ?, ?, ?)");
		return sql.toString();
	}
	private String updEmployeeSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE ");
		sql.append(getTableName("EMPLOYEE"));
		sql.append(" SET firstName=? , lastName=?, phone=? , address=? WHERE employeeId = ?");
		return sql.toString();
	}
	private String delEmployeeSql(){
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM ");
		sql.append(getTableName("EMPLOYEE"));
		sql.append(" WHERE employeeId = ?");
		return sql.toString();
	}
}
