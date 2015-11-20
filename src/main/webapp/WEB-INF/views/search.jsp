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
 <link href="/HighTempler/css/style.css" rel="stylesheet">
 <link href="/HighTempler/css/hi.css" rel="stylesheet">
</head>
<body>

<jsp:include page="header.jsp"></jsp:include>

<c:set var="list" value="${result}"/>

<div class="col-xs-12">
	<h2>검색 결과 : ${list.size()}개</h2>
</div>


<c:if test="${empty list}">

	<div class="col-xs-12 text-center">
		<h3>검색 결과가 없습니다.</h3>
	</div>
</c:if>

<c:forEach var="dto" items="${list}">

<div class="col-xs-6 col-md-4 text-center">
<a href="/HighTempler/content.do?idx=${dto.idx}" class="thumbnail">
	<img alt="${dto.subject} 사진" src="${dto.img}" class="img-rounded img-reponsive">
	${dto.subject}
</a>
</div>

</c:forEach>

<jsp:include page="footer.jsp"></jsp:include>

<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>