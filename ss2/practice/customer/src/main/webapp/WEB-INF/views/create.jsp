<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21/11/2022
  Time: 11:39 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Create Customer</title>
</head>
<body>
<form action="/create" method="post">
    <p>Id: </p>
    <input type="text" name="id">
    <p>Name: </p>
    <input type="text" name="name">
    <p>Email: </p>
    <input type="text" name="email">
    <p>Address: </p>
    <input type="text" name="address"><br>
    <input type="submit" value="Create Customer"><br>
    <a href="/list" role="button" class="btn btn-primary">Back List</a>
</form>
</body>
</html>
