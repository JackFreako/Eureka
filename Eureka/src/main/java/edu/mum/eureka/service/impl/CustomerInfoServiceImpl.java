package edu.mum.eureka.service.impl;

import edu.mum.eureka.dao.CustomerInfoDao;
import edu.mum.eureka.domain.CustomerInfo;
import edu.mum.eureka.service.CustomerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by rahul on 12/20/16.
 */
@Service
@Transactional
public class CustomerInfoServiceImpl implements CustomerInfoService {

    @Autowired
    private CustomerInfoDao customerInfoDao;

    @Override
    public void save(CustomerInfo customerInfo) {
        customerInfoDao.save(customerInfo);
    }
}
