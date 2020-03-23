package com.product.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.product.apirest.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findById(long id);
	
}
