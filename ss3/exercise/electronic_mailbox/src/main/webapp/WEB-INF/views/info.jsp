<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 22/11/2022
  Time: 3:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>${msg}</p>
<table>
    <tr>
        <td>Languages:</td>
        <td>${configuringEmail.languages}</td>
    </tr>
    <tr>
        <td>Page Size:</td>
        <td>${configuringEmail.pageSize}</td>
    </tr>
    <tr>
        <td>Spams Fillter:</td>
        <td>${configuringEmail.spamsFillter}</td>
    </tr>
    <tr>
        <td>Signature:</td>
        <td>${configuringEmail.signature}</td>
    </tr>
</table>
</body>
</html>
