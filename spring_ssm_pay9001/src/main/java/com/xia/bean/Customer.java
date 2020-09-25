package com.xia.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

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
    private volatile AtomicInteger gold=new AtomicInteger(0);
    @Column(name = "cust_pinSrc")
    private volatile String pinSrc;
//    @OneToOne(mappedBy = "customer",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)


    public AtomicInteger getGold() {
        return gold;
    }

    public void setGold(AtomicInteger gold) {
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
