<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 13.11.2020
  Time: 00:08
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="login.title"/></title>
    <select style="float: right" onchange="window.location.href=this.options[this.selectedIndex].value">
        <option VALUE=""><spring:message code="app.lang.title"/> </option>
        <option VALUE="?lang=en"><spring:message code="app.lang.english"/></option>
        <option VALUE="?lang=ru"><spring:message code="app.lang.russian"/></option>
        <option VALUE="?lang=de"><spring:message code="app.lang.deutsch"/></option>
    </select>
</head>
<body>
<form:form action="/myStore/login" method="post" modelAttribute="person">
    <spring:message code="login.login"/> <form:input path="login"/>
    <br/>
    <spring:message code="login.password"/> <form:input path="password"/>
    <br/>
    <p><input type="submit" value=<spring:message code="login.enter"/>>
        <a href="/myStore/registration"><spring:message code="login.register"/></a></p>
</form:form>
</body>
</html>