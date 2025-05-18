<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 16/05/2025
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Book form</h4>
    <form:form modelAttribute="book" action="book-save"
               method="post" enctype="multipart/form-data">
        <div>Title</div>
        <form:input path="title"></form:input>

        <div>ISBN</div>
        <form:input path="ISBN"></form:input>

        <div>Price</div>
        <form:input path="price"></form:input>

        <div>File Image:</div>
        <form:input type="file" path="fileImage"></form:input>

<%--        <div>Publish Date</div>--%>
<%--        <form:input path="publishDate" type="date"></form:input>--%>

        <div>
            <button type="submit">Submit</button>
        </div>
    </form:form>
</body>
</html>
