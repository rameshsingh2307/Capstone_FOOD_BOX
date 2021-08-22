package com.myapp.ecommerce.Dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.entity.Product1;
import com.myapp.ecommerce.entity.ProductCategory;

@CrossOrigin("http://localhost:4200")
public interface ProductRepository1 extends JpaRepository<Product1,Long> {
	
}
