/**
 * 
 */
package edu.mum.eureka.main;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.mum.eureka.domain.Order;
import edu.mum.eureka.domain.OrderDetail;
import edu.mum.eureka.domain.Product;
import edu.mum.eureka.email.EmailService;


/**
 * @author yared
 *
 */

@Component
public class Main {

	
	@Autowired
	TestAccount testAccount;
	
	@Autowired
	TestOrder testOrder;
	
	@Autowired
	TestProduct testProduct;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws MessagingException  {
		
		  ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			        "context/applicationContext.xml");
			    applicationContext.getBean(Main.class).mainInternal(applicationContext);
			    
			    
			    
			 //Test for Email
			    
			    
			    Product product = new Product("Samsung Galaxy S", "The Greatest", 179);
			    
			    //OrderPayment orderPayment = new OrderPayment();
			    OrderDetail orderDetail = new OrderDetail(2, product);
			    List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
			    orderDetails.add(orderDetail);
			    //public Order (Date orderDate, double amount,CustomerInfo customerInfo,List<OrderDetail> orderDetails) 
			    Order order = new Order(Date.from(Instant.now()),orderDetails);
			    
			    EmailService emailService = (EmailService) applicationContext.getBean("emailService");
			    emailService.sendOrderReceivedMail("your_name_here", "foo@gmail.com",order,new Locale("en"));
	}
	
	
	  private void mainInternal(ApplicationContext applicationContext) {
		  
//		    this.testAccount.testAccount();
		    this.testOrder.testOrder();
		    //this.testProduct.testProduct();
		    
		 }

}
