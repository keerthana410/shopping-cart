package com.shopping;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.entities.Product;

import com.shopping.repository.ProductRepository;

import com.shopping.service.ProductService;

@SpringBootTest
public class Producttests {
	@Autowired
	ProductService pserv;
	
	@MockBean
	ProductRepository productrepo;
	
	@Test
	public void testInsertProduct() {
		Product pro=new Product();
		Product product=new Product();
		product.setProductId(12345);
		Mockito.when(productrepo.save(pro)).thenReturn(product);
		assertEquals(12345,pserv.addProduct(product).getProductId());
	}
    
	
	
	@Test
	public void testDeleteProduct() {
		Product pro=new Product();
	    pro.setProductId(5);
		
	     Mockito.when(productrepo.findById(5)).thenReturn(Optional.of(pro));
		 assertEquals(5,pserv.deleteProduct(5).getProductId());
		
	}
	@Test
	public void testViewProduct() {
		Product pro= new Product();
	    pro.setProductId(7);
		
		
	     Mockito.when(productrepo.findById(7)).thenReturn(Optional.of(pro));
		 assertEquals(7,pserv.viewProduct(7).getProductId());
		
	}
	
	@Test
	public void testUpdateProduct() {
		Product pro=new Product();
	    pro.setProductId(12);
	   
		
	     Mockito.when(productrepo.findById(12)).thenReturn(Optional.of(pro));
	    
		 assertEquals(12,pserv.updateProduct(12,pro).getProductId());
		 
		
		
	}
	

}



