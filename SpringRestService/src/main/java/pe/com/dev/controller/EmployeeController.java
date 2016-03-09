	package pe.com.dev.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.dev.constant.URIConstants;
import pe.com.dev.domain.Employee;
import pe.com.dev.domain.Employees;
import pe.com.dev.service.EmployeeService;

@Controller("employeeController")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping(value = URIConstants.GET_EMP, method = RequestMethod.GET)
	public @ResponseBody Employee getEmployee(@PathVariable("id") int empId) {
		Employee result = new Employee();
        logger.info("Start getEmployee. ID= "+empId);
        result = service.EmployeeInfo(empId);
        return result;
	}
	
	@RequestMapping(value = URIConstants.GET_ALL_EMP, method = RequestMethod.GET)
	public @ResponseBody Employees getAllEmployees() {
		Employees result = new Employees();
        logger.info("Start getAllEmployees. ="+result);
        result = service.EmployeeList();
        return result;
	}
	
	@RequestMapping(value = URIConstants.CREATE_EMP, method = RequestMethod.POST)
	public @ResponseBody int createEmployee(@RequestBody Employee employee) {
		int result = 0;
        logger.info("Start createEmployee. input= "+employee);
        result = service.createEmployee(employee);
        return result;
	}
	
	@RequestMapping(value = URIConstants.UPDATE_EMP, method = RequestMethod.PUT)
	public @ResponseBody int updateEmployee(@RequestBody Employee employee) {
		int result = 0;
        logger.info("Start updateEmployee. input= "+employee);
		result = service.modifyEmployee(employee);
        return result;
	}
	
	@RequestMapping(value = URIConstants.DELETE_EMP, method = RequestMethod.DELETE)
	public @ResponseBody int deleteEmployee(@PathVariable("id") int employeeId) {
		int result = 0;
		logger.info("Start deleteEmployee. ID= "+employeeId);
		result = service.removeEmployee(employeeId);
        return result;
	}
}
