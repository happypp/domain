package com.mrpeng.exception;

/**
 * Description: 重复秒杀的异常,mysql只支持运行期异常的回滚操作.
 *
 * Created by pp on 2017/5/9.
 */
public class RepeatKillException extends SeckillException {

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
