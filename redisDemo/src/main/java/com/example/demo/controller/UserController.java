package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pp on 2017/5/21.
 */
@RestController
public class UserController {

    @Autowired
    private RedisService redisService;


    @GetMapping("/getuserfromredis")
    public User getRedis() {
        User user = new User();
        user.setId(1l);
        return (User)redisService.get(user.getId() + "");
    }

    @GetMapping("/adduser")
    public String addUser() {
        User user = new User();
        user.setId(1l);
        user.setFirstName("peng");
        user.setLastName("peng");
        System.out.println(user);
        redisService.set(user.getId() + "" ,user);
        return "Saved";
    }
}
