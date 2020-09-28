package com.xia.controller;

import com.xia.result.MessageResult;
import com.xia.service.ICustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PhoneController {
    @Resource
    private ICustomerService iCustomerService;
    @GetMapping("spring/pay/bind")
    public MessageResult<String> bindPhone(@RequestParam("custPhone")String custPhone,@RequestParam("id") Integer id){
        int result= iCustomerService.bindPhone(custPhone,id);
       if(result>0){
           return new MessageResult<>(200,"绑定成功！！",custPhone);
       }else if(result==-2) {
           return new MessageResult<>(402,"号码已被绑定！！");
       }else {
           return new MessageResult<>(402,"绑定失败");
       }
    }
}
