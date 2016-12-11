/**
 * 
 */
package edu.mum.eureka.dao;

import edu.mum.eureka.domain.Product;
import edu.mum.eureka.model.PaginationResult;
import edu.mum.eureka.model.ProductInfo;

/**
 * @author yared
 *
 */
public interface ProductDao extends GenericDao<Product> {

	
public Product findProduct(String code);
    
    public ProductInfo findProductInfo(String code) ;
  
    
    public PaginationResult<ProductInfo> queryProducts(int page,
                       int maxResult, int maxNavigationPage  );
    
    public PaginationResult<ProductInfo> queryProducts(int page, int maxResult,
                       int maxNavigationPage, String likeName);
 
    public void save(ProductInfo productInfo);
}
