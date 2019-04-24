package com.chinasofti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author:胡瑶
 * date:2019/4/24
 * time:14:53
 */
@RestController
public class HelloController {

    @RequestMapping("/hello123")
    public String hello(){

        return "haha,你在干嘛！";
    }
}
