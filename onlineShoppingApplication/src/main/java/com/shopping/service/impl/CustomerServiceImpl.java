package com.shopping.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entities.Customer;
import com.shopping.exception.RecordNotFoundException;
import com.shopping.repository.CustomerRepository;
import com.shopping.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	CustomerRepository customerRepository;  

	@Override
	public Customer addCustomer(Customer cust) {
		return customerRepository.save(cust);
	}

	@Override
	public Customer updateCustomer(Customer cust) {
		Optional<Customer> existingCustomer = customerRepository.findById(cust.getCustomerId());
		if (!existingCustomer.isPresent()) {
			throw new RecordNotFoundException("Customer with Id: " + cust.getCustomerId() + " not found. Try registering a new customer");
		}
		cust.setCustomerId(cust.getCustomerId());
		return customerRepository.save(cust);
	}

	@Override
	public Customer removeCustomer(int customerId) {
		Optional<Customer> existingCustomer = customerRepository.findById(customerId);
		if (!existingCustomer.isPresent()) {
			throw new RecordNotFoundException("Customer with Id: " + customerId + " not found. Try registering a new customer");
		}
		customerRepository.deleteById(customerId);
		return existingCustomer.get();
	}

	@Override
	public Customer viewCustomer(int customerId) {
		Optional<Customer> customer = customerRepository.findById(customerId);
		if (!customer.isPresent()) {
			throw new RecordNotFoundException("Customer with Id: " + customerId + " not found");
		}
		return customer.get();
		
	}

	@Override
	public List<Customer> viewAllCustomers() {
		return customerRepository.findAll();
			
	}

}
