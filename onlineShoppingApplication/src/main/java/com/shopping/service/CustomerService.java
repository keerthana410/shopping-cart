package com.shopping.service;

import java.util.List;

import com.shopping.entities.Customer;

public interface CustomerService 
{
		public Customer addCustomer(Customer cust);
		
		public Customer updateCustomer(Customer cust);
		
		public Customer removeCustomer(int customerId);
		
		public Customer viewCustomer(int customerId);
		
		public List<Customer> viewAllCustomers();

}
