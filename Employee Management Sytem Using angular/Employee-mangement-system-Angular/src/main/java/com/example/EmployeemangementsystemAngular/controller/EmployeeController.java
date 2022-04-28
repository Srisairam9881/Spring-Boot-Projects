package com.example.EmployeemangementsystemAngular.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeemangementsystemAngular.exception.ResourceNotFoundException;
import com.example.EmployeemangementsystemAngular.model.Employee;
import com.example.EmployeemangementsystemAngular.repository.EmployeeRepository;
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository employeeRepository;

/*********************************** Get All Employees *****************************************************************/
	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
/*********************************** Create Employee Rest Api *********************************************************/
	@PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee emp)
    {
     return employeeRepository.save(emp);
    }
/*********************************** Get Employee by Id Rest Api ******************************************************/
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) throws ResourceNotFoundException 
	{
	Employee emp=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+id));
	return  ResponseEntity.ok(emp);
	}
/*********************************** Update Employee Rest Api  *********************************************************/
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employeeDetails) throws ResourceNotFoundException
	{
	Employee emp=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+id));
	emp.setFirstName(employeeDetails.getFirstName());
	emp.setLastName(employeeDetails.getLastName());
	emp.setEmailId(employeeDetails.getEmailId());
	Employee updatedEmployee=employeeRepository.save(emp);
	return ResponseEntity.ok(updatedEmployee);
	}
/*********************************** Delete Employee Rest Api *********************************************************/
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id) throws ResourceNotFoundException{
	Employee emp=employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id: "+id));
	employeeRepository.delete(emp);
	Map<String, Boolean> response=new HashMap<>();
	response.put("deleted",Boolean.TRUE);
	return ResponseEntity.ok(response);
	}
}
