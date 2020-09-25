package com.xia.bean;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class Payment implements Serializable {
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String serail;


}
