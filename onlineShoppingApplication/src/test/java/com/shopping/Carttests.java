package com.shopping;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.entities.Cart;
import com.shopping.entities.Product;
import com.shopping.repository.CartRepository;
import com.shopping.service.CartService;

@SpringBootTest

public class Carttests {

	@Autowired
	CartService cserv;
	
	@MockBean
	CartRepository cartrepo;
	
	@Test
	public void testInsertCart() {
		Cart car=new Cart();
		Cart cart=new Cart();
		Product p=new Product();
		cart.setCartId(10);
		Mockito.when(cartrepo.save(car)).thenReturn(cart);
		assertEquals(10,cserv.addProductToCart(cart,p,5).getCartId());
	}
    
	
	
	@Test
	public void testDeleteCart() {
		Cart car=new Cart();
		Product p=new Product();
	    car.setCartId(5);
		
	     Mockito.when(cartrepo.findById(5)).thenReturn(Optional.of(car));
	     
		 assertEquals(5,cserv.removeProductFromCart(car,p).getCartId());
		
	}
	
	
	@Test
	public void testUpdateCart() {
		Cart car=new Cart();
		Product p= new Product();
	    car.setCartId(10);
	    
	   
	     Mockito.when(cartrepo.save(car)).thenReturn(car);
	     Mockito.when(cartrepo.findById(10)).thenReturn(Optional.of(car));
	     
		 assertEquals(10,cserv.updateProductQuantity(car,p,5).getCustomer());
		 
		
		
	}
	

}


