package edu.mum.eureka.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eureka.domain.Product;
import edu.mum.eureka.dao.ProductDao;
import edu.mum.eureka.service.ProductService;

@Service
@Transactional 
public class ProductServiceImpl implements ProductService{
	
 	@Autowired
	private ProductDao productDao;

	public List<Product> getAllProducts() {
		return productDao.findAll();
	}

 
 	public void save(Product product) {
		   productDao.save(product);
	}

	public void remove(long productID) { productDao.delete(productID);}
	
	public Product findOne(long productID) {
		return productDao.findOne(productID);
	}

 
 


}
