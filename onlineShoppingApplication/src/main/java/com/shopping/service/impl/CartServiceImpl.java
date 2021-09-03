package com.shopping.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entities.Cart;
import com.shopping.entities.Product;
import com.shopping.repository.CartRepository;
import com.shopping.service.CartService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepository cartRepo;

	@Override
	public Cart addProductToCart(Cart cart, Product p, int quantity) {
		List<Product> products = cart.getProducts();
		p.setQuantity(quantity);
		products.add(p);
		cart.setProducts(products);
		return cartRepo.save(cart);
	}

	@Override
	public Cart removeProductFromCart(Cart cart, Product p) {
		List<Product> products = cart.getProducts();
		products.remove(p);
		cart.setProducts(products);
		return cartRepo.save(cart);
	}

	@Override
	public Cart updateProductQuantity(Cart cart, Product p, int quantity) {
		List<Product> products = cart.getProducts();
		int index = products.indexOf(p);
		Product existingProduct = products.get(index);
		existingProduct.setQuantity(quantity);
		products.set(index, existingProduct);
		cart.setProducts(products);
		return cartRepo.save(cart);
	}

	@Override
	public Cart removeAllProducts(Cart cart) {
		List<Product> products = new ArrayList<>();
		cart.setProducts(products);
		return cartRepo.save(cart);
	}

	@Override
	public List<Product> viewAllProducts(Cart cart) {
		return cart.getProducts();
	}

}
