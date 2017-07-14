package com.ejb;

import javax.ejb.Remote;

/**
 * Created by pp on 2017/7/14.
 */
@Remote
public interface HelloWorld {
    public String sayHello(String world);
}
