package com.sbexample.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/Hello")//每一层注解，加一层接口

@RestController//正常是@Controller，为了让他返回是字符串
public class hello {
    //接口：http://localhost:8081/Hello/hello
    @RequestMapping("/hello")

    public String hello() {
        //调用业务，接收前端的参数
        return "我接收到前端的信息拉";

    }
}
