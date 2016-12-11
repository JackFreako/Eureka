/**
 * 
 */
package edu.mum.eureka.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.eureka.domain.Account;
import edu.mum.eureka.service.AccountService;

/**
 * @author yared
 *
 */

@Component
public class TestAccount {

	
	@Autowired
   AccountService accountService;
	
	public void testAccount()
	{	
		Account  account = new Account();
		account.setActive(true);
		account.setUserName("yaredoom");
		account.setPassword("yaredoom");
		account.setUserRole("MANAGER");		
		accountService.save(account);		   
		System.out.println("Account inserted!");
		
		
		System.out.println("Retrieve Account by UserName : " + account.getUserName());
		
		account = accountService.findByUserName(account.getUserName());
		System.out.println("Account Username : " + account.getUserName());
		System.out.println("Account Passowrd  : " + account.getPassword());
		System.out.println("Account Role : " +account.getUserRole());
		
	}
	
	
}
