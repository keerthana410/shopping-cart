package com.shopping.repository;
import com.shopping.entities.*;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
	public Optional<Category> findByCategoryName(String categoryName);

}