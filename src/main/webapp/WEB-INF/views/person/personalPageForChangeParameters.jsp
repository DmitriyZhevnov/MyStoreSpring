<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 13.11.2020
  Time: 20:42
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="editPersonalDataPage.title"/></title>
    <select style="float: right" onchange="window.location.href=this.options[this.selectedIndex].value">
        <option VALUE=""><spring:message code="app.lang.title"/> </option>
        <option VALUE="?lang=en"><spring:message code="app.lang.english"/></option>
        <option VALUE="?lang=ru"><spring:message code="app.lang.russian"/></option>
        <option VALUE="?lang=de"><spring:message code="app.lang.deutsch"/></option>
    </select>
</head>
<body>

<form:form action="/myStore/editPage" method="post" modelAttribute="person">
    <spring:message code="editPersonalDataPage.name"/> <form:input path="name" title="${person.name}" />
    <form:errors cssStyle="color: red" path="name"/>
    <br/>
    <spring:message code="editPersonalDataPage.age"/> <form:input path="age" title="${person.age}" />
    <form:errors cssStyle="color: red" path="age"/>
    <br/>
    <spring:message code="editPersonalDataPage.login"/> <form:input path="login" title="${person.login}"/>
    <form:errors cssStyle="color: red" path="login"/>
    <br/>
    <spring:message code="editPersonalDataPage.password"/> <form:input path="password" title="${person.password}"/>
    <form:errors cssStyle="color: red" path="password"/>
    <p><a href="/myStore/myPage"><spring:message code="editPersonalDataPage.back"/></a>
        <input type="submit" value=<spring:message code="editPersonalDataPage.save"/>></p>
</form:form>
</body>
</html>