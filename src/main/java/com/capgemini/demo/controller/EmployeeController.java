package com.capgemini.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.demo.beans.Employee;
import com.capgemini.demo.service.EmployeeService;

@RestController
public class EmployeeController{

@Autowired
private EmployeeService employeeService;

@RequestMapping("/emps")
public List<Employee> getAllEmps()
{
   return employeeService.getAllEmps();
}

@RequestMapping("/emps/{id}")
public Employee getEmp(@PathVariable String id)
{
  return employeeService.getEmp(id);
}


@RequestMapping(method=RequestMethod.POST,value="/addEmp")
public void addEmp(@RequestBody Employee emp)
{
	employeeService.addEmp(emp);
}

@RequestMapping(method=RequestMethod.PUT,value="/emps/{id}")
public void updateEmp(@RequestBody Employee emp,@PathVariable String id )
{
	employeeService.updateEmp(id,emp);
}

@RequestMapping(method=RequestMethod.DELETE,value="/emps/{id}")
public void deleteEmp(@PathVariable String id )
{
	employeeService.deleteEmp(id);
}

@RequestMapping("/filterSal")
public List<Employee> getFilterSalary()
{
   return employeeService.getFilterSalary();
}
}