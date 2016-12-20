package edu.mum.eureka.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.eureka.dao.UserCredentialsDao;
import edu.mum.eureka.domain.UserCredentials;

 


@SuppressWarnings("unchecked")
@Repository
public class UserCredentialsDaoImpl extends GenericDaoImpl<UserCredentials> implements UserCredentialsDao {

	public UserCredentialsDaoImpl() {
		super.setDaoType(UserCredentials.class );
		}

	public UserCredentials findByUserName(String userName) {

		Query query = entityManager.createQuery("select m from Authentication m  where m.userName =:userName");
		return (UserCredentials) query.setParameter("userName", userName).getSingleResult();

	}

 
 }