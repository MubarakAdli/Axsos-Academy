package com.axsos.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;
import com.axsos.productsandcategories.services.CategoryService;
import com.axsos.productsandcategories.services.ProductService;
@Controller
public class MainController {
	private final CategoryService categoryService;
	private final ProductService productService;

	public MainController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	@GetMapping("/products/new")

	public String index(@ModelAttribute("product") Product product) {
		 
		return "newproduct.jsp";
	}
	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "/products/new";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}
		@GetMapping("/categories/new")

		public String index1(@ModelAttribute("category") Category category) {
			 
			return "newcat.jsp";
		}
		
		@GetMapping("/products/{id}")

		public String showProducts(@ModelAttribute("category") Category category) {
			 
			return "products.jsp";
		}
		@PostMapping("/categories/new")
		public String create(@Valid @ModelAttribute("category") Category category, BindingResult result) {
			if (result.hasErrors()) {
				return "/categories/new";
			} else {
				categoryService.createCategory(category);
				return "redirect:/categories/new";
			}
	}
		
		@GetMapping("/categories/{id}")
		public String productItems(@PathVariable("id")Long id,Model model) {
			Category category = categoryService.findCategory(id);
			List<Product> productContains=categoryService.findProductContains(category);
			List<Product> productNotContains=categoryService.findNotContainsCat(category);
			model.addAttribute("category", category);
			model.addAttribute("productContains", productContains);
			model.addAttribute("productNotContains", productNotContains);
			return "category.jsp";
		}
		@RequestMapping("/new/product/{id}")
		public String addCategory(@RequestParam(value = "products")Product product,@PathVariable("id")Long id) {
			 categoryService.addProduct(product, id);
			 return "redirect:/categories/"+ id;
		}
		
		@RequestMapping("/products/{id}")
		public String categoryItems(@PathVariable("id")Long id,Model model) {
			Product product = productService.findProduct(id);
			List<Category> categoryContains=productService.findContainsCategory(product);
			List<Category> categoryNotContains=productService.findNotContainsCategory(product);
			model.addAttribute("product", product);
			model.addAttribute("categoryNotContains", categoryNotContains);
			model.addAttribute("categoryContains", categoryContains);
			return "product.jsp";
		}
		@RequestMapping("/new/category/{id}")
		public String addCategory(@RequestParam(value = "categories")Category category,@PathVariable("id")Long id) {
			 productService.addCategory(category, id);
			 return "redirect:/products/"+ id;
		}
}
