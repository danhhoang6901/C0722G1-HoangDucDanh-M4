<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21/11/2022
  Time: 11:05 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Customer</title>
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
<h1 align="center">List Customer</h1>
<a role="button" class="btn btn-primary" href="/create">Create Customer</a>
<b style="color: red">${msg}</b>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Id</th>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Address</th>
        <th scope="col">Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <th scope="row">${customer.id}</th>
            <td><a href="/detail/${customer.id}">${customer.name}</a></td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
<%--            <td>--%>
<%--                <button type="submit" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">--%>
<%--                    Delete--%>
<%--                </button>--%>
<%--                <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel"--%>
<%--                     aria-hidden="true">--%>
<%--                    <div class="modal-dialog">--%>
<%--                        <div class="modal-content">--%>
<%--                            <div class="modal-header">--%>
<%--                                <h5 class="modal-title" id="exampleModalLabel">Delete Customer</h5>--%>
<%--                                <button type="button" class="btn-close" data-bs-dismiss="modal"--%>
<%--                                        aria-label="Close"></button>--%>
<%--                            </div>--%>
<%--                            <div class="modal-body">--%>
<%--                                ...--%>
<%--                            </div>--%>
<%--                            <div class="modal-footer">--%>
<%--                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>--%>
<%--                                <button type="button" class="btn btn-primary">Save changes</button>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </td>--%>
            <td><a href="/delete/${customer.id}" role="button" class="btn btn-primary">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
