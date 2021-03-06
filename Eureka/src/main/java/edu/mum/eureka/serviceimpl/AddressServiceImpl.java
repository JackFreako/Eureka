package edu.mum.eureka.serviceimpl;

import java.util.List;

import edu.mum.eureka.domain.Address;
import edu.mum.eureka.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.eureka.dao.AddressDao;

@Service
@Transactional 
public class AddressServiceImpl implements AddressService {
	
	
 	@Autowired
	private AddressDao addressDao;

    public void save( Address address) {
		addressDao.save(address);
	}
	
	
    public void update( Address address) {  		
		addressDao.update(address);
	}
	
	
	public List<Address> findAll() {
		return (List<Address>)addressDao.findAll();
	}

 	public Address findOne(Long id) {
		return addressDao.findOne(id);
	}


	
 
}
