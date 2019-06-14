package com.test.kenzan.webservices.employee;

import java.net.URI;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.test.kenzan.webservices.employee.Employee;


@RestController
public class EmployeeResource {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employee/employees")
	public Collection<Employee> getAllEmployees(){
		return employeeService.findAll();
	}
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee(@PathVariable Integer id){
		
		Optional<Employee> optEmployee = employeeService.findById(id);
		if(!optEmployee.isPresent())
			return null;
		
		return employeeService.findById(id).get();
	}	
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<Void> deteleEmployee(@PathVariable Integer id){

		Optional<Employee> optEmployee = employeeService.deleteById(id);
		if(optEmployee.isPresent())
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.notFound().build();
		
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(
			@PathVariable Integer id, @RequestBody Employee employee){
		
		Employee employeeUpdate = employeeService.save(employee);
		
		return new ResponseEntity<Employee>(employeeUpdate, HttpStatus.OK);
	
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Void> updateEmployee(
			@RequestBody Employee employee){
		
		Employee createEmployee = employeeService.save(employee);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createEmployee.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	
	}
	
}
