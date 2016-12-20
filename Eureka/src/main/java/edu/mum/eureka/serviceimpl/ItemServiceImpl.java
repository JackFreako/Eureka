package edu.mum.eureka.serviceimpl;

import java.util.List;

import edu.mum.eureka.dao.ItemDao;
import edu.mum.eureka.domain.Item;
import edu.mum.eureka.domain.User;
import edu.mum.eureka.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional 
public class ItemServiceImpl implements ItemService {
	
	
 	@Autowired
	private ItemDao itemDao;

    public void save( Item Item) {
		itemDao.save(Item);
	}
	
	
    public Item update( Item Item) {  		
		return itemDao.update(Item);
	}
	
	
	public List<Item> findAll() {
		return (List<Item>)itemDao.findAll();
	}

 	public Item findOne(Long id) {
		return itemDao.findOne(id);
	}


	@Override
	public List<Item> findBySellerOrBuyer(Integer price, User buyer, User seller) {
		 
		return itemDao.findBySellerOrBuyer(price, buyer, seller);
	}

	public List<Item> findByCategoryName(String categoryName) {
		return itemDao.findByCategoryName(categoryName);
	}
	
	public List<Item> findItemCriteria(Integer initialPrice, User buyer, User seller) {
		return itemDao.findItemCriteria(initialPrice,buyer,seller);
	}
}
