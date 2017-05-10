package com.mrpeng.exception;

/**
 * Description: 秒杀相关的所有业务的异常。
 *
 * Created by pp on 2017/5/9.
 */
public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
