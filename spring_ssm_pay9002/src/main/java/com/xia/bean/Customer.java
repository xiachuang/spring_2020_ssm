package com.xia.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id")
    private Integer id;
    @Column(name = "cust_name")
    private String custName;
    @Column(name = "cust_Phone")
    private String custPhone;
    @Column(name = "gold")
    private volatile int gold;
    @Column(name = "cust_pinSrc")
    private volatile String pinSrc;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        if(gold<0){
            gold=0;
            this.gold=gold;
        }
        this.gold = gold;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getPinSrc() {
        return pinSrc;
    }

    public void setPinSrc(String pinSrc) {
        this.pinSrc = pinSrc;
    }


}
