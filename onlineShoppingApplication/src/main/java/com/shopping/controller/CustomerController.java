package com.shopping.controller;

import java.util.List;

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

import com.shopping.entities.Customer;
import com.shopping.service.CustomerService;
@RestController
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customer));
	}
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> viewAllCustomers() {
		return ResponseEntity.ok(customerService.viewAllCustomers());
	}

	@GetMapping("/customers/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable("customerId") int customerId) {
		return ResponseEntity.ok(customerService.viewCustomer(customerId));
	}
	
	@PutMapping("/customers/{customerId}")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer,
			@PathVariable("customerId") int customerId) {
		return ResponseEntity.ok(customerService.updateCustomer(customer));
	}

	@DeleteMapping("/customer/{customerId}")
	public ResponseEntity<Customer> removeCustomer(@PathVariable("customerId") int customerId) {
		return ResponseEntity.ok(customerService.removeCustomer(customerId));
	}


}
