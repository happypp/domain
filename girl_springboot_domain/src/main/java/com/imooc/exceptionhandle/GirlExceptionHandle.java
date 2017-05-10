package com.imooc.exceptionhandle;

import com.imooc.entity.Result;
import com.imooc.exception.GirlException;
import com.imooc.utlis.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by pp on 2017/3/26.
 */
@ControllerAdvice
public class GirlExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(GirlException.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(),girlException.getMessage());
        }else {
            logger.error("【系统异常】{}", e);
            return ResultUtil.error(-1,e.getMessage() == null ? "未知错误" : e.getMessage());
        }
    }
}
