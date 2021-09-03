package com.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.entities.User;
@Repository
public interface LoginRepository extends JpaRepository<User, Integer>{

	//Object validateUser(User log);
	
	@Query("from User where userName=?1 AND password=?2 AND role=?3")
	
	 User validateUser(String username, String password, String role);




	
}
