package com.axsos.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;
import com.axsos.productsandcategories.repositories.CategoryRepository;
import com.axsos.productsandcategories.repositories.ProductRepository;
@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	
	public CategoryService(CategoryRepository categoryRepository, ProductRepository productRepository) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
	}
	
	public List<Category> allCategories() {
		return categoryRepository.findAll();
	}
	public void addProduct(Product product,Long id) {
		Category category=findCategory(id);
		category.getProducts().add(product);
		categoryRepository.save(category);
	}

	
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}
	public Category findCategory(Long id) {
		Optional<Category> category =  categoryRepository.findById(id);
		if (category.isPresent()) {
			return category.get();
		}else {
			return null;
		}
		}
	public List<Product> findProductContains(Category category){
		List<Product> productContains=productRepository.findAllBycategories(category);
		return productContains;
		}
	
	public List<Product> findNotContainsCat(Category category){
		List<Product> allProduct=productRepository.findByCategoriesNotContains(category);
		return allProduct;

	}
}
