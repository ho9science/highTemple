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
	<div class="container-fluid banner text-center" id="banner"
		style="height: 498px;">
		<div class="row">
			<div class="col-md-12 line">
				<div class="tablebox">
					<div class="banner-text" id="bannertext" style="height: 498px;">
						<h1 class="hostyle" id="heads">사찰이&#013;사찰이</h1>
						<p class="pstyle">Dev.HighTempler</p>
						<a href="#features" class="page-scroll arrow active"> <i
							class="fa fa-angle-down"></i>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="header.jsp"></jsp:include>
	<div class="gallery" id="gallery">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="alldesc">
						<div class="col-md-6 col-sm-6 col-xs-12 centertext">
							<p class="all-td">사찰이 사찰이</p>
							<h2>Looking for</h2>
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
						<c:forEach var="dto" items="${list }" varStatus="status">
							<div
								class="grid mix category-${(dto.idx)%2+1 } col-md-6 col-sm-6 col-xs-6"
								data-myorder="${status.count }" style="display: inline-block;">
								<figure class="effect-Beauty">
									<img src="${dto.img }" alt="img13"
										class="img-rounded img-responsive"
										style="width: 250px; height: 180px;">
									<figcaption>
										<h2>${dto.subject }</h2>
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
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	<script src="/HighTempler/js/jquery.min.js"></script>
	<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>