package com.xia.controller;

import com.xia.bean.Customer;
import com.xia.result.MessageResult;
import com.xia.service.IPayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PayController {
    @Resource
    private IPayService iPayService;
    @GetMapping("/spring/pay/message")
    public Customer findCustomerByName(@RequestParam("userName")String userName){
        return iPayService.findCustomerByCustName(userName);
    }
    @GetMapping("/spring/pay/addGold")
    public MessageResult<Integer> updateGold(@RequestParam("gold")Integer oldGold,@RequestParam("addGold")Integer updateGold,@RequestParam("id")Integer id){
        int result=iPayService.updateGoldById(oldGold,updateGold, id);
        if(result>0){
            return new MessageResult<>(200,"充值成功！！！",updateGold);
        }else{
            return new MessageResult<>(402,"充值失败！！");
        }
    }
    @GetMapping("/spring/pay/shop")
    public  MessageResult<Integer> payShop(@RequestParam("gold")Integer oldGold,@RequestParam("priceGold")Integer priceGold,@RequestParam("id")Integer id){
        int result=iPayService.payShop(oldGold,priceGold,id);
        if(result>0){
            return new MessageResult<>(200,"花费了！！！"+priceGold);
        }else{
            return new MessageResult<>(402,"充值失败！！");
        }
    }
    @GetMapping("/spring/pay/updateSrc")
    public MessageResult<String> updateSrc(@RequestParam("pinSrc")String src,@RequestParam("id")Integer id){
     int result=iPayService.updateCustPhoneSrcById(src,id);
     if(result>0){
         return new MessageResult<>(200,"修改头像成功",src);
     }else {
         return new MessageResult<>(402,"修改失败",src);
     }
    }
}
