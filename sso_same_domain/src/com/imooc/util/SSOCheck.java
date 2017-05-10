package com.imooc.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by pp on 2017/2/19.
 */
public class SSOCheck {
    public static final String USERNAME = "user";
    public static final String PASSWORD = "123";

    public static boolean checkLogin(String username,String password){
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }

    public static boolean checkCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if("ssocookie".equals(cookie.getName()) && "sso".equals(cookie.getValue())){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkCookie(String cookieName, String cookieValue){
        return "ssocookie".equals(cookieName) && "sso".equals(cookieValue);
    }
}
