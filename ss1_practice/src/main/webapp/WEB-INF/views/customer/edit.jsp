<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 18/11/2022
  Time: 1:58 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer</title>
</head>
<body>
<table>
    <tr>
        <td>Id:</td>
        <td><input type="text" name="id" value="${customer.id}"></td>
    </tr>
    <tr>
        <td>Name:</td>
        <td><input type="text" name="name" value="${customer.name}"></td>
    </tr>
    <tr>
        <td>Email:</td>
        <td><input type="text" name="email" value="${customer.email}"></td>
    </tr>
    <tr>
        <td>Address:</td>
        <td><input type="text" name="address" value="${customer.address}"></td>
    </tr>
    <tr>
        <td><input type="submit" value="Update"></td>
    </tr>
</table>
</body>
</html>
