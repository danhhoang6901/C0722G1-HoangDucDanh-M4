<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 18/11/2022
  Time: 3:52 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Translate</h1>
<form method="post">
    <input type="text" name="word">
    <button type="submit">Translate</button>
</form>
<p>Result: ${transalte.get(word)}</p>
</body>
</html>
