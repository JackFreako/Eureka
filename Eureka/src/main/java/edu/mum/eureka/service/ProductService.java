package edu.mum.eureka.service;

import edu.mum.eureka.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    void save(Product product);

    void remove(long id);

    Product findOne(long id);

    List<Product> findProductByCriteria(String name, String description, double minPrice, double maxPrice);
}
