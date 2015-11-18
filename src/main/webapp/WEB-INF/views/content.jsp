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
<div class="col-sm-12">
	<img alt="임시 사진" src="${img[0]}" class="img-rounded img-responsive">
</div>

<div class="col-sm-12 text-center"><h2>${dto.subject}</h2></div>

<div class="col-sm-12 text-right">
	<p><small>${dto.addr}</small></p>
</div>

<c:if test="${!empty dto.contact}">
	<div class="col-sm-12">
		<p>문의처:${dto.contact}</p>
	</div>
</c:if>
<c:if test="${empty dto.contact}">
	<div class="col-sm-12">문의처가 없습니다.</div>
</c:if>

<c:if test="${!empty dto.homepage}">
	<div class="col-sm-12">
		<p>홈페이지:${dto.homepage}</p>
	</div>
</c:if>
<c:if test="${empty dto.homepage}">
	<div class="col-sm-12">홈페이지가 없습니다.</div>
</c:if>

<br>

<div class="col-sm-12">
<label>여행 정보:</label>
<p>${dto.tourInfm}</p>
</div>


<div>이용 요금:
	<p>${dto.usefulCharge}</p>
</div>


주차장 이용 정보:${dto.carparkUsefullGuide}<br>
코스정보:${dto.courseInfm}<br>
주변정보:${dto.surroundingsAttraction}<br>
이용 가이드:${dto.usefullGuide}<br>
개장일:${dto.runDe}<br>
운영 시간:${dto.operTime}<br>
개장 기간:${dto.runPd}<br>
교통안내:${dto.trafficGuide}<br>
등산로:${dto.mountiontrail}<br>
등록일:${dto.regDt}<br>
수정일:${dto.edtDt}<br>

<c:forEach var="path" items="${img}">
	<img alt="임시 사진" src="${path}" class="img-rounded img-responsive">
</c:forEach>

<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>