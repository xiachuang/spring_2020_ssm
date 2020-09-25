package com.xia.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor//有参构造
@NoArgsConstructor //无参构造
public class MessageResult<T> {
    private Integer code;
    private String message;
    private T data;
    public MessageResult(Integer code,String message){
        this(code,message,null);
    }


}
