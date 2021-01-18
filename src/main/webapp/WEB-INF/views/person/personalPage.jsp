<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 13.11.2020
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title><spring:message code="personalPage.title"/></title>
    <select style="float: right" onchange="window.location.href=this.options[this.selectedIndex].value">
        <option VALUE=""><spring:message code="app.lang.title"/> </option>
        <option VALUE="?lang=en"><spring:message code="app.lang.english"/></option>
        <option VALUE="?lang=ru"><spring:message code="app.lang.russian"/></option>
        <option VALUE="?lang=de"><spring:message code="app.lang.deutsch"/></option>
    </select>
</head>
<body>
<div align="center">
    <h2><spring:message code="personalPage.h2"/></h2>
    <p> <spring:message code="personalPage.name"/> ${person.name}
    </p>
    <p> <spring:message code="personalPage.login"/> ${person.login}
    </p>
    <p> <spring:message code="personalPage.age"/> ${person.age}
    </p>
</div>
<p><a href="/myStore/editPage"><spring:message code="personalPage.changeData"/></a></p>
<p><a href=""><spring:message code="personalPage.orderHistory"/></a></p>
<p><a href="/myStore/"><spring:message code="personalPage.goToMainPage"/></a></p>
<p><a href="/myStore/"><spring:message code="personalPage.exit"/></a></p>
</body>
</html>
