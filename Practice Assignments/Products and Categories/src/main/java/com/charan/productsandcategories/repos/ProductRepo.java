package com.charan.productsandcategories.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.charan.productsandcategories.models.Category;
import com.charan.productsandcategories.models.Product;

@Repository
public interface ProductRepo extends CrudRepository<Product, Long> {
	
	List<Product> findAll();

	// decided not needed because it's the same as product.categories
//	// Get list of products that have that category
//	List<Product> findAllByCategories(Category category);
	
	// Get list of products that don't have that category
	List<Product> findAllByCategoriesNotContains(Category category);
	
}
