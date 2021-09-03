package com.shopping.service;

import java.time.LocalDate;
import java.util.List;

import com.shopping.entities.Address;
import com.shopping.entities.Order;

public interface OrderService {

	public Order addOrder(Order order);

	public Order updateOrder(int orderId,Order order);

	public Order removeOrder(int orderId);

	public Order viewOrder(int orderId);

	public List<Order> viewAllOrder(LocalDate date);

	public List<Order> viewAllOrderByLocation(Address adddress);

	public List<Order> viewAllOrderByUserId(int userId);

	
}
