package pe.com.dev.dao;

import pe.com.dev.domain.Employee;
import pe.com.dev.domain.Employees;

public interface EmployeeDao {
	public Employee getEmployee(int employeeId);
	public Employees getAllEmployees();
	public int addEmployee(Employee employee);
	public int updEmployee(Employee employee);
	public int delEmployee(int employeeId);
}
