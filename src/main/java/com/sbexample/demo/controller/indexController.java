package com.sbexample.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller//templates（模板）中的所有页面，必须通过controller来跳转！
// 这个需要模板引擎的支持！添加thymeleaf依赖
public class indexController {

    @RequestMapping("/index")
    public String index(){ return "index"; }//根据源码，SB中首页的名字就是index，其他页面是自己定的

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","你好");//前面是命名的参数类型，后面是值
        model.addAttribute("msg2","<div>你好</div>");//前面是命名的参数类型，后面是值
        model.addAttribute("arr", Arrays.asList("aa","bb"));//遍历数组
        return "test";
    }
}
