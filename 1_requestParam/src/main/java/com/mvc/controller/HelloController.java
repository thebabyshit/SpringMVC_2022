package com.mvc.controller;

import com.mvc.anno.MyLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author
 * @Date 2022/10/20 9:36
 * @Description
 **/

@Controller
public class HelloController {

    @MyLog
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @MyLog
    @RequestMapping("jdbc")
    public String jdbc(){
        return "jdbc";
    }
}
