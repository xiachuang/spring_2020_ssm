package com.xia.service.impl;

import com.xia.bean.Customer;
import com.xia.repository.CustomerRepository;
import com.xia.service.ICustomerService;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
public class CustomerServerImpl  implements ICustomerService {
    @Resource
    private CustomerRepository customerRepository;
    @Override
    @Rollback(false)
    public int bindPhone(String custPhone, Integer custId) {
        Customer customer = customerRepository.findById(custId).get();
        if(custPhone.equals(customer.getCustPhone())){
           return -2;
        }else {
         return customerRepository.bindPhone(custPhone,custId);

        }
    }
}
