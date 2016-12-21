package edu.mum.eureka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.mum.eureka.domain.Product;
import edu.mum.eureka.rest.service.ProductRestService;
import edu.mum.eureka.service.ProductService;

@Service
public class ProductServiceImplREST implements ProductService {

	@Autowired
 	//@Qualifier("MVC")
 	@Qualifier("Jersey")
	private ProductRestService productRestService;

	public List<Product> findAll() {
		return productRestService.findAll();
	}

 
 	public void addProduct(Product product) {
 		productRestService.save(product);
	}
	
	public Product findOne(long productID) {
		return productRestService.findOne(productID);
	}


	@Override
	public List<Product> getAllProducts() {
		return productRestService.findAll();
	}


	@Override
	public void save(Product product) {
		productRestService.save(product);
		
	}


	@Override
	public void remove(long id) {
		// TODO Auto-generated method stub
		
	}

}
