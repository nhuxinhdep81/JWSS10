<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 18/05/2025
  Time: 22:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form dang nhap</title>
</head>
<body>
<form:form modelAttribute="user" action="user-login"
           method="post">
  <div>Ten: </div>
  <form:input path="name"></form:input>

  <div>Tuoi: </div>
  <form:input path="age"></form:input>

  <div>Dia chi: </div>
  <form:input path="address"></form:input>

  <button type="submit">Submit</button>
</form:form>
</body>
</html>
