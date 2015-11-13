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
	1~41 까지의 사찰 정보를 확인 가능<br>
	<input type="text" name="idx" class="form-control" placeholder="사찰 IDX" required="required">
	<button type="submit" class="btn btn-primary">사찰 정보보기</button>
</form>

<form action="search.do">
	사찰 이름으로 검색<br>
	<input type="text" name="query" class="form-control" placeholder="사찰 이름" required="required">
	<button type="submit" class="btn btn-primary">사찰 검색하기</button>
</form>

<a href="listall.do"><button class="btn btn-primary">전체 사찰 목록</button></a>

<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>