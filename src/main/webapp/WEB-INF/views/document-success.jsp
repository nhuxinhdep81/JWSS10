<%--
  Created by IntelliJ IDEA.
  User: lemanh
  Date: 19/05/2025
  Time: 01:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Kết quả Upload</title>
</head>
<body>
<h2>Upload thành công!</h2>

<p><strong>Tiêu đề:</strong> ${document.title}</p>
<p><strong>Mô tả:</strong> ${document.description}</p>

<c:if test="${not empty document.fileUrl}">
    <p><strong>File đã upload:</strong></p>
    <a href="${pageContext.request.contextPath}/${document.fileUrl}" target="_blank">
        Tải về hoặc xem tài liệu
    </a>
</c:if>

<br><br>
<a href="${pageContext.request.contextPath}/document-form">Tải lên tài liệu khác</a>

</body>
</html>

