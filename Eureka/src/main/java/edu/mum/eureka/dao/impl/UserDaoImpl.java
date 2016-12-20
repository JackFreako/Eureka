package edu.mum.eureka.dao.impl;

 

import javax.persistence.Query;

import edu.mum.eureka.domain.User;
import org.springframework.stereotype.Repository;

import edu.mum.eureka.dao.UserDao;


@SuppressWarnings("unchecked")
@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class );
		}

	public User findByEmail(String email) {
	     
		Query query = entityManager.createQuery("select u from User u  where u.email =:email");
		return (User) query.setParameter("email", email).getSingleResult();
			     

	}


 }