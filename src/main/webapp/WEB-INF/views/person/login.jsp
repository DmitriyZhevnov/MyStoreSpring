<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 13.11.2020
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Войти в аккаунт</title>
</head>
<body>
<form:form action="/myStore/login" method="post" modelAttribute="person">
    Логин: <form:input path="login" />
    <br/>
    Пароль: <form:input path="password" />
    <br/>
    <p><input type="submit" value="Войти"/>
        <a href="/myStore/registration">Регистрация</a></p>
</form:form>
</body>
</html>