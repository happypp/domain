package com.imooc.sso;

import com.imooc.util.SSOCheck;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pp on 2017/2/19.
 */
public class SSOAction extends ActionSupport {

    private String username;
    private String password;
    private String gotoUrl;
    private String cookieName;
    private String cookieValue;

    public String doLogin() throws IOException {
        boolean ok = SSOCheck.checkLogin(username, password);
        if(ok){
            Cookie cookie = new Cookie("ssocookie","sso");
            cookie.setDomain(".x.com");
            cookie.setPath("/");
            HttpServletResponse response = ServletActionContext.getResponse();
            response.addCookie(cookie);
            return SUCCESS;
        }
        return null;
    }

    public void checkCookie() throws IOException {
        boolean b = SSOCheck.checkCookie(cookieName, cookieValue);
        String result = "0";
        if(b){
            result = "1";
        }
        HttpServletResponse response = ServletActionContext.getResponse();
        response.getWriter().print(result);
        response.getWriter().close();
    }
    public String getCookieName() {
        return cookieName;
    }

    public void setCookieName(String cookieName) {
        this.cookieName = cookieName;
    }

    public String getCookieValue() {
        return cookieValue;
    }

    public void setCookieValue(String cookieValue) {
        this.cookieValue = cookieValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGotoUrl() {
        return gotoUrl;
    }

    public void setGotoUrl(String gotoUrl) {
        this.gotoUrl = gotoUrl;
    }
}
