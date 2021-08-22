package com.myapp.ecommerce.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.ecommerce.Dao.ProductRepository;
import com.myapp.ecommerce.Dao.ProductRepository1;
import com.myapp.ecommerce.Dao.UserRepository;
import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.entity.Product1;
import com.myapp.ecommerce.entity.User;


@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:4200")
public class AdminController {
	
	
	
	@Autowired
	ProductRepository1 proRepo;
	
	
	@GetMapping("/listProduct")
	public List<Product1> getProductList()
	{
		List<Product1> list = proRepo.findAll();		  
		System.out.println(list);
		return list;
	}
	
	@DeleteMapping("/delete/{id}")
	public List<Product1> deleteUser(@PathVariable Long id)
	{
		proRepo.deleteById(id);
		return proRepo.findAll();
	}
	
	@PostMapping("/addProduct")
	public String addProduct(@RequestBody Product1 product)
	{
		proRepo.save(product);
		return "Product added successfully..";
	}
		
	
	@GetMapping("/findById/{id}")
    public ResponseEntity<Product1> getEmplfindByIdoyeeById(@PathVariable(value = "id") Long id)
        throws ResourceNotFoundException {
        Product1 product = proRepo.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        return ResponseEntity.ok().body(product);
    }
	
	
	@PutMapping("/update/{id}")
    public ResponseEntity<Product1> updateProduct(@PathVariable(value = "id") Long id,
         @RequestBody Product1 product) throws ResourceNotFoundException {
		Product1 product1 = proRepo.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));

		product1.setSku(product.getSku());
		product1.setName(product.getName());
		product1.setDescription(product.getDescription());
		product1.setUnitPrice(product.getUnitPrice());
		product1.setImageUrl(product.getImageUrl());
		product1.setUnitsInStock(product.getUnitsInStock());
		
        final Product1 updatedProduct = proRepo.save(product1);
        return ResponseEntity.ok(updatedProduct);
    }
}
