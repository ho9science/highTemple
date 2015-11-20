<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
 <jsp:include page="header.jsp"></jsp:include>
	<div class="gallery" id="gallery">
		<div class="container">
			<div class="row">
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="alldesc">
						<div class="col-md-6 col-sm-6 col-xs-12 centertext">
							<p class="all-td">사찰이 사찰이</p>
							<h2>네이버 이미지 검색</h2>
						</div>
					</div>
				</div>
				
				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="galleryimg" id="galleryimg">
						<c:forEach var="dto" items="${list }" varStatus="status">
							<div
								class="grid mix category-1 col-md-6 col-sm-6 col-xs-6"
								data-myorder="${status.count }" style="display: inline-block;">
								<figure class="effect-Beauty">
									<img src="${dto.thumbnail }" alt="img13"
										class="img-rounded img-responsive">
									<figcaption>
										<h2>${dto.title }</h2>
										
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
</body>
</html>