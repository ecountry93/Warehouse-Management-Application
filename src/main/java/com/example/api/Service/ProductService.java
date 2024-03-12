package com.example.api.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.api.Model.Product;
import com.example.api.Repository.ProductRepository;


@Service
public class ProductService{

	private ProductRepository repo;
	
	public ProductService(ProductRepository repo) {
		
		this.repo = repo;
	}

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product saveProduct(Product product) {
		return repo.save(product);
	}

	
	public Product getProductById(Long id) {
		return repo.findById(id).get();
	}

	public Product updateProduct(Product product) {
		return repo.save(product);
	}

	
	public void deleteProductById(Long id) {
		repo.deleteById(id);	
	}

	

}
