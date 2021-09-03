package com.shopping.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entities.Address;
import com.shopping.entities.Order;
import com.shopping.exception.RecordNotFoundException;
import com.shopping.repository.OrderRepository;
import com.shopping.repository.UserRepository;
import com.shopping.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	UserRepository userRepo;

	@Override
	public Order addOrder(Order order) {
		return orderRepo.save(order);
	}

	@Override
	public Order updateOrder(int orderId, Order order) {
		Optional<Order> existingOrder = orderRepo.findById(orderId);
		if (!existingOrder.isPresent()) {
			throw new RecordNotFoundException("Order with Id: " + orderId + " not found. Try saving a new product");
		}
		order.setOrderId(orderId);
		return orderRepo.save(order);

	}

	@Override
	public Order removeOrder(int orderId) {
		Optional<Order> existingOrder = orderRepo.findById(orderId);
		if (!existingOrder.isPresent()) {
			throw new RecordNotFoundException("Order with Id: " + orderId + " not found. Try saving a new product");
		}
		orderRepo.deleteById(orderId);
		return existingOrder.get();
	}

	@Override
	public Order viewOrder(int orderId) throws RecordNotFoundException {
		Optional<Order> order = orderRepo.findById(orderId);
		if (!order.isPresent()) {
			throw new RecordNotFoundException("Order with Id: " + orderId + " not found");
		}
		return order.get();
	}

	@Override
	public List<Order> viewAllOrder(LocalDate date) {
		return orderRepo.findByOrderDate(date);
	}

	@Override
	public List<Order> viewAllOrderByLocation(Address adddress) {
		return orderRepo.findByAddress(adddress);
	}

	@Override
	public List<Order> viewAllOrderByUserId(int userId) {
		return orderRepo.findByUser(userId);
	}

}
