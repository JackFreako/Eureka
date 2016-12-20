package edu.mum.eureka.service;

import java.util.List;

import edu.mum.eureka.domain.UserCredentials;
 
public interface UserCredentialsService {

	public void save(UserCredentials userCredentials);
	public UserCredentials update(UserCredentials userCredentials);
	public List<UserCredentials> findAll();
	public UserCredentials findByUserName(String userName);
 }
