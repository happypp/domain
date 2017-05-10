package com.mrpeng.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pp on 2017/5/9.
 */
@RestController("/springBoot")
public class HelloController {

    @GetMapping("/hello")
    public String sayHello(){

        return "SpringBoot Hello";
    }
}
