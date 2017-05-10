package com.imooc.enums;

import lombok.Data;

/**
 * Created by pp on 2017/3/26.
 */
public enum GirlEnums {
    PRIMARY_SCHOOL(101,"你可能还在上小学吧"),
    MIDDLE_SCHOOL(102,"你可能还在上初中吧"),
    NULL_ERROR(103,"数据为空"),
    SUCCESS(0,"成功");

    private Integer code;

    private String msg;

    GirlEnums(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
