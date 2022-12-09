package com.mvc.controller;


import com.mvc.pojo.User;
import com.mvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("get/{id}")
    @ResponseBody
    public User reqUser(@PathVariable("id") Integer uid){
        User user = userService.get(uid);
        System.out.println(user);
        return  user;
    }

    @RequestMapping("save")
    public String saveUser(User user) {
        System.out.println(user);
        userService.insert(user);
        return "success";
    }

//    @ResponseBody
    @PostMapping("save2")
    public String saveUser2(@RequestBody User user) {
        System.out.println(user);
        userService.insert(user);
        return "success";
    }


    @GetMapping("user")
    public ModelAndView showList(ModelAndView mv){
        List<User> list = new ArrayList<User>();
        list.add(new User(12,"AAA","AAAAA"));
        list.add(new User(12,"AAA","AAAAA"));
        list.add(new User(12,"AAA","AAAAA"));
        list.add(new User(12,"AAA","AAAAA"));
        list.add(new User(12,"AAA","AAAAA"));
        mv.addObject("users",list);
        mv.setViewName("success");
        return mv;
    }
}
