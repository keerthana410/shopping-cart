package com.shopping;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.entities.Address;
import com.shopping.repository.AddressRepository;
import com.shopping.service.AddressService;

@SpringBootTest

public class Addresstests {
	@Autowired
	AddressService aserv;
	
	@MockBean
	AddressRepository addressrepo;
	
	@Test
	public void testInsertAddress() {
		Address addr=new Address();
		Address address=new Address();
		address.setAddressId(1234);
		Mockito.when(addressrepo.save(addr)).thenReturn(address);
		assertEquals(1234,aserv.addAddress(addr).getAddressId());
	}
    
	
	
	@Test
	public void testDeleteAddress() {
		Address addr=new Address();
	    addr.setAddressId(5);
		
	     Mockito.when(addressrepo.findById(5)).thenReturn(Optional.of(addr));
		 assertEquals(5,aserv.removeAddress(5).getAddressId());
		
	}
	@Test
	public void testViewAddress() {
		Address addr= new Address();
	    addr.setAddressId(7);
		
		
	     Mockito.when(addressrepo.findById(7)).thenReturn(Optional.of(addr));
		 assertEquals(7,aserv.viewAddress(7).getAddressId());
		
	}
	
	@Test
	public void testUpdateAddress() {
		Address addr=new Address();
	    addr.setAddressId(10);
	    addr.setCity("ct1");
	   
		 Mockito.when(addressrepo.save(addr)).thenReturn(addr);
	     Mockito.when(addressrepo.findById(10)).thenReturn(Optional.of(addr));
	    
		 assertEquals("ct1",aserv.updateAddress(10,addr).getCity());
		 
		
		
	}
	

}
