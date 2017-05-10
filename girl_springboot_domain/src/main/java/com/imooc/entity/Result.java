package com.imooc.entity;

import lombok.Data;

/**
 * Created by pp on 2017/3/26.
 */
@Data
public class Result<T> {

    private Integer code;

    private String msg;

    private T data;
}
