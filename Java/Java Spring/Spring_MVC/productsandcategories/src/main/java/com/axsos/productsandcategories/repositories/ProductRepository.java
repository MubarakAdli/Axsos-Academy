package com.axsos.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.axsos.productsandcategories.models.Category;
import com.axsos.productsandcategories.models.Product;
@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
	
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
	List<Product> findAllBycategories(Category category);

}
