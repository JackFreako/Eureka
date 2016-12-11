/**
 * 
 */
package edu.mum.eureka.dao.impl;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.eureka.dao.AccountDao;
import edu.mum.eureka.domain.Account;

/**
 * @author yared
 *
 */

@SuppressWarnings("unchecked")
@Repository
public class AccountDaoImpl  extends GenericDaoImpl<Account> implements AccountDao {

	
	public AccountDaoImpl() {
		super.setDaoType(Account.class );
	}
	
	
	
	@Override
	public Account findAccount(String userName) {
		Query query = entityManager.createQuery("select a from Account a  where a.userName =:userName");
		return (Account) query.setParameter("userName", userName).getSingleResult();
		
	}

}
