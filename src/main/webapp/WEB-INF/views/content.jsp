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
<!-- 헤더부분 -->
<!-- 헤더부분 끝 -->
<c:set var="dto" value="${result}"/>
<div class="col-xs-12">
	<img alt="임시 사진" src="${img[0]}" class="img-rounded img-responsive">
</div>

<div class="col-xs-12 text-center"><h2>${dto.subject}</h2></div>

<div class="col-xs-12 text-right">
	<p><small>${dto.addr}</small></p>
</div>

<div class="row col-xs-12">
	<div class="col-xs-6">
		<label>문의처:</label>
		<c:if test="${!empty dto.contact}">	
			<p>${dto.contact}</p>
		</c:if>
		<c:if test="${empty dto.contact}">
			<p>없음</p>
		</c:if>
	</div>
	
	<div class="col-xs-6">
		<label>홈페이지:</label>
		<c:if test="${!empty dto.homepage}">
			<p>${dto.homepage}</p>
		</c:if>
		<c:if test="${empty dto.homepage}">
			<p>없음</p>
		</c:if>
	</div>
</div>

<br>

<div class="col-xs-12">
	<label>여행 정보:</label>
	<p>${dto.tourInfm}</p>
</div>


<div class="col-xs-12">
	<label>이용 요금:</label>
	<p>${dto.usefulCharge}</p>
</div>

<div class="col-xs-12">
	<label>주차장 이용 정보:</label>
	<p>${dto.carparkUsefullGuide}</p>
</div>

<div class="col-xs-12">
	<label>코스정보:</label>
	
	<c:if test="${!empty dto.courseInfm}">
		<p>${dto.courseInfm}</p>
	</c:if>
	<c:if test="${empty dto.courseInfm}">
		<p>없음</p>
	</c:if>
</div>


<div class="col-xs-12">
	<label>주변정보:</label>
	<p>${dto.surroundingsAttraction}</p>
</div>


<div class="col-xs-12">
	<label>이용 가이드:</label>
	<p>${dto.usefullGuide}</p>
</div>

<div class="col-xs-12">
	개장일:${dto.runDe}<br>
	운영 시간:${dto.operTime}<br>
	개장 기간:${dto.runPd}<br>
</div>

<div class="col-xs-12">
	<br>
	<p>${dto.trafficGuide}</p>
	<br>
	<p>${dto.mountiontrail}</p>
	<br>
</div>



<c:forEach var="path" items="${img}">
	<div class="col-xs-6">
		<img alt="임시 사진" src="${path}" class="img-rounded img-responsive">
	</div>
</c:forEach>

<div class="col-xs-12">
	<small>
		등록일:${dto.regDt} | 
		수정일:${dto.edtDt}
	</small>
	<br>
</div>

<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>