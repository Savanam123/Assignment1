package com.jocata.mapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.mapping.entity.Employee;
import com.jocata.mapping.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@PostMapping("saveEmployees")
	public ResponseEntity<String> saveEmployee(@RequestBody List<Employee> empData) {
		employeeRepository.saveAll(empData);
		return ResponseEntity.ok("Data SuccessFully Saved");
	}

	@GetMapping("/getAllEmployee")
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<?> deleteEmployee(@RequestBody Employee employee) {

		Employee employee2 = new Employee();

		employee2.setEmpId(employee.getEmpId());

		employeeRepository.deleteById(employee.getEmpId());
		return ResponseEntity.ok("Data Delete Successfully!!!");

	}

	@GetMapping("/getById/{id}")
	public Optional<Employee> get(@PathVariable int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee == null) {
			throw new RuntimeException("Employee with id " + id + " is not found");
		}
		return employee;
	}

}
