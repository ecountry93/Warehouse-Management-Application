package com.example.api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.api.Model.Product;
import com.example.api.Service.ProductService;


@Controller
public class ProductController {
	
	private ProductService productService;

	public ProductController(ProductService productService) {
	
		this.productService = productService;
	}
	
	// handler method to handle list students and return mode and view
	@GetMapping("/products")
	public String listStudents(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@GetMapping("/products/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Product product = new Product();
		model.addAttribute("product", product);
		return "create_Product";
		
	}
	
	@PostMapping("/products")
	public String saveProduct(@ModelAttribute("product") Product product) {
		productService.saveProduct(product);
		return "redirect:/products";
	}
	
	@GetMapping("/products/edit/{id}")
	public String editProductForm(@PathVariable Long id, Model model) {
		model.addAttribute("product", productService.getProductById(id));
		return "Edit_Products";
	}
     
	@PostMapping("/products/{id}")
	public String updateProduct(@PathVariable Long id, @ModelAttribute("product") Product product,
			Model model) {
		
		// get student from database by id
		Product existingProduct = productService.getProductById(id);
		
		
		existingProduct.setNumarFactura(product.getNumarFactura());
		existingProduct.setData(product.getData());
		existingProduct.setName(product.getName());
		existingProduct.setCantitate(product.getCantitate());
		
		// save updated student object
		  productService.updateProduct(existingProduct);
		return "redirect:/products";		
	}
	
	// handler method to handle delete student request
	
	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
	
}