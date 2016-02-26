package pe.com.dev.service;

import pe.com.dev.domain.Employee;
import pe.com.dev.domain.Employees;

public interface EmployeeService {
	public Employee EmployeeInfo(int employeeId);
	public Employees EmployeeList();
	public int createEmployee(Employee employee);
	public int modifyEmployee(Employee employee);
	public int removeEmployee(int employeeId);
}
