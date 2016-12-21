package edu.mum.eureka.dao;


import edu.mum.eureka.domain.Product;

import java.util.List;


public interface ProductDao extends GenericDao<Product> {
    List<Product> findProductByCriteria(String name, String description, double minPrice, double maxPrice);
}

