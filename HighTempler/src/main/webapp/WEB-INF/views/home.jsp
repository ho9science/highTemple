<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<h1>Wellcome</h1>

<form action="content.do">
	<input type="text" name="idx" placeholder="사찰 IDX" required="required">
	<button type="submit">사찰 정보보기</button>
</form>

<form action="search.do">
	<input type="text" name="query" placeholder="사찰 이름" required="required">
	<button type="submit">사찰 검색하기</button>
</form>

<a>전체 사찰 목록</a>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>