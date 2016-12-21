/**
 * 
 */
package edu.mum.eureka.service;
import edu.mum.eureka.domain.Order;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.util.List;

public interface OrderService  {
    void save(Order order);

    List<Order> getAll();

    Order getOrderById(long id);

    public void publish(RabbitTemplate rabbitTemplate, Order order);
}
