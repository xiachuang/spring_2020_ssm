package com.xia.controller.utils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SkipController {
    @GetMapping("spring/open")
    public String  open(){
        return "spring/open";
    }
    @GetMapping("spring/own")
    public String  own(){
        return "spring/own";
    }
    @GetMapping("/register")
    public String  register(){
        return "register";
    }//redirect:映射路径?参数名="+参数值)
    @GetMapping("/spring/vip/view")
    public String  vipView(){
        return "spring/vip/vipView";
    }//redirect:映射路径?参数名="+参数值)

}
