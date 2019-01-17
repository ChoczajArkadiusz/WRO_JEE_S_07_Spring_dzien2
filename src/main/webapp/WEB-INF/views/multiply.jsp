<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 17.01.19
  Time: 13:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tabliczka mnożenia</title>
    <style>
        table {
            border-collapse: collapse;
        }

        table, td {
            border: 1px solid darkslateblue;
            padding: 10px;
            text-align: center;
        }

        th {
            border: 1px solid darkslateblue;
            padding: 10px;
            color: white;
            background-color: darkslateblue;
        }

        tr:nth-Child(odd) {
            background-color: lightcyan;
        }
    </style>
</head>
<body>
<h1>Tabliczka mnożenia ${rows} x ${cols}</h1>

<table>
    <th>x</th>
    <c:forEach begin="1" end="${cols}" varStatus="i">
        <th>${i.index}</th>
    </c:forEach>
    <c:forEach begin="1" end="${rows}" varStatus="i">
        <tr>
            <th>${i.index}</th>
            <c:forEach begin="1" end="${cols}" varStatus="j">
                <td>${i.index*j.index}</td>
            </c:forEach>
        </tr>
    </c:forEach>
</table>

</body>
</html>
