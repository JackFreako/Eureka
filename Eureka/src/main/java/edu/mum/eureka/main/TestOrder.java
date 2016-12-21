/**
 *
 */
package edu.mum.eureka.main;

import edu.mum.eureka.domain.CustomerInfo;
import edu.mum.eureka.domain.Order;
import edu.mum.eureka.domain.OrderDetail;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author yared
 */
@Component
public class TestOrder {

    public void testOrder() {


    }

    public static Order getOrder() {
        CustomerInfo customerInfo = new CustomerInfo();
        customerInfo.setFirstName("Rahul");
        customerInfo.setLastName("Joshi");
        customerInfo.setAddress("1000 N , 4th str");
        customerInfo.setEmail("test@mail.com");
        customerInfo.setPhone("5456545678");

        Order order = new Order();
        order.setOrderNum(10);
        order.setAmount(20D);
        order.setOrderDate(new Date());
        order.setCustomerInfo(customerInfo);

        order.setOrderDetails(getOrderDetails());

        return order;
    }

    public static List<OrderDetail> getOrderDetails() {
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Random random = new Random();
            double price = random.nextDouble();
            int qty = random.nextInt();
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setPrice(price);
            orderDetail.setQuanity(qty);
            orderDetail.setAmount(orderDetail.getQuanity() * orderDetail.getPrice());
            orderDetails.add(orderDetail);
        }
        return orderDetails;
    }
}
