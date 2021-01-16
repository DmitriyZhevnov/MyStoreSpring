<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 13.11.2020
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<form:form action="/myStore/registration" method="post" modelAttribute="person">
    Имя: <form:input path="name"/>
    <form:errors cssStyle="color: red" path="name"/>
    <br/>
    Возраст: <form:input path="age"/>
    <form:errors cssStyle="color: red" path="age"/>
    <br/>
    Логин: <form:input path="login"/>
    <form:errors cssStyle="color: red" path="login"/>
    <br/>
    Пароль: <form:input path="password"/>
    <form:errors cssStyle="color: red" path="password"/>
    <input type="submit" value="Зарегестрировать"/>
    <p><a href="loginPage.jsp">Назад</a></p>
    <br/>
</form:form>
</body>
</html>
