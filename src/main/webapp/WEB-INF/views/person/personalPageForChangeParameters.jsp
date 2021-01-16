<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 13.11.2020
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные</title>
</head>
<body>

<form:form action="/myStore/editPage" method="post" modelAttribute="person">
    Имя: <form:input path="name" title="${person.name}" />
    <form:errors cssStyle="color: red" path="name"/>
    <br/>
    Возраст: <form:input path="age" title="${person.age}" />
    <form:errors cssStyle="color: red" path="age"/>
    <br/>
    Логин: <form:input path="login" title="${person.login}"/>
    <form:errors cssStyle="color: red" path="login"/>
    <br/>
    Пароль: <form:input path="password" title="${person.password}"/>
    <form:errors cssStyle="color: red" path="password"/>
    <p><a href="/myStore/myPage">Назад</a>
        <input type="submit" value="Сохранить"/></p>
</form:form>
</body>
</html>