<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 18/05/2025
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Them san pham</title>
</head>
<body>
  <form:form modelAttribute="product" action="product-save"
          method="post">
    <div>Ten san pham: </div>
    <form:input path="name"></form:input>

    <div>Gia san pham: </div>
    <form:input path="price"></form:input>

    <div>Mo ta san pham: </div>
    <form:input path="description"></form:input>

    <button type="submit">Them san pham</button>
  </form:form>
</body>
</html>
