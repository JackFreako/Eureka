/**
 * 
 */
package edu.mum.eureka.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;


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
	public static void main(String[] args) {
		
		  ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			        "context/applicationContext.xml");
			    applicationContext.getBean(Main.class).mainInternal(applicationContext);
	}
	
	
	  private void mainInternal(ApplicationContext applicationContext) {
		  
//		    this.testAccount.testAccount();
		    this.testOrder.testOrder();
		    //this.testProduct.testProduct();
		    
		 }

}
