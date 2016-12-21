/**
 * 
 */
package edu.mum.eureka.amqp;

import edu.mum.eureka.domain.Order;
import edu.mum.eureka.domain.OrderDetail;

import java.util.List;

public class OrderListener {

	public void listen(Order order) {
		List<OrderDetail> orderDetails = order.getOrderDetails();
		System.out.println("--------- Rabbit Listen() receives Order --------");
		System.out.println("OrderId: " + String.valueOf(order.getId()));
		System.out.println("Customer Name: " + order.getCustomerInfo().getFirstName() + " "
							+ order.getCustomerInfo().getLastName());
		System.out.println("Customer's Email: " + order.getCustomerInfo().getEmail());
		System.out.println("====> Order Detail:");
		for (OrderDetail detail : orderDetails ) {
			System.out.println("Product Name:" + detail.getProduct().getName());
			System.out.println("Product Price:" + String.valueOf(detail.getProduct().getPrice()));
		}
	}
}
