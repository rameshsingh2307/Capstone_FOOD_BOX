package com.myapp.ecommerce.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.ecommerce.entity.Product;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("/get")
	public List<Product> getProducts() {
		return productRepository.findAll();
	}
}
