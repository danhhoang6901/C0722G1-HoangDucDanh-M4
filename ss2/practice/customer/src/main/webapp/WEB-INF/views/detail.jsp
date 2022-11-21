<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21/11/2022
  Time: 11:28 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Detail</title>
</head>
<body>
<table class="table" border="1px">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <th scope="row">${customer.id}</th>
        <td>${customer.name}</td>
        <td>${customer.email}</td>
        <td>${customer.address}</td>
    </tr>
    </tbody>
</table>
<a href="/list">List</a>
</body>
</html>
