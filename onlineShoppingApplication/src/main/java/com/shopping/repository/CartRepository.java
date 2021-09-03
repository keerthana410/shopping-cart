package com.shopping.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shopping.entities.Cart;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	
	
}
