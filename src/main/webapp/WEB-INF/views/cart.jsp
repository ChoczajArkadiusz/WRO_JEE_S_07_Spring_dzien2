<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 17.01.19
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Cart</title>
</head>
<body>

    <h1>Koszyk - podsumowanie</h1>
        W koszyku jest ${numOfPos} pozycji.<br>
        W koszyku jest ${numOfItems} produktów.<br>
        Wartość koszyka to: ${total}zł.<br>

    <hr>
    <h2>Koszyk - zawartość</h2>
    <c:forEach items="${carts}" var="cart">
        Product: ${cart.product.name}<br>
        Price: ${cart.product.price}<br>
        Quantity: ${cart.quantity}<br>
        <hr/>
    </c:forEach>


</body>
</html>
