package com.shopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.shopping.entities.Cart;

import com.shopping.entities.Product;
import com.shopping.service.CartService;


@RestController
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/carts/")
	public ResponseEntity<Cart> addProductToCart(@RequestBody Cart cart, Product p , int quantity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(cartService.addProductToCart(cart,p,quantity));
	}
	@GetMapping("/carts/")
	public ResponseEntity<List<Product>> viewAllProducts(@RequestBody Cart cart) {
		return ResponseEntity.ok(cartService.viewAllProducts(cart));
	}
	@PutMapping("/carts/")
	public ResponseEntity<Cart> updateProductQuantity(@RequestBody Cart cart,
			Product p , int quantity) {
		return ResponseEntity.ok(cartService.updateProductQuantity(cart,p,quantity));
	}
	@DeleteMapping("/carts/")
	public ResponseEntity<Cart> removeProductFromCart(@RequestBody Cart cart , Product p) {
		return ResponseEntity.ok(cartService.removeProductFromCart(cart,p));
	}
	@DeleteMapping("/cart/")
	public ResponseEntity<Cart> removeAllProducts(@RequestBody Cart cart) {
		return ResponseEntity.ok(cartService.removeAllProducts(cart));
	}


}
