package edu.mum.eureka.service;

import java.util.List;

import edu.mum.eureka.domain.User;

public interface UserService {

	public void save(User user);
	public List<User> findAll();
	public User findOne(Long id);
	public User findByEmail(String email);
	public User update(User user);
	public void saveFull(User user);

}
