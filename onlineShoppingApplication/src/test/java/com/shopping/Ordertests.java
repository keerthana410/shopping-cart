package com.shopping;


	import static org.junit.jupiter.api.Assertions.assertEquals;

	import java.util.Optional;

	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

	import com.shopping.entities.Order;
	import com.shopping.repository.OrderRepository;
	import com.shopping.service.OrderService;

	@SpringBootTest
public class Ordertests {
		
		@Autowired
		OrderService oserv;
		
		@MockBean
		OrderRepository orderrepo;
		
		@Test
		public void testInsertOrder() {
			Order ord=new Order();
			Order order=new Order();
			order.setOrderId(110);
			Mockito.when(orderrepo.save(ord)).thenReturn(order);
			assertEquals(110,oserv.addOrder(ord).getOrderId());
		}
	    
		
		
		@Test
		public void testDeleteOrder() {
			Order order=new Order();
		    order.setOrderId(3);
			
		     Mockito.when(orderrepo.findById(3)).thenReturn(Optional.of(order));
			 assertEquals(3,oserv.removeOrder(3).getOrderId());
			
		}
		
		
		@Test
		public void testViewOrder() {
			Order order= new Order();
		    order.setOrderId(7);
			
			
		     Mockito.when(orderrepo.findById(7)).thenReturn(Optional.of(order));
			 assertEquals(7,oserv.viewOrder(7).getOrderId());
			
		}
		
		@Test
		public void testUpdateOrder() {
			Order order=new Order();
			order.setOrderStatus("ordered");
		    order.setOrderId(10);
		   
			
		     Mockito.when(orderrepo.findById(10)).thenReturn(Optional.of(order));
		    
			 assertEquals(10,oserv.updateOrder(10,order).getOrderId());
			 
			
			
		}
		
		
		
		
		
		
	}


