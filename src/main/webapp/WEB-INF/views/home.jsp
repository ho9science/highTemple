<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>사찰이 사찰이</title>
<link href="/HighTempler/css/bootstrap.min.css" rel="stylesheet">
<link href="/HighTempler/css/style.css" rel="stylesheet">
</head>
<body>
	<h1>안녕</h1>
	<div class="gallery" id="gallery">
	<div class="container">
		<div class="row">
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="alldesc">
					<div class="col-md-6 col-sm-6 col-xs-12 centertext">
						<p class="all-td">사찰이 사찰이</p>
						<h2>Gallery</h2>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12"></div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="sorting pull-left">
					<div class="filter pull-left filimg active" data-filter="all">ShowAll</div>
					<div class="filter pull-left filimg" data-filter=".category-1">인기</div>
					<div class="filter pull-left filimg" data-filter=".category-2">추천</div>
				</div>
			</div>
			<div class="col-md-12 col-sm-12 col-xs-12">
				<div class="galleryimg" id="galleryimg">
					<c:forEach var="dto" items="${list }">
						<div class="grid mix category-2 col-md-6 col-sm-6 col-xs-6"
						data-myorder="1" style="display: inline-block;">
						<figure class="effect-Beauty">
							<img src="${dto.img }" alt="img13" class="img-rounded img-responsive">
							<figcaption>
								<h2>
									${dto.subject }
								</h2>
								<p>${dto.govNm }</p>
								<a href="content.do?idx=${dto.idx}">View more</a>
							</figcaption>
						</figure>
					</div>
					</c:forEach>					
				</div>
			</div>
		</div>
	</div>
	</div>
	<form action="content.do">
		1~41번의 사찰 정보를 확인 가능<br> <input type="text" name="idx"
			class="form-control" placeholder="사찰 IDX" required="required">
		<button type="submit" class="btn btn-primary">사찰 정보보기</button>
	</form>

	<form action="search.do">
		사찰 이름으로 검색<br> <input type="text" name="query"
			class="form-control" placeholder="사찰 이름" required="required">
		<button type="submit" class="btn btn-primary">사찰 검색하기</button>
	</form>

	<form action="imageSearch.do">
		사찰 이름으로 이미지 검색<br> <input type="text" name="subject"
			class="form-control" placeholder="사찰 이름" required="required">
		<button type="submit" class="btn btn-primary">사찰 이미지 검색하기</button>
	</form>

	<a href="listall.do"><button class="btn btn-primary">전체 사찰
			목록</button></a>

	<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
	<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>