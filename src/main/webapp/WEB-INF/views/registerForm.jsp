<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 18/05/2025
  Time: 22:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang dang ky</title>
</head>
<body>
<h2>Dang ky nguoi dung</h2>
<form:form modelAttribute="account" method="post" action="account-save">
    <div>Tenn nguoi dung:</div>
<form:input path="username"></form:input>

    <div>Mat khau:</div>
    <form:input path="password"></form:input>

    <div>Email:</div>
    <form:input path="email"></form:input>

    <button type="submit">Dang ky</button>
</form:form>
</body>
</html>
