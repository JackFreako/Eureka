/**
 * 
 */
package edu.mum.eureka.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.eureka.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author yared
 *
 */
@Service
@Transactional 
public class OrderServiceImpl {

	
	@Autowired
	private OrderDao orderDao;
}
