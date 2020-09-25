package com.xia.mapper;

import com.xia.security.Role;
import com.xia.security.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

@Mapper
public interface LoginMapper {
    @Select("select * from user where userName=#{userName}")
    public User loginByPwd(String userName);
    @Select("select * from role where id in(select roleId from user_role where userId=#{userId})")
    public Set<Role> findRoleByUserId(Integer userId);
    @Insert("insert into user(userName,password) values(#{userName},#{password})")
    public int creatUser(User user);
    @Select("select id from user where userName=#{userName}")
    public String findUserByName(String userName);
}
