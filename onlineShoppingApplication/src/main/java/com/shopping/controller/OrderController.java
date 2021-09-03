package com.shopping.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.entities.Address;
import com.shopping.entities.Order;
import com.shopping.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("/orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orderService.addOrder(order));
	}

	@GetMapping("/orders/{date}")
	public ResponseEntity<List<Order>> viewAllOrder(@PathVariable("date") LocalDate date) {
		return ResponseEntity.ok(orderService.viewAllOrder(date));
	}

	@GetMapping("/orders/{orderId}")
	public ResponseEntity<Order> viewOrder(@PathVariable("orderId") int orderId) {
		return ResponseEntity.ok(orderService.viewOrder(orderId));
	}

	@PutMapping("/orders/{orderId}")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order, @PathVariable("orderId") int orderId) {
		return ResponseEntity.ok(orderService.updateOrder(orderId, order));
	}

	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<Order> removeOrder(@PathVariable("orderId") int orderId) {
		return ResponseEntity.ok(orderService.removeOrder(orderId));
	}

	@GetMapping("/orders/location")
	public ResponseEntity<List<Order>> viewAllOrdersByLocation(@RequestBody Address address) {
		return ResponseEntity.ok(orderService.viewAllOrderByLocation(address));

	}

	@GetMapping("/orders/user/{userId}")
	public ResponseEntity<List<Order>> viewAllOrdersByUserId(@PathVariable("userId") int userId) {
		return ResponseEntity.ok(orderService.viewAllOrderByUserId(userId));
	}
}
