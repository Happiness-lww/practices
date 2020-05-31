package com.sbexample.demo.config;


import com.sbexample.demo.controller.LoginHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

//扩展springmvc，定制自己的功能，写好这个组件，交给SB后，它会自动装配好
//dispatchservlet实现类，所有的请求和响应都会经过此类中的doDispatch方法

@Configuration

//不能添加@EnableWebMvc，这代表全面接管MVC，我们这个是扩展

public class MyMVCconfig implements WebMvcConfigurer {
    /*常用的配置Bean的方式
    @Bean
    public ViewResolver myViewResolver() {
        return new MyViewResolver();
    }

    //自定义了一个自己的视图解析器
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }*/

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //增加视图控制，“/”和“/index.html”都可以跳转到首页
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        //增加视图控制，“main.html”可以跳转到个人主页
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //自定义的国际化
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //请求拦截，addPathPatterns("/**")：过滤所有请求，
        // excludePathPatterns():排除哪些页面
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/index.html","/user/login","/","/static/**");
    }
}
