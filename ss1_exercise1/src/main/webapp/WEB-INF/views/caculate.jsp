<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 18/11/2022
  Time: 2:45 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post">
    <h1>Caculate</h1>
    <p>USD: </p>
    <input type="number" name="usd">
    <%--<p>Rate: </p>--%>
    <%--<input type="number" name="rate" placeholder="Rate" value="23000">--%>
    <input type="submit" value="Caculate">
    <p>Kết quả: ${result}VND</p>
</form>
</body>
</html>
