<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="/user/login" method="get">
    用户名：<input type="text" name="name">
    密码：<input type="text" name="password">
    <input type="submit" value="登陆">
</form>
</body>