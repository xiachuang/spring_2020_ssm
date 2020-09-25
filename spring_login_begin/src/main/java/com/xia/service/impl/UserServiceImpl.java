package com.xia.service.impl;

import com.xia.mapper.LoginMapper;
import com.xia.security.User;
import com.xia.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class UserServiceImpl implements UserService {
//    @Resource
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
        @Resource
        private  BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private LoginMapper loginMapper;
    @Override
    public int creatUser(User user) {
        if(user==null){
            return -1;
        }else {
            String bcPwd=bCryptPasswordEncoder.encode(user.getPassword());
            System.out.println(bcPwd);
            user.setPassword(bcPwd);
            System.out.println(user);
            return loginMapper.creatUser(user);
        }
    }

    @Override
    public int findUserByName(String userName) {
        int row=0;
        String id=loginMapper.findUserByName(userName);
        if(id==null||id.isEmpty()){
            row=-1;
        }else {
            row = 1;
        }
        return row;
    }
}
