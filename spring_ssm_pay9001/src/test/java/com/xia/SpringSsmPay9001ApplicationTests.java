package com.xia;

import com.xia.bean.Customer;
import com.xia.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringSsmPay9001ApplicationTests {
    @Autowired
    private CustomerRepository customerRepository;
    @Test
    void contextLoads() {
        Customer customer=new Customer();
        customer.setCustName("xiachuang");
        customer.setGold(10000);
        customer.setCustPhone("18270873356");
        customer.setCustPhone("src/main/resources/static/2.jpg");
        customerRepository.save(customer);
    }

}
