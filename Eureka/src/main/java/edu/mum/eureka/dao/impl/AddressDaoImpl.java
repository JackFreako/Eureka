package edu.mum.eureka.dao.impl;

 

import edu.mum.eureka.domain.Address;
import org.springframework.stereotype.Repository;

import edu.mum.eureka.dao.AddressDao;


@SuppressWarnings("unchecked")
@Repository
public class AddressDaoImpl extends GenericDaoImpl<Address> implements AddressDao {

	public AddressDaoImpl() {
		super.setDaoType(Address.class );
		}

 
 }