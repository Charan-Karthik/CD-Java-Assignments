package com.charan.productsandcategories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.productsandcategories.models.Category;
import com.charan.productsandcategories.models.Product;

@Repository
public interface CategoryRepo extends CrudRepository<Category, Long> {

	List<Category> findAll();
	
	// decided not needed because it's the same as category.products
//	// Get all the categories that have that product
//	List<Category> findAllByProducts(Product product);
	
	// Get all the categories that don't have that product
	List<Category> findAllByProductsNotContains(Product product);
	
}
