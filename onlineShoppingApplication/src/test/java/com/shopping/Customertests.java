package com.shopping;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.entities.Customer;
import com.shopping.repository.CustomerRepository;
import com.shopping.service.CustomerService;

@SpringBootTest
public class Customertests {
	
	@Autowired
	CustomerService custserv;
	
	@MockBean
    CustomerRepository custrepo;
	
	@Test
	public void testInsertCustomer() {
		Customer cust=new Customer();
		Customer customer=new Customer();
		customer.setMobileNumber("1234567890");
		Mockito.when(custrepo.save(cust)).thenReturn(customer);
		assertEquals("1234567890",custserv.addCustomer(cust).getMobileNumber());
	}
    
	
	
	@Test
	public void testDeleteCustomer() {
		Customer customer=new Customer();
	    customer.setCustomerId(1);
		
	     Mockito.when(custrepo.findById(1)).thenReturn(Optional.of(customer));
		 assertEquals(1,custserv.removeCustomer(1).getCustomerId());
		
	}
	
	
	@Test
	public void testViewCustomer() {
		Customer customer= new Customer();
	    customer.setCustomerId(1);
		
		
	     Mockito.when(custrepo.findById(1)).thenReturn(Optional.of(customer));
		 assertEquals(1,custserv.viewCustomer(1).getCustomerId());
		
	}
	
	@Test
	public void testUpdateCustomer() {
		Customer customer=new Customer();
	    customer.setMobileNumber("0000000000");
	    customer.setCustomerId(1);
		
	     Mockito.when(custrepo.findById(1)).thenReturn(Optional.of(customer));
		 assertEquals("0000000000",custserv.updateCustomer(customer).getMobileNumber());
		
	}
	
	
}


