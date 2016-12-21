package edu.mum.eureka.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.eureka.domain.Product;

public interface ProductService {

	List<Product> getAllProducts();

  	void save(Product product);
	void remove(long id);

	Product findOne(long id);
 
 

}
