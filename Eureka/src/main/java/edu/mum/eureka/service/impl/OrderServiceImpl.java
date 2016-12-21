/**
 *
 */
package edu.mum.eureka.service.impl;

import edu.mum.eureka.dao.OrderDao;
import edu.mum.eureka.domain.Order;
import edu.mum.eureka.service.CustomerInfoService;
import edu.mum.eureka.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author yared
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;

    @Autowired
    private CustomerInfoService customerInfoService;

    @Override
    public void save(Order order) {
//        customerInfoService.save(order.getCustomerInfo());
        orderDao.save(order);
    }

    @Override
    public List<Order> getAll() {
        return orderDao.findAll();
    }

    @Override
    public Order getOrderById(long id) {
        return orderDao.findOne(id);
    }
}
