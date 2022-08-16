package com.charan.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.productsandcategories.models.Category;
import com.charan.productsandcategories.models.Product;
import com.charan.productsandcategories.repos.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;

	// Read All
	public List<Category> allCategories() {
		return categoryRepo.findAll();
	}

	// Create
	public Category createCategory(Category c) {
		return categoryRepo.save(c);
	}

	// Read One
	public Category findCategory(Long id) {
		Optional<Category> potentialCategory = categoryRepo.findById(id);
		if (potentialCategory.isPresent()) {
			return potentialCategory.get();
		} else {
			return null;
		}
	}

	// Update
	public Category updateCategory(Category c) {
		return categoryRepo.save(c);
	}

	// Delete
	public void deleteCategory(Long id) {
		categoryRepo.deleteById(id);
	}
	
	// Get list of categories that don't have the product in it
	public List<Category> getCategoriesWithoutProduct(Product product){
		return categoryRepo.findAllByProductsNotContains(product);
	}
	
	// Get list of categories that DO have the product in it
	// may not need this because we could just use category.getProducts()?
// decided not needed for reason above (^)
//	public List<Category> getCategoriesWithProduct(Product product){
//		return categoryRepo.findAllByProducts(product);
//	}
}
