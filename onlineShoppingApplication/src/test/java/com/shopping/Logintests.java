package com.shopping;


	import static org.junit.jupiter.api.Assertions.assertEquals;

	import java.util.Optional;

	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.context.SpringBootTest;
	import org.springframework.boot.test.mock.mockito.MockBean;

import com.shopping.entities.User;
import com.shopping.repository.LoginRepository;
	import com.shopping.service.LoginService;

	@SpringBootTest
public class Logintests {
		
		@Autowired
		LoginService lserv;
		
		@MockBean
		LoginRepository lrepo;
		
		@Test
		public void testInsertLogin() {
	
			User login=new User();
			login.setUserName("keerthana");
			login.setPassword("123");
			login.setRole("customer");
			
			
			Mockito.when(lrepo.save(login)).thenReturn(login);
			assertEquals("customer",lserv.addUser(login).getRole());
		}
	    
		
		
		@Test
		public void testDeleteLogin() {
			User log =new User();
		    log.setUserId(3);
			
		     Mockito.when(lrepo.findById(3)).thenReturn(Optional.of(log));
			 assertEquals(3,lserv.removeUser(log).getUserId());
			
		}
		
		@Test
		public void testValidateUser() {
			User log= new User();
		    log.setPassword("5678");
		    log.setUserName("keerthana");
			
			
		     Mockito.when(lrepo.validateUser("keerthana","5678","user")).thenReturn(log);
			 assertEquals("5678",lserv.validateUser(log).getPassword());
			 
		}
	}
		
		
		