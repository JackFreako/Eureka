package edu.mum.eureka.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.eureka.dao.ProductDao;
import edu.mum.eureka.domain.Order;
import edu.mum.eureka.domain.Product;
import edu.mum.eureka.model.PaginationResult;
import edu.mum.eureka.model.ProductInfo;



@SuppressWarnings("unchecked")
@Repository
public class ProductDaoImpl  extends GenericDaoImpl<Product> implements ProductDao {

	
	public ProductDaoImpl() {
		super.setDaoType(Product.class );
	}
	

	@Override
	public Product findProduct(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductInfo findProductInfo(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaginationResult<ProductInfo> queryProducts(int page, int maxResult, int maxNavigationPage,
			String likeName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ProductInfo productInfo) {
		// TODO Auto-generated method stub

	}

}
