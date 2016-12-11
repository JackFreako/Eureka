/**
 * 
 */
package edu.mum.eureka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eureka.dao.AccountDao;
import edu.mum.eureka.domain.Account;
import edu.mum.eureka.service.AccountService;

/**
 * @author yared
 *
 */

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AccountDao accountDao;

	@Override
	public void save(Account account) {
	    this.accountDao.save(account);		
	}

	@Override
	public Account findOne(Long id) {		
		return this.accountDao.findOne(id);
	}

	@Override
	public List<Account> findAll() {		
		return (List<Account>) this.accountDao.findAll();
	}

	@Override
	public Account findByEmail(String email) {		
		return null;
	}

	@Override
	public Account findByUserName(String userName) {		
		return this.accountDao.findAccount(userName);
	}

	@Override
	public Account update(Account account) {		
		return this.accountDao.update(account);
	}

	@Override
	public Account testRefresh(Account user) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
