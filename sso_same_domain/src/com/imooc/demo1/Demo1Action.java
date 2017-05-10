package com.imooc.demo1;

import com.imooc.demo1.utils.Demo1Tool;
import com.imooc.util.SSOCheck;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by pp on 2017/2/19.
 */
public class Demo1Action extends ActionSupport {
    private String gotoUrl;
    public String main(){
        HttpServletRequest request = ServletActionContext.getRequest();
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("ssocookie") && cookie.getValue().equals("sso")){
                    String s = Demo1Tool.doGet("http://check.x.com/sso/checkCookie.action", cookie.getName(), cookie.getValue());
                    if("1".equals(s)){
                        return SUCCESS;
                    }
                }
            }
        }
        gotoUrl = "http://demo1.x.com/demo1/main.action";
        return LOGIN;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }
}
