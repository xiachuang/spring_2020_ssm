package com.xia.service.impl;

import com.xia.bean.Customer;

import com.xia.repository.CustomerRepository;
import com.xia.service.IPayService;
import org.springframework.stereotype.Service;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.atomic.AtomicInteger;

@Service
//@Transactional(solation = Isolation.DEFAULT，propagation = Propagation.REQUIRED);开启事务
public class PayServiceImpl implements IPayService {
    @Resource
    private CustomerRepository customerRepository;

    @Override
//    @Transactional(readOnly = true,propagation = Propagation.REQUIRES_NEW)  方法上注解属性会覆盖类注解上的相同属性
    public Customer findCustomerByCustName(String custName) {
        Customer customer=customerRepository.findCustomerByCustName(custName);
        if(customer!=null){
            return customer;
        }else {
            Customer customer1=new Customer();
            customer1.setCustName(custName);
            customer1.setGold(new AtomicInteger(0));
            customer1.setPinSrc("src/main/resources/static/1.jpg");
            Customer customer2= customerRepository.save(customer1);
            System.out.println(customer2);
          return customer2;
        }
    }

    @Override
    @Transactional
    @Rollback(false)
    public int updateCustPhoneSrcById(String src, Integer custId) {
        if(src==null||src.isEmpty()){
            return -1;
        }else {
            return customerRepository.updateSrcById(src, custId);
        }
    }

    @Override
    @Transactional
    @Rollback(false)
    public int updateGoldById(Integer oldGold, Integer updateGold, Integer custId) {
                if(updateGold<0) {
                    return -1;
                }
                return  customerRepository.updateGoldById((updateGold+oldGold),custId);
    }

    @Override
    @Transactional
    @Rollback(false)
    public int payShop(Integer oldGold,Integer updateGold, Integer cust_id) {
        if(updateGold>oldGold){
            return -1;
        }else{
          return   customerRepository.payShop((oldGold-updateGold),cust_id);
        }
    }


}
