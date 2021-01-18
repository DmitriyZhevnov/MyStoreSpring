<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 13.11.2020
  Time: 00:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title><spring:message code="registration.title"/></title>
    <select style="float: right" onchange="window.location.href=this.options[this.selectedIndex].value">
        <option VALUE=""><spring:message code="app.lang.title"/> </option>
        <option VALUE="?lang=en"><spring:message code="app.lang.english"/></option>
        <option VALUE="?lang=ru"><spring:message code="app.lang.russian"/></option>
        <option VALUE="?lang=de"><spring:message code="app.lang.deutsch"/></option>
    </select>
</head>
<body>
<form:form action="/myStore/registration" method="post" modelAttribute="person">
    <spring:message code="registration.name"/> <form:input path="name"/>
    <form:errors cssStyle="color: red" path="name"/>
    <br/>
    <spring:message code="registration.age"/> <form:input path="age"/>
    <form:errors cssStyle="color: red" path="age"/>
    <br/>
    <spring:message code="registration.login"/> <form:input path="login"/>
    <form:errors cssStyle="color: red" path="login"/>
    <br/>
    <spring:message code="registration.password"/> <form:input path="password"/>
    <form:errors cssStyle="color: red" path="password"/>
    <input type="submit" value=<spring:message code="registration.register"/>>
    <p><a href="loginPage.jsp"><spring:message code="registration.back"/></a></p>
    <br/>
</form:form>
</body>
</html>
