package com.imooc.controller;

import com.imooc.entity.Girl;
import com.imooc.dao.GirlRepository;
import com.imooc.entity.Result;
import com.imooc.service.GirlService;
import com.imooc.utlis.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by pp on 2017/3/25.
 */
@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;
    /**
     * 查询所有的女生信息
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> getGirlList(){
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls")
    public Result addGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
//            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return ResultUtil.seccees(girlRepository.save(girl));
    }

    /**
     * 根据ID查询一个女孩
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl findGirlById(@PathVariable("id") Integer id){
        return girlRepository.findOne(id);
    }

    /**
     * 根据ID更新一个女生
     * @param id
     * @param girl
     * @return
     */
    @PutMapping(value = "/girls/{id}")
    public Girl updateGirlById(@PathVariable("id") Integer id,Girl girl){
        girl.setId(id);
        return girlRepository.save(girl);
    }

    /**
     * 根据id删除一个女生
     * @param id
     * @return
     */
    @DeleteMapping(value = "/girls/{id}")
    public String deleteGirlById(@PathVariable("id") Integer id){
        girlRepository.delete(id);
        return "删除成功~！";
    }

    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findGirlByAge(@PathVariable("age") Integer age) throws Exception {
        return girlRepository.findGirlsByAge(age);
    }

    @PostMapping(value = "/girls/tow")
    public void insertTow(){
        girlService.insertTow();
    }

    @GetMapping(value = "/girls/girlInfo/{id}")
    public Result getGirlInfo(@PathVariable("id") Integer id) throws Exception {
        return girlService.getGirlInfo(id);
    }
}
