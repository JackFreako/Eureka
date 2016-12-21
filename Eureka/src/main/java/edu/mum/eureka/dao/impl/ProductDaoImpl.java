package edu.mum.eureka.dao.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.eureka.domain.User;
import edu.mum.eureka.domain.Product;

import edu.mum.eureka.dao.ProductDao;

	@Repository
	public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao
	{
		
		public ProductDaoImpl() {
			super.setDaoType(Product.class );
			}


  
	}

