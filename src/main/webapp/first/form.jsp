<%--
  Created by IntelliJ IDEA.
  User: arek
  Date: 17.01.19
  Time: 11:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FormTest</title>
</head>
<h1>Form</h1>
<body>
    <div>
        <form method="post" action="/first/form">
            <input type="text" name="paramName" placeholder="Podaj wartość parametru"><br/>
            <br/>
            <input type="submit" value="Prześlij">
        </form>
    </div>
</body>
</html>
