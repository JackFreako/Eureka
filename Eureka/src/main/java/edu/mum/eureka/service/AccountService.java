package edu.mum.eureka.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.mum.eureka.domain.Account;


public interface AccountService{

	public void  save(Account account);
	public Account findOne(Long id);	
	public List<Account> findAll();
	public Account findByEmail(String email);
	public Account findByUserName(String userName);
	public Account update(Account account);
	public Account testRefresh(Account account);

}
