package com.shopping.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shopping.entities.Address;
import com.shopping.entities.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	public List<Order> findByOrderDate(LocalDate date);

	public List<Order> findByAddress(Address address);
	@Query(value="SELECT * FROM orders o join customer c on o.customer_id = c.customer_id where c.user_id = :userId",nativeQuery=true)
	public List<Order> findByUser(int userId);
}
