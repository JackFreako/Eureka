/**
 * 
 */
package edu.mum.eureka.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.eureka.dao.OrderDao;
import edu.mum.eureka.domain.Account;
import edu.mum.eureka.domain.Order;
import edu.mum.eureka.model.CartInfo;
import edu.mum.eureka.model.OrderDetailInfo;
import edu.mum.eureka.model.OrderInfo;
import edu.mum.eureka.model.PaginationResult;

/**
 * @author yared
 *
 */


@SuppressWarnings("unchecked")
@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {
	
	
	public OrderDaoImpl() {
		super.setDaoType(Order.class );
	}
	
	

	/* (non-Javadoc)
	 * @see edu.mum.eureka.dao.OrderDao#saveOrder(edu.mum.eureka.entity.CartInfo)
	 */
	@Override
	public void saveOrder(CartInfo cartInfo) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see edu.mum.eureka.dao.OrderDao#listOrderInfo(int, int, int)
	 */
	@Override
	public PaginationResult<OrderInfo> listOrderInfo(int page, int maxResult, int maxNavigationPage) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.mum.eureka.dao.OrderDao#getOrderInfo(java.lang.String)
	 */
	@Override
	public OrderInfo getOrderInfo(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.mum.eureka.dao.OrderDao#listOrderDetailInfos(java.lang.String)
	 */
	@Override
	public List<OrderDetailInfo> listOrderDetailInfos(String orderId) {
		// TODO Auto-generated method stub
		return null;
	}

}
