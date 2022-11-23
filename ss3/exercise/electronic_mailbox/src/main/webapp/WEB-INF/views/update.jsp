<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 22/11/2022
  Time: 1:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Setting</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
            crossorigin="anonymous"></script>
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="configuringEmail" method="post" action="/update">
    <table>
        <tr>
            <td><form:hidden path="id"/></td>
        </tr>
        <tr>
            <td><form:label path="languages">Languages: </form:label></td>
            <td><form:select path="languages" items="${languge}"></form:select></td>
        </tr>
        <tr>
            <td><form:label path="pageSize">Page Size: </form:label></td>
            <td>Show <form:select path="pageSize" items="${pageSize}"></form:select> emails per page</td>

        </tr>
        <tr>
            <td><form:label path="spamsFillter">Spams Fillter: </form:label></td>
            <td><form:checkboxes path="spamsFillter" items="${spamsFillter}"/></td>
        </tr>
        <tr>
            <td><form:label path="signature">Signature: </form:label></td>
            <td><form:input path="signature"/></td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Update" role="button" class="btn btn-primary">
                <a href="/list" role="button" class="btn btn-primary">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
