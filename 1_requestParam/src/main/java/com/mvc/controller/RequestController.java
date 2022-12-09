package com.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author DELL
 */

//默认值为vale
    //可以不带“/"      value可以设置多个值
@Controller
@RequestMapping("/req")
public class RequestController {
    public String returnIndex() {
        return "success";
    }

    @RequestMapping("/location")
    public String returnIndex1() {
        return "success";
    }

    @RequestMapping("v")
    public String requestValue2() {
        return "success";
    }

    @RequestMapping("v2")//不能重复
    public String requestValue3() {
        return "success";
    }

//method:gwt post
//    设置method后，只能用指定请求方法访问该网站，否则405


    @GetMapping("m1")
    public String requestMethod() {
        return "success";
    }

    // @RequestMapping(value = "m2",
    //       method = RequestMethod.POST)


    @PostMapping("m2")
    public String requestMethod2() {
        return "success";
    }

    @RequestMapping(value = "m3",
            method = {RequestMethod.GET, RequestMethod.POST})
    public String requestMethod3() {
        return "success";
    }

    //非法方法吃瓜先时，默认以get方法发送请求

    @PutMapping("m4")
    public String requestMethod4() {
        return "success";
    }

    //    Params:通过请求参数匹配来请求映射
//    {conditional,conditional}设置多个值
    @RequestMapping(value = {"p1", "p"},
            method = {RequestMethod.GET, RequestMethod.POST},
            params = "username")
    public String requestParams1() {
        return "success";
    }


    @RequestMapping(value = "p2",
            method = {RequestMethod.GET, RequestMethod.POST},
            params = "username=admin")
    public String requestParams2() {
        return "success";
    }


    @RequestMapping(value = "p3",
            method = {RequestMethod.GET, RequestMethod.POST},
            params = {"username=admin", "pwd!=123"})
    public String requestParams3() {
        return "success";
    }




    @RequestMapping(value = "h1",
            method = {RequestMethod.GET, RequestMethod.POST},
            params={"username=admin","pwd!=123"},
            headers = "Host=localhost:8080")
    public String requestheaders() {
        return "success";
    }



    @RequestMapping(value = "h2",
            method = {RequestMethod.GET, RequestMethod.POST},
            params={"username=admin","pwd!=123"},
            headers = "Host=localhost:8080")
    public String requestheaders2() {
        return "success";
    }
        }

