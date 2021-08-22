package com.myapp.ecommerce.Dao;

import com.myapp.ecommerce.entity.ProductCategory;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource(collectionResourceRel = "productCategory", path="product_Category")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
	
	
}
