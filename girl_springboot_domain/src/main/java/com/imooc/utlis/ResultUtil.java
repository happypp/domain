package com.imooc.utlis;

import com.imooc.entity.Result;

/**
 * Created by pp on 2017/3/26.
 */
public class ResultUtil {

    public static Result error(Integer code,String errorMsg){
        Result result = new Result();
        result.setCode(code);
        result.setMsg(errorMsg);
        return result;
    }


    public static Result seccees(Object o){
        Result result = new Result();
        result.setCode(0);
        result.setMsg("成功");
        result.setData(o);
        return result;
    }

    public static Result seccees(){
        return seccees(null);
    }

}
