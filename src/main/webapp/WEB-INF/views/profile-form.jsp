<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 19/05/2025
  Time: 00:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="userProfile" action="profile-save" method="post" enctype="multipart/form-data">
  <div>Lua chon avatar</div>
  <form:input type="file" path="avatar"></form:input>

  <div>Ten nguoi dung</div>
  <form:input path="username"></form:input>

  <button type="submit">Cap nhat profile!!</button>
</form:form>
</body>
</html>
