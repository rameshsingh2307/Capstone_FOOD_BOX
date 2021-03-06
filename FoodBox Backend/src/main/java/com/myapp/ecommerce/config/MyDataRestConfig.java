package com.myapp.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.myapp.ecommerce.entity.Product;
import com.myapp.ecommerce.entity.ProductCategory;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager)
	{
		entityManager = theEntityManager;
	}
	
	
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		HttpMethod [] theUnSupportedAction = {HttpMethod.PUT,HttpMethod.POST,HttpMethod.DELETE};
		config.getExposureConfiguration()
			.forDomainType(Product.class)
			.withItemExposure((metadata,httpMethod)->httpMethod.disable(theUnSupportedAction))
			.withCollectionExposure((metadata,httpMethod)->httpMethod.disable(theUnSupportedAction));
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metadata,httpMethod)->httpMethod.disable(theUnSupportedAction))
		.withCollectionExposure((metadata,httpMethod)->httpMethod.disable(theUnSupportedAction));
		
		exposeIds(config);
	}
	
	public void exposeIds(RepositoryRestConfiguration config)
	{
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		List<Class> entityClasses = new ArrayList<>();
		
		for(EntityType entity:entities)
		{
			entityClasses.add(entity.getJavaType());
		}
		
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);
	}
	
	
}
