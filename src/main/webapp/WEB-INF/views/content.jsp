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
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/HighTempler/home.do">사찰이 사찰이</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
            <li class="divider"></li>
            <li><a href="#">One more separated link</a></li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search">
        </div>
        <button type="submit" class="btn btn-default">Submit</button>
      </form>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">Link</a></li>
        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Dropdown <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Action</a></li>
            <li><a href="#">Another action</a></li>
            <li><a href="#">Something else here</a></li>
            <li class="divider"></li>
            <li><a href="#">Separated link</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
<!-- 헤더부분 끝 -->

<c:set var="dto" value="${result}"/>
<div class="col-xs-12">
	<img alt="메인 사진" src="${img[0]}" class="img-rounded img-responsive">
</div>

<div class="col-xs-12 text-left"><h2 class="page-header">${dto.subject}</h2></div>

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
	<h3>여행 정보</h3>
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
	<div class="col-xs-6 col-md-4">
		<img alt="사찰 사진" src="${path}" class="img-rounded img-responsive">
	</div>
</c:forEach>



<div class="col-xs-12">
	<br>
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