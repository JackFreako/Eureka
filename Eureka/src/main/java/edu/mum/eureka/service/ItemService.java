package edu.mum.eureka.service;

import java.util.List;

import edu.mum.eureka.domain.Item;
import edu.mum.eureka.domain.User;

public interface ItemService {

	public void save(Item Item);
	public Item update(Item Item);
	public List<Item> findAll();
	 
	public List<Item> findBySellerOrBuyer(Integer price, User buyer, User seller);
	public List<Item> findByCategoryName(String categoryName);	 
	public List<Item> findItemCriteria(Integer initialPrice, User buyer, User seller);
	public Item findOne(Long id);

}
