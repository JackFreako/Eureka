package edu.mum.eureka.serviceimpl;

import java.util.List;

import edu.mum.eureka.dao.UserCredentialsDao;
import edu.mum.eureka.service.UserCredentialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eureka.domain.UserCredentials;

@Service
@Transactional 
public class UserCredentialsServiceImpl implements UserCredentialsService {
	
 	@Autowired
	private UserCredentialsDao userCredentialsDao;

 	
     public void save( UserCredentials userCredentials) {  		
  		userCredentialsDao.save(userCredentials);
 	}
  	
  	
	public List<UserCredentials> findAll() {
		return (List<UserCredentials>)userCredentialsDao.findAll();
	}

	public UserCredentials findByUserName(String userName) {
		return userCredentialsDao.findByUserName(userName);
	}


	@Override
	public UserCredentials update(UserCredentials userCredentials) {
		return userCredentialsDao.update(userCredentials);
	
	}

}
