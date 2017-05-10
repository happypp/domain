<%--
  Created by IntelliJ IDEA.
  User: pp
  Date: 2017/2/19
  Time: 17:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <content>
        <h1>请登录</h1>
        <form action="http://check.x.com/sso/doLogin.action" method="post">
            <span>用户名:</span><input type="text" name="username">
            <span>密码:</span><input type="password" name="password">
            <input type="hidden" name="gotoUrl" value="${gotoUrl}">
            <input type="submit" value="登录">
        </form>
    </content>
</body>
</html>
