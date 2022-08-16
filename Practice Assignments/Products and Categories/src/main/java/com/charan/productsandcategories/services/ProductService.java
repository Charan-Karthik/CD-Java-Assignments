package com.charan.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.charan.productsandcategories.models.Category;
import com.charan.productsandcategories.models.Product;
import com.charan.productsandcategories.repos.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;

	// Read All
	public List<Product> allProducts() {
		return productRepo.findAll();
	}

	// Create
	public Product createProduct(Product p) {
		return productRepo.save(p);
	}

	// Read One
	public Product findProduct(Long id) {
		Optional<Product> potentialProduct = productRepo.findById(id);
		if (potentialProduct.isPresent()) {
			return potentialProduct.get();
		} else {
			return null;
		}
	}

	// Update
	public Product updateProduct(Product p) {
		return productRepo.save(p);
	}

	// Delete
	public void deleteProduct(Long id) {
		productRepo.deleteById(id);
	}
	
	// List of products in that category
	// may not need this because we could just use product.getCategories()
// ^ decided not needed for reason above
//	public List<Product> getProductsInCategory(Category category){
//		return productRepo.findAllByCategories(category);
//	}
	
	// List of products not in that category
	public List<Product> getProductsNotInCategory(Category category){
		return productRepo.findAllByCategoriesNotContains(category);
	}
}
