/**
 * 
 */
package edu.mum.eureka.dao;

import edu.mum.eureka.domain.Account;

/**
 * @author yared
 *
 */
public interface AccountDao extends GenericDao<Account> {

	  public Account findAccount(String userName );
}
