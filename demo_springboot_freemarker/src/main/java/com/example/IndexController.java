package com.example;

import com.example.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by pp on 2017/3/14.
 */
@Controller
public class IndexController {

    @RequestMapping("/")
    public ModelAndView welcome(Map<String,Object> model, HttpServletRequest request){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("userList",getUserInfo());
        //2:整数
        mv.addObject("intVal",100);
        //3:长整数
        mv.addObject("longVal", 200L);
        //4:字符串
        mv.addObject("stringVal", "freemarker");
        //5:双精度
        mv.addObject("doubleVal", 2.0);
        //6:布尔值
        mv.addObject("booleanVal", false);
        //7:日期
        mv.addObject("dateVal", new Date());
        //8:null值
        mv.addObject("nullVal", null);
        //9:map值
        Map<String,String> map = new HashMap<>();
        map.put("java","你好java!");
        map.put("python","你好python!");
        map.put("nodejs","你好nodejs!");
        mv.addObject("map",map);
        return mv;
    }

    private List<User> getUserInfo(){
        List<User> users = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++){
            User user = new User();
            user.setUserName("<font color='red'>用户</font> " + i);
            user.setBirthDay(new Date());
            users.add(user);
        }
        return users;
    }

}
