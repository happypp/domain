package com.mrpeng.controller;

import com.mrpeng.dto.Exposer;
import com.mrpeng.dto.SecKillExecution;
import com.mrpeng.dto.SeckillResult;
import com.mrpeng.entity.SecKill;
import com.mrpeng.enums.SeckillStateEnum;
import com.mrpeng.exception.RepeatKillException;
import com.mrpeng.exception.SeckillCloseException;
import com.mrpeng.exception.SeckillException;
import com.mrpeng.servce.SeckillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Description: 整个秒杀系统的Controller层,使用spring mvc的restful风格url
 *
 * Created by pp on 2017/5/9.
 * */
@RestController    // 当前注解继承自@Component,是为了表明分层组件的分层,类似的还有@Service
@RequestMapping("/seckill")  // @RequestMappping MVC的url->对应的方法 url:模块/资源/{}/细分
public class SeckillController {

    @Autowired
    private SeckillService service;

//    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @GetMapping("/list")
    public String getList(Model model) {
        int i;
        // 调用service层的方法查询所有的记录
        List<SecKill> seckillList = this.service.getSeckillList();
        // 将其保存在ModelAndView中,用于在jsp列表页面展示
        model.addAttribute("list", seckillList);
        return "list";
    }

//    @RequestMapping(value = "/{seckillId}/detail", method = RequestMethod.GET)
    @GetMapping("/{seckillId}/detail")
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if(seckillId == null) {
            return "redirect:/seckill/list";
        }
        // 调用service层的方法,根据秒杀商品的Id编号查询商品的详情.
        SecKill seckill = this.service.getById(seckillId);
        if(null == seckill) {
            return "redirect:/seckill/list";
        }
        // 将查询到的数据保存到Model中
        model.addAttribute("seckill", seckill);
        return "detail";
    }

    // ajax, json暴露秒杀接口的方法
//    @RequestMapping(value = "/{seckillId}/exposer",
//            method = RequestMethod.GET,
//            produces = {"application/json;charset=UTF-8"})
//    @ResponseBody       // Spring MVC中用于返回Json数据的注解
    @GetMapping(value = "/{seckillId}/exposer", produces = {"application/json;charset=UTF-8"})
    public SeckillResult<Exposer> exposer(@PathVariable("seckillId") Long seckillId) {
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = this.service.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exposer>(true, exposer);
        } catch(Exception ex) {
            ex.printStackTrace();
            return new SeckillResult<Exposer>(false, ex.getMessage());
        }
        return result;
    }

//    @RequestMapping(value = "/{seckillId}/{md5}/execution",
//        method = RequestMethod.POST,
//        produces = {"application/json;charset=utf-8"})
//    @ResponseBody
    /**
     * @param phone 是从cookie中进行取值的,用户的联系方式;
     * */
    @PostMapping(value = "/{seckillId}/{md5}/execution", produces = {"application/json;charset=utf-8"})
    public SeckillResult<SecKillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value="userPhone", required = false) Long phone) {
        if(null == phone) {
            return new SeckillResult<SecKillExecution>(false, "未注册");
        }
        try {
            // 调用service层的方法执行秒杀的操作.
            SecKillExecution execution = this.service.executeSeckill(seckillId, phone, md5);
            return new SeckillResult<SecKillExecution>(true, execution);
        } catch (RepeatKillException e1) {
            SecKillExecution execution = new SecKillExecution(seckillId, SeckillStateEnum.REPEAT_KILL);
            return new SeckillResult<SecKillExecution>(true, execution);
        } catch (SeckillCloseException e2) {
            SecKillExecution execution = new SecKillExecution(seckillId, SeckillStateEnum.END);
            return new SeckillResult<SecKillExecution>(true, execution);
        } catch (SeckillException e) {
            SecKillExecution execution = new SecKillExecution(seckillId, SeckillStateEnum.INNER_ERROR);
            return new SeckillResult<SecKillExecution>(true, execution);
        }
    }

    // 用于获取系统的时间
//    @RequestMapping(value = "/time/now",
//        method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/time/now")
    public SeckillResult<Long> getTime() {
        Date date = new Date();
        return new SeckillResult<Long>(true, date.getTime());
    }
}
