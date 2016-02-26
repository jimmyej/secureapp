package pe.com.dev.domain;

import java.util.List;

public class Employees {
	private List<Employee> employeeList;
	public List<Employee> getEmployeeList() {
		return employeeList;
	}
	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	@Override
	public String toString() {
		return "Employees [employeeList=" + employeeList + "]";
	}
}
