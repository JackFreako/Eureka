package edu.mum.eureka.serviceimpl;

import java.util.List;

import edu.mum.eureka.dao.UserDao;
import edu.mum.eureka.domain.User;
import edu.mum.eureka.service.UserCredentialsService;
import edu.mum.eureka.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional 
public class UserServiceImpl implements UserService {
	
 	@Autowired
	private UserDao userDao;

 	@Autowired
	private UserCredentialsService credentialsService;

 	
     public void save( User user) {
  		userDao.save(user);
 	}
  	
     @Override
    	public void saveFull( User user) {  		
   		credentialsService.save(user.getUserCredentials());
   		userDao.save(user);
 	}
   	
	
	public List<User> findAll() {
		return (List<User>)userDao.findAll();
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}
	
	public User update(User user) {
		 return userDao.update(user);

	}

	@Override
	public User findOne(Long id) {
		 
		return userDao.findOne(id);
	}
 

}
