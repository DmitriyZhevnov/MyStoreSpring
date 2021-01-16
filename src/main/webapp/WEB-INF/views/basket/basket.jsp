<%--
  Created by IntelliJ IDEA.
  User: Жевновы
  Date: 20.11.2020
  Time: 01:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Моя корзина</title>
</head>
<body>
<table border="1" width="100%" cellpadding="5">
    <tr>
        <th width="25%">Название</th>
        <th width="25%">Описание</th>
        <th width="5%">Цена</th>
        <th width="5%">Количество</th>
        <th width="5%">Итого</th>
        <th width="20%">Изменить количество</th>
        <th width="5%">Удалить</th>
    </tr>
    <c:forEach items="${listOfProductsInBasket}" var="product">
        <tr>
            <td> ${product.products.get(0).name}
            </td>
            <td> ${product.products.get(0).description}
            </td>
            <td> ${product.products.get(0).price}
            </td>
            <td> ${product.quantity}
            </td>
            <td> ${product.products.get(0).price * product.quantity}
            </td>
            <td>
                <form action='/basket' method='POST'>
                    <input type="hidden" name="_method" value="patch">
                    <input type="hidden" name="operationInBasket" value="modifyProduct">
                    <input name="count" value="${product.quantity}"/>
                    <input type="hidden" name="idProduct" value="${product.products.get(0).id}"/>
                    <input type='submit' value='Изменить'/>
                </form>
            </td>
            <td>
                <form action='/basket' method='POST'>
                    <input type="hidden" name="_method" value="delete">
                    <input type="hidden" name="operationInBasket" value="deleteProduct">
                    <input type="hidden" name="idProduct" value="${product.products.get(0).id}"/>
                    <input type='submit' value='Удалить'/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</h2>
<h2 align="right">
    <form action='/makeOrder.jsp'>
        <input type="hidden" name="operationInBasket" value="pay">
        <input type='submit' value='Оформить заказ'/>
    </form>
</h2>
<p><a href="/shop/">В магазин</a></p>
<p><a href="">На главную страницу</a></p>
</body>
</html>