<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h3>성공</h3>

 <c:forEach var="dto" items="${list }">
 	<a href="${dto.link }"><img src="${dto.thumbnail }" alt="${dto.title }"></a>
 </c:forEach>
</body>
</html>