<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 22/11/2022
  Time: 1:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css">
    <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css">
    <script src="jquery/jquery-3.5.1.min.js"></script>
    <script src="datatables/js/jquery.dataTables.min.js"></script>
    <script src="datatables/js/dataTables.bootstrap5.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Configuring Email</h1>
<p>${msg}</p>
<table class="table">
    <thead>
    <tr>
        <th scope="col">STT</th>
        <th scope="col">Languages</th>
        <th scope="col">Page Size</th>
        <th scope="col">Spams Fillter</th>
        <th scope="col">Signature</th>
        <th scope="col">Update</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="ce" items="${configuringEmail}">
        <tr>
            <th scope="row">${ce.id}</th>
            <td>${ce.languages}</td>
            <td>${ce.pageSize}</td>
            <td>${ce.spamsFillter}</td>
            <td>${ce.signature}</td>
            <td><a href="/update/${ce.id}" role="button" class="btn btn-primary">Update</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
