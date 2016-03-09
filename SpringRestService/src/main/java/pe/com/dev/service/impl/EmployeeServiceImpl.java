package pe.com.dev.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pe.com.dev.dao.EmployeeDao;
import pe.com.dev.domain.Employee;
import pe.com.dev.domain.Employees;
import pe.com.dev.service.EmployeeService;

@Repository("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeDao dao;

	public Employee EmployeeInfo(int employeeId) {
		Employee result = new Employee();
		result = dao.getEmployee(employeeId);
		return result;
	}

	public Employees EmployeeList() {
		Employees result = new Employees();
		result = dao.getAllEmployees();
		return result;
	}

	public int createEmployee(Employee employee) {
		int result = 0;
		result = dao.addEmployee(employee);
		return result;
	}

	public int modifyEmployee(Employee employee) {
		int result = 0;
		result = dao.updEmployee(employee);
		return result;
	}

	public int removeEmployee(int employeeId) {
		int result = 0;
		result = dao.delEmployee(employeeId);
		return result;
	}

}
