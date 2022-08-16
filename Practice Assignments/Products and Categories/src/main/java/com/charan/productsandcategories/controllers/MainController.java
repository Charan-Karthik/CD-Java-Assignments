package com.charan.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.charan.productsandcategories.models.Category;
import com.charan.productsandcategories.models.Product;
import com.charan.productsandcategories.services.CategoryService;
import com.charan.productsandcategories.services.ProductService;

@Controller
public class MainController {
	
	@Autowired
	CategoryService categoryServ;
	
	@Autowired
	ProductService productServ;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<Product> allProducts = productServ.allProducts();
		model.addAttribute("allProducts", allProducts);
		
		List<Category> allCategories = categoryServ.allCategories();
		model.addAttribute("allCategories", allCategories);
		
		return "home.jsp";
	}
	
	@GetMapping("/new/product")
	public String newProduct(@ModelAttribute("newProduct")Product newProduct) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/new/product")
	public String addNewProduct(@Valid @ModelAttribute("newProduct") Product newProduct, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newProduct.jsp";
		} else {
			productServ.createProduct(newProduct);
			return "redirect:/";
		}
	}
	
	@GetMapping("/product/{id}")
	public String oneProduct(@PathVariable("id") Long productID, Model model) {
		
		Product product = productServ.findProduct(productID);
		model.addAttribute("product", product);
		
// decided not needed because this is the same as product.categories
		// list of all the categories that has the product in it
//		List<Category> categoriesWithProduct = categoryServ.getCategoriesWithProduct(product);
//		model.addAttribute("categoriesWithProduct", categoriesWithProduct);
		
		// list of all the categories that doesn't have the product in it
		List<Category> categoriesWithoutProduct = categoryServ.getCategoriesWithoutProduct(product);
		model.addAttribute("categoriesWithoutProduct", categoriesWithoutProduct);
		
		return "oneProduct.jsp";
	}
	
	@PostMapping("/product/{id}/add/category")
	public String addCategory(@PathVariable("id") Long productID, @RequestParam("categoryID") Long categoryID) {
		
		Product product = productServ.findProduct(productID);
		Category category = categoryServ.findCategory(categoryID);
		
		// add category to product
		product.getCategories().add(category);
		productServ.updateProduct(product);
		
		return "redirect:/product/"+productID;
	}
	
	
// CATEGORY THINGS
	@GetMapping("/new/category")
	public String newCategory(@ModelAttribute("newCategory") Category newCategory) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/new/category")
	public String addNewCategory(@Valid @ModelAttribute("newCategory") Category newCategory, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "newCategory.jsp";
		} else {
			categoryServ.createCategory(newCategory);
			return "redirect:/";
		}
	}
	
	@GetMapping("/category/{id}")
	public String oneCategory(@PathVariable("id") Long categoryID, Model model) {
		
		Category category = categoryServ.findCategory(categoryID);
		model.addAttribute("category", category);
		
// decided not needed because this is the same as category.products
		// list of products in a category
//		List<Product> productsInCategory = productServ.getProductsInCategory(category);
//		model.addAttribute("productsInCategory", productsInCategory);
		
		// list of products not in a category
		List<Product> productsNotInCategory = productServ.getProductsNotInCategory(category);
		model.addAttribute("productsNotInCategory", productsNotInCategory);
		
		return "oneCategory.jsp";
	}
	
	@PostMapping("/category/{id}/add/product")
	public String addProduct(@PathVariable("id") Long categoryID, @RequestParam("productID") Long productID) {
		
		Category category = categoryServ.findCategory(categoryID);
		Product product = productServ.findProduct(productID);
		
		// add product to category
		category.getProducts().add(product);
		categoryServ.updateCategory(category);
		
		return "redirect:/category/"+categoryID;
	}

}
