<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 19/05/2025
  Time: 01:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Upload Tài Liệu</title>
</head>
<body>
<h2>Form upload tài liệu</h2>

<form:form modelAttribute="document" method="post" action="document-save" enctype="multipart/form-data">
  <div>Tiêu đề:</div>
  <form:input path="title" />

  <div>Mô tả:</div>
  <form:input path="description" />

  <div>File:</div>
  <input type="file" name="file" />

  <br><br>
  <button type="submit">Nộp file</button>
</form:form>

</body>
</html>

