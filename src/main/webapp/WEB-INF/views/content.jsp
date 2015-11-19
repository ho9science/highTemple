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
 <style type="text/css">
 body{
 	padding-top: 68px;
 }
 .modal-img{
 	width: 100%;
 }
 .header-img{
 	background-color: #3EC9C3;
 	color: white;
 }
 .tour-infm h3{
 	color: #CB5750;
 }
 </style>
</head>
<body>
<!-- 헤더부분 -->
<nav class="navbar navbar-fixed-top menubar">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle menu-button" data-toggle="collapse" data-target="#myNavbar" aria-expanded="true">
			<span class="glyphicon glyphicon-align-justify"></span>
	  </button>
      <a class="navbar-brand logo" href="/HighTempler/home.do">HighTempler</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right navstyle">
        <li><a href="/HighTempler/home.do">Home</a></li>
      </ul>
      <form class="navbar-form navbar-left" role="search" action="search.do">
        <div class="form-group">
          <input type="text" class="form-control" name="query" placeholder="사찰 검색">
        </div>
        <div class="centertext">
        	<button type="submit" class="btn btn-nav">검색</button>
        </div>
      </form>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- 헤더부분 끝 -->


<div class="col-xs-12 header-img">
	<c:set var="dto" value="${result}"/>
	<div class="col-xs-12">
		<img alt="메인 사진" src="${img[0]}" class="img-rounded img-responsive">
	</div>
	
	<div class="col-xs-12 text-left">
		<h2 class="page-header">${dto.subject}</h2>
	</div>
	
	<div class="col-xs-12 text-left">
		<p><small>${dto.addr}</small></p>
	</div>
</div><!-- /.header-img -->

<!-- 모든 사찰에 없는 값이기 때문에 삭제 
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
 -->
<div class="col-xs-12">
	<div class="col-xs-12 tour-infm">
		<h3>여행 정보</h3>
		<p>${dto.tourInfm}</p>
	</div>


	<div class="col-xs-12">
		<h4>이용요금</h4>
		<p>${dto.usefulCharge}</p>
	</div>
	
	<div class="col-xs-12">
		<h4>주차장 이용 정보</h4>
		<p>${dto.carparkUsefullGuide}</p>
	</div>
	
	<div class="col-xs-12">
		<h4>코스정보</h4>
		<p>${dto.courseInfm}</p>
	</div>
	
	
	<div class="col-xs-12">
		<h4>주변정보</h4>
		<p>${dto.surroundingsAttraction}</p>
	</div>
	
	
	<div class="col-xs-12">
		<h4>이용 가이드</h4>
		<p>${dto.usefullGuide}</p>
	</div>
	
	<div class="col-xs-12">
		<dl class="dl-horizontal">
			<dt>개장일:</dt>
			<dd>${dto.runDe}</dd>
			<c:if test="${!empty dto.operTime}">
				<dt>운영 시간:</dt>
				<dd>${dto.operTime}</dd>
			</c:if>
			<c:if test="${!empty dto.runPd}">
				<dt>개장 기간:</dt>
				<dd>${dto.runPd}</dd>
			</c:if>
		</dl>
	</div>
	
	<div class="col-xs-12">
		<br>
		<p>${dto.trafficGuide}</p>
		<br>
		<p>${dto.mountiontrail}</p>
		<br>
	</div>
</div>
<c:set var="imgs" value="${img}"/>

<c:forEach begin="0" end="${imgs.size()-1}" step="1" var="step">

<div class="col-xs-6 col-md-4">
	<a class="thumbnail" data-toggle="modal" data-target="#pop${step}">
		<img alt="사찰 사진" src="${imgs[step]}" class="img-rounded img-responsive">
	</a>
</div>

<div class="modal fade" id="pop${step}" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
      	<a data-dismiss="modal">
      		<img src="${imgs[step]}" alt="img" class="modal-img"/>
      	</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


	
</c:forEach>

<div>
	<hr>
</div>

<footer class="foot">

<div class="row col-xs-12">
	<br>
	<div class="col-xs-12 col-sm-6">
		<small>등록일:${dto.regDt}</small>
	</div>
	<div class="col-xs-12 col-sm-6">
		<small>수정일:${dto.edtDt}</small>
	</div>
	<br>
</div>

</footer>

<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>