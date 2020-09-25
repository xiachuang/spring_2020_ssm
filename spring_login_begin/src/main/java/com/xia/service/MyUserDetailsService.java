package com.xia.service;

import com.xia.mapper.LoginMapper;
import com.xia.security.Role;
import com.xia.security.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;


@Service
public class MyUserDetailsService implements UserDetailsService {
    @Resource
    private LoginMapper loginMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Collection<GrantedAuthority> authorities=new HashSet<>();
        User user=loginMapper.loginByPwd(s);
        if(user==null){
            throw new UsernameNotFoundException("用户不存在！请注册");
        }else {
            System.out.println(user);
            Set<Role> roles=loginMapper.findRoleByUserId(user.getId());
            for(Role role:roles){
                authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
            }
        }
        return new org.springframework.security.core.userdetails.User(s,user.getPassword(),authorities);
    }
}
