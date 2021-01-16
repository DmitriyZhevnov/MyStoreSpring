<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 13.11.2020
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Мой аккаунт</title>
</head>
<body>
<div align="center">
    <h2>Информация о Вас</h2>
    <p> Имя: ${person.name}
    </p>
    <p> Логин  ${person.login}
    </p>
    <p> Возраст:  ${person.age}
    </p>
</div>
<p><a href="/myStore/editPage">Изменить данные</a></p>
<p><a href="">История заказов</a></p>
<p><a href="/myStore/">На главную страницу</a></p>
<p><a href="/myStore/">Выйти из учётной записи</a></p>
</body>
</html>
