package com.axsos.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;
import java.util.Optional;
import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;
import com.axsos.productsandcategories.repositories.CategoryRepository;
import com.axsos.productsandcategories.repositories.ProductRepository;


@Service
public class ProductService {
	private final CategoryRepository categoryRepository;
	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {

		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}

	public List<Product> allProducts() {
		return productRepository.findAll();
	}
	
	
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	
	
	public Product getProduct(Long id) {
		Optional<Product> newproduct = productRepository.findById(id);
		
		if(newproduct.isPresent()) {
			return newproduct.get();
		}else {
			return null;
		}
	}
	
	public List<Category> findContainsCategory(Product product){
		List<Category> allCategory=	categoryRepository.findAllByProducts(product);
		return allCategory;
		}
	
	public List<Category> findNotContainsCategory(Product product){
		List<Category> allCategory=categoryRepository.findByProductsNotContains(product);
		return allCategory;
	}

	
}
