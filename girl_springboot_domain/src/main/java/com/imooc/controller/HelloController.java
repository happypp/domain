package com.imooc.controller;

import com.imooc.propertites.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by pp on 2017/3/25.
 */
//@RestController 相当于 @Controller + @ResponseBody
@RestController
public class HelloController {

    @Autowired
    private GirlProperties girlProperties;

//    @RequestMapping(value = {"/hello","/hi/{id}"},method = RequestMethod.GET)
    @GetMapping(value = {"/hello","/hi/{id}"})
    public String say(@PathVariable(value = "id",required = false) Integer id,
                       @RequestParam(value = "ids",required = false) Integer ids){
        return id + "" + ids;
    }

}
