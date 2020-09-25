package com.xia.service;

import com.xia.security.User;

public interface UserService {
    public int creatUser(User user);
    public int findUserByName(String userName);
}
