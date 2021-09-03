package com.shopping.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.entities.Category;
import com.shopping.entities.Product;
import com.shopping.exception.RecordNotFoundException;
import com.shopping.repository.CategoryRepository;
import com.shopping.repository.ProductRepository;
import com.shopping.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	CategoryRepository categoryRepository;
	
	private static String getErrorMessage(int productId) {
		return "Product with id : " + productId + " not found";
	}

	@Override
	public Product addProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public List<Product> viewAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product viewProduct(int productId) throws RecordNotFoundException {
		Optional<Product> product = productRepository.findById(productId);
		if (!product.isPresent()) {
			throw new RecordNotFoundException(getErrorMessage(productId));
		}
		return product.get();
	}

	@Override
	public List<Product> viewProductByCategory(String categoryName) {
		Optional<Category> category = categoryRepository.findByCategoryName(categoryName);
		if (!category.isPresent()) {
			throw new RecordNotFoundException("Category with name : " + categoryName + " not found");

		}
		return productRepository.findProductByCategory(category.get());
	}

	@Override
	public Product updateProduct(int productId, Product product) {
		Optional<Product> existingProduct = productRepository.findById(productId);
		if (!existingProduct.isPresent()) {
			throw new RecordNotFoundException(getErrorMessage(productId));
		}
		product.setProductId(productId);
		return productRepository.save(product);

	}

	@Override
	public Product deleteProduct(int productId) {
		Optional<Product> existingProduct = productRepository.findById(productId);
		if (!existingProduct.isPresent()) {
			throw new RecordNotFoundException(getErrorMessage(productId));
		}
		productRepository.deleteById(productId);
		return existingProduct.get();
	}

}