package com.imooc.exception;

import com.imooc.enums.GirlEnums;
import lombok.Data;

/**
 * Created by pp on 2017/3/26.
 */
@Data
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

    public GirlException(String msg) {
        super(msg);
    }

    public GirlException(GirlEnums girlEnums) {
        super(girlEnums.getMsg());
        this.code = girlEnums.getCode();
    }
}
