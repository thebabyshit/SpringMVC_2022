package com.mvc.service;

import com.mvc.dao.UserDao;
import com.mvc.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User get(Integer uid){
        System.out.println("service get User");
       return userDao.query(uid);
    }

    public void insert(User user){
        System.out.println("service insert User");
        userDao.save(user);
    }
}
