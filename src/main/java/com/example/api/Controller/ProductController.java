package com.example.api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;



import com.example.api.Model.Product;
import com.example.api.Service.ProductService;

import jakarta.validation.Valid;


@Controller
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
	
		this.productService = productService;
	}
	
	// handler method to handle list products and return mode and view
	@GetMapping("/products")
	public String listProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@GetMapping("/products/new")
	public String createProductForm(Model model) {
		
		// create product object to hold product form data
		Product product = new Product();
		model.addAttribute("product", product);
		return "CreateProduct";
		
	}
	
	@PostMapping("/products/create")
	public String saveProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		
		if(result.hasErrors()) {
			return "CreateProduct";
		}
		else {
		productService.saveProduct(product);
		return "redirect:/products";
		}
	}
	
	@GetMapping("/products/edit/{id}")
	public String editProductForm(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "EditProduct";
	}
     
	@PostMapping("/products/update/{id}")
	public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Product product,
			Model model) {
		
		// get product from database by id
		Product existingProduct = productService.getProductById(id);
		
		
		existingProduct.setBillNumber(product.getBillNumber());
		existingProduct.setDate(product.getDate());
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		
		// save updated product object
		  productService.updateProduct(existingProduct);
		return "redirect:/products";		
		
	}
	
	// handler method to handle delete product request
	
	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
	
}