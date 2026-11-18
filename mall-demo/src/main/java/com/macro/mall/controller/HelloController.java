package com.macro.mall.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @Value("${spring.application.name}")
    private String name;

    @GetMapping("/hello")
    @ResponseBody
    public Map hello(){
        Map<String,String> map = new HashMap<>();
        map.put("message", "hello mall");
        map.put("application", name);
        return map;
    }

}
