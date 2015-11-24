<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>사찰이 사찰이</title>
<link href="/HighTempler/css/bootstrap.min.css" rel="stylesheet">
<link href="/HighTempler/css/style.css" rel="stylesheet">
<link href="/HighTempler/css/hi.css" rel="stylesheet">
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
						</div>
					</div>
				</div>


				<c:choose>
					<c:when test="${!empty list }">
						<c:set var="imgs" value="${list}" />
						<c:forEach begin="0" end="${imgs.size()-1}" step="1" var="step">

							<div class="col-xs-6 col-md-4">
								<a class="thumbnail" data-toggle="modal"
									data-target="#pop${step}"> <img alt="사찰 사진"
									src="${imgs[step].thumbnail}"
									class="img-rounded img-responsive">
								</a>
							</div>

							<div class="modal fade" id="pop${step}" role="dialog"
								aria-hidden="true">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-body">
											<a data-dismiss="modal"> <img
												src="${imgs[step].thumbnail}" alt="img" class="modal-img" />
											</a>
										</div>
									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->

						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="col-xs-12 col-md-12">
							<p id="noneResultImg">이미지 검색결과가 없습니다</p>
						</div>
					</c:otherwise>
				</c:choose>

			</div>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
	<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
	<script src="/HighTempler/js/bootstrap.min.js"></script>

</body>
</html>