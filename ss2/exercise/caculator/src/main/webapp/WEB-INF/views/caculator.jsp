<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21/11/2022
  Time: 2:17 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<form action="/caculator" method="post">
    <h1>Caculator</h1>
    <input type="number" name="numberOne">
    <input type="number" name="numberTwo"><br>
    <hr>
    <button value="+" type="submit" name="submit">Addition(+)</button>
    <button value="-" type="submit" name="submit">Subtraction(-)</button>
    <button value="*" type="submit" name="submit">Multiplication(x)</button>
    <button value="/" type="submit" name="submit">Division(/)</button>
    <pre>Result: ${numberOne} ${submit} ${numberTwo} = ${result} </pre>
</form>
</body>
</html>
