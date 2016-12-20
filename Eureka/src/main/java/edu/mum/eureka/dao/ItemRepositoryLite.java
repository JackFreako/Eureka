package edu.mum.eureka.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import edu.mum.eureka.domain.Item;

 

public interface ItemRepositoryLite {

	List <Item> getAllItems();
	
	Item getItemById(String key);
	
	List<Item> getItemsByCategory(String category);

	Set<Item> getItemsByFilter(Map<String, List<String>> filterParams);
	
	void addItem(Item product);		
}
