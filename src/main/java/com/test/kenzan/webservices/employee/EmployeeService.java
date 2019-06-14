package com.test.kenzan.webservices.employee;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Optional;

import org.springframework.stereotype.Service;


@Service
public class EmployeeService {
	
	private static HashMap<Integer, Employee> employees = new HashMap<Integer, Employee>();
	private static int idCounter = 0;
	
	static {
		employees.put(++idCounter, new Employee(idCounter, "FirstName1", "MiddleInitial1", "LastName1", new Date(), new Date(), true));
		employees.put(++idCounter, new Employee(idCounter, "FirstName2", "MiddleInitial2", "LastName2", new Date(), new Date(), true));
		employees.put(++idCounter, new Employee(idCounter, "FirstName3", "MiddleInitial3", "LastName3", new Date(), new Date(), true));
	}
	
	public Collection<Employee> findAll(){

		HashMap<Integer, Employee> tempEmployees = new HashMap<Integer, Employee>();
		
		employees.forEach((k, v) -> {
			if(v.getStatus())
				tempEmployees.put(k, v);
		});
		
		return tempEmployees.values();
	}
	
	public Employee save(Employee employee) {
		if(employee.getId() == -1 || employee.getId() == 0) {
			employee.setId(++idCounter);
			employees.put(idCounter, employee);
		}else {
			deleteById(employee.getId());
			employees.put(employee.getId(), employee);
		}
		return employee;
	}
	
	public Optional<Employee> deleteById(Integer id) {
		
		Optional<Employee> optEmployee = findById(id);
		if(!optEmployee.isPresent())
			return Optional.empty();
		else
			optEmployee.get().setStatus(false);

		employees.put((int) optEmployee.get().getId(), optEmployee.get());
		
		return optEmployee;
	}
	
	public Optional<Employee> findById(Integer id) {
		
		if(employees.containsKey(id)) {
			Employee tempEmployee = employees.get(id);
			if(tempEmployee.getStatus())
				return Optional.of(tempEmployee);
		}
		
		return Optional.empty();
	}
 
}
