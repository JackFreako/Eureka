package edu.mum.eureka.dao;

import edu.mum.eureka.domain.User;

public interface UserDao extends GenericDao<User> {
      
	public User findByEmail(String email);
}
