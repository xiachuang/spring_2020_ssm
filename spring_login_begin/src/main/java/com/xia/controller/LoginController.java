package com.xia.controller;


import com.xia.result.MessageResult;
import com.xia.security.User;
import com.xia.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Resource
    private UserService userService;
    @GetMapping("/userLogin")
    public String userLogin(){
        return "login";
    }
    @PostMapping("/insertUser")
    public ModelAndView creatUser(HttpSession session, User user) {
        System.out.println(user.getUserName());
        int checkResult = userService.findUserByName(user.getUserName());
        if (checkResult < 0) {
            System.out.println(checkResult);
            int result = userService.creatUser(user);
            if (result < 0) {
                ModelAndView mv = new ModelAndView();
//                mv.addObject("msg", new MessageResult(500, "参数错误,请重新注册"));
                session.setAttribute("msg",new MessageResult<>(500,"参数错误,请重新注册"));
                mv.setViewName("redirect:register");
                return mv;
            } else {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("redirect:userLogin");
                return mv;
            }
        }else {
            ModelAndView mv = new ModelAndView();
            session.setAttribute("msg","用户名存在！请重新输入！！");
            mv.setViewName("redirect:register");
            return mv;
        }
    }

//    @GetMapping("/check/user")//异步访问
//    public @ResponseBody String checkUser(@RequestParam("userName") String userName){
//            int result=userService.findUserByName(userName);
//            if(result>0){
//                return "用户名存在";
//            }else {
//                return null;
//            }
//        }
    }


