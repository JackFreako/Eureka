/**
 * 
 */
package edu.mum.eureka.service;
import edu.mum.eureka.domain.Order;

import java.util.List;

public interface OrderService  {
    void save(Order order);

    List<Order> getAll();

    Order getOrderById(long id);
}
