package com.jocata.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jocata.customer.entity.CustomerDetails;
import com.jocata.customer.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping("/customer")
	public void save(@RequestBody CustomerDetails custome) {
		customerService.save(custome);

	}

	@GetMapping("/customer")
	public List<CustomerDetails> getAll() {
		return customerService.getAll();

	}

	@GetMapping("/customer/{id}")
	public CustomerDetails get(@PathVariable int id) {
		CustomerDetails employeeObj = customerService.get(id);
		if (employeeObj == null) {
			throw new RuntimeException("Employee with id" + id + " is not found");
		}
		return employeeObj;
	}

	@DeleteMapping("/customer/{id}")
	public String deleteById(@PathVariable int id) {
		customerService.deleteById(id);
		return "Employee has been deleted with id" + id;

	}

}
