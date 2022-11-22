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
</head>
<body>
<h1>Settings</h1>
<form:form modelAttribute="configuringEmail" method="post" action="/update">
    <table>
            <%--    <form:hidden path="id"/>--%>
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
                <button type="reset">Cancel</button>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
