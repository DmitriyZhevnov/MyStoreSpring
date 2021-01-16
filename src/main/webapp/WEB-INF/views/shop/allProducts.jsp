<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 19.11.2020
  Time: 20:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Магазин</title>
</head>
<body>
<table border="1" width="100%" cellpadding="5">
    <tr>
        <th width="25%">Название</th>
        <th width="25%">Описание</th>
        <th width="5%">Цена</th>
        <th width="20%">Добавить в корзину</th>
    </tr>
    <c:forEach items="${listOfProducts}" var="product" >
        <tr>
            <td> ${product.name}
            </td>
            <td> ${product.description}
            </td>
            <td> ${String.format("%.2f", product.price)}
            </td>
            <td>
                <form action='/shop/' method='POST'>
                    <input name="count"/>
                    <input type="hidden" name="idProduct" value=" ${product.id}"/>
                    <input type='submit' value='Добавить'/>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
<p><a href="/basket">В корзину</a></p>
<p><a href="/mainPage.jsp">На главную страницу</a></p>
</body>
</html>