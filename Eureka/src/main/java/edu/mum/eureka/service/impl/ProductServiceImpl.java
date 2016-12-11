package edu.mum.eureka.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eureka.dao.ProductDao;
import edu.mum.eureka.service.ProductService;


@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	
	@Autowired
	private ProductDao productDao;
}
