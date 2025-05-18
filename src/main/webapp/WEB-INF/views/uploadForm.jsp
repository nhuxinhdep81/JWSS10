<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 19/05/2025
  Time: 02:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="file1" action="file-save" method="post" enctype="multipart/form-data">
    <form:input type="file" path="file"></form:input>

    <div>Mo ta: </div>
    <form:input path="description"></form:input>

    <button type="submit">Nop file</button>
</form:form>
</body>
</html>
