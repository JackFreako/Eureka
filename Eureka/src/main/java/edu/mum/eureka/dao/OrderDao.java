/**
 * 
 */
package edu.mum.eureka.dao;

import java.util.List;

import edu.mum.eureka.domain.Order;
import edu.mum.eureka.model.CartInfo;
import edu.mum.eureka.model.OrderDetailInfo;
import edu.mum.eureka.model.OrderInfo;
import edu.mum.eureka.model.PaginationResult;

/**
 * @author yared
 *
 */
public interface OrderDao extends GenericDao<Order> {

	    public PaginationResult<OrderInfo> listOrderInfo(int page,
	            int maxResult, int maxNavigationPage);
	    
	    public OrderInfo getOrderInfo(String orderId);
	    
	    public List<OrderDetailInfo> listOrderDetailInfos(String orderId);
}
