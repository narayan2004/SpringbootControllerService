package com.capgemini.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.capgemini.demo.beans.Employee;



@Service
public class EmployeeService
{
   private List<Employee> emps = new ArrayList<>(Arrays.asList(                    //Arrays.asList is not mutable
        new Employee("1","Sai","Soft Engineer",50000),
        new Employee("2","Virat","Proj Manager",70000),
        new Employee("3","Rohit","Team Lead",30000),
        new Employee("4","Pant","Manager",20000)
  ));

 public List<Employee> getAllEmps()
 {
    return emps;
 }
 
 public Employee getEmp(String id)
 {
	 return emps.stream().filter(t->t.getId().equals(id)).findFirst().get();
 }

public void addEmp(Employee emp) {
	emps.add(emp);
	
}

public void updateEmp(String id, Employee emp) {
	for(int i=0;i<emps.size();i++)
	{
		Employee t =emps.get(i);
		if(t.getId().equals(id))
		{
			emps.set(i, emp);
			return;
		}
	}
	
}

public void deleteEmp(String id) {
	emps.removeIf(t->t.getId().equals(id));
	
}

public List<Employee> getFilterSalary() {
	 return emps.stream().filter(emp->emp.getSalary()>40000 && emp.getSalary() < 80000 ).collect(Collectors.toList());
}
}

