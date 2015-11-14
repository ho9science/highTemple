<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
 <link href="/HighTempler/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<c:set var="list" value="${result}"/>

<c:forEach var="dto" items="${list}">
<a href="/HighTempler/content.do?idx=${dto.idx}">사찰 이름:${dto.subject}</a><br>
<br>
</c:forEach>


<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>