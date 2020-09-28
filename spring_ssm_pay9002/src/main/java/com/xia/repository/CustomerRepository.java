package com.xia.repository;

import com.xia.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {
    public Customer findCustomerByCustName(String custName);
    @Query(value = "update customer set cust_pinSrc =?1 where cust_id=?2",nativeQuery = true)
    @Modifying
    public int updateSrcById(String src, Integer custId);
    @Query(value = "update customer set gold=?1 where cust_id=?2",nativeQuery = true)
    public int updateGoldById(Integer updateGold, Integer custId);
    @Query(value = "update customer set glod=?1 where cust_id=?2",nativeQuery = true)
    public int payShop(Integer updateGold, Integer cust_id);

    @Query(value = "updat cusomer set cust_phone=?1 where cust_id=?2",nativeQuery = true)
    public int bindPhone(String custPhone, Integer custId);
}
