<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 13.11.2020
  Time: 00:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="main.title"/> </title>
    <select style="float: right" onchange="window.location.href=this.options[this.selectedIndex].value">
        <option VALUE=""><spring:message code="app.lang.title"/> </option>
        <option VALUE="?lang=en"><spring:message code="app.lang.english"/></option>
        <option VALUE="?lang=ru"><spring:message code="app.lang.russian"/></option>
        <option VALUE="?lang=de"><spring:message code="app.lang.deutsch"/></option>
    </select>
</head>
<body>
<div><h2 align="center"><spring:message code="main.title"/></h2></div>
<div align="left">
    <form>
        <br/>
        <p><a href="/myStore/myPage"><spring:message code="main.myAccount"/></a></p>
        <p><a href="/shop/"><spring:message code="main.shop"/></a></p>
        <p><a href="/basket"><spring:message code="main.basket"/></a></p>
        <p><a href="login.jsp"><spring:message code="main.exit"/></a></p>
    </form>
</div>
</body>
</html>
