package com.xia.service;


import com.xia.bean.Customer;

public interface IPayService {
    public Customer findCustomerByCustName(String custName);
    public int updateCustPhoneSrcById(String src, Integer custId);
    public int updateGoldById(Integer oldGold, Integer updateGold, Integer custId);
    public int payShop(Integer oldGold, Integer updateGold, Integer cust_id);
}
