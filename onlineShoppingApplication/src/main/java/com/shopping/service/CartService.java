package com.shopping.service;

import java.util.List;

import com.shopping.entities.Cart;
import com.shopping.entities.Product;

public interface CartService {

	public Cart addProductToCart(Cart cart, Product p, int quantity);

	public Cart removeProductFromCart(Cart cart, Product p);

	public Cart updateProductQuantity(Cart cart, Product p, int quantity);

	public Cart removeAllProducts(Cart cart);

	public List<Product> viewAllProducts(Cart cart);
}
