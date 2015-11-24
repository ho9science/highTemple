<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${result.subject} :: 사찰이</title>
 <link href="/HighTempler/css/bootstrap.min.css" rel="stylesheet">
 <link href="/HighTempler/css/style.css" rel="stylesheet">
 <link href="/HighTempler/css/hi.css" rel="stylesheet">
 <style>
 #map{
 height: 50%;
 }
 </style>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyAe3S4Hg8O1JwFcZaGN5NcH_aWYRvDNUzQ&signed_in=false"
	async defer></script>
<script>
	window.onload=function geocodeAddress() {

		var map = new google.maps.Map(document.getElementById('map'), {
			zoom : 12,
			center : {
				lat : 37.573290,
				lng : 128.473021
			}
		});
		var geocoder = new google.maps.Geocoder();
		var address = document.getElementById('address').value;
		geocoder.geocode({
			'address' : address
		}, function(results, status) {
			if (status === google.maps.GeocoderStatus.OK) {
				map.setCenter(results[0].geometry.location);
				var marker = new google.maps.Marker({
					map : map,
					position : results[0].geometry.location
				});
			} else {
				alert('해당 이유로 지도불러오는 데 실패하였습니다: ' + status);
			}
		});
	}
</script>
</head>
<body>
<!-- 헤더부분 -->
<jsp:include page="header.jsp"></jsp:include>
<!-- 헤더부분 끝 -->


<div class="col-xs-12 header-img">
	<c:set var="dto" value="${result}"/>
	<div class="col-xs-12">
		<img alt="메인 사진" src="${leftImg[0]}" class="img-rounded img-responsive">
	</div>
	
	<div class="col-xs-12 text-left">
		<h2 class="page-header">${dto.subject}</h2>
	</div>
	
	<div class="col-xs-12 text-left">
		<p><small>${dto.addr}</small></p>
		<input type="hidden" name="address" id="address" value="${dto.addr }">
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
	<div class="col-xs-12 tour-infm form-inline">
		
		<a data-toggle="collapse" href="#infm" aria-expanded="false" aria-controls="infm">
			<h3>여행 정보</h3>
		</a>
		
		<a class="btn btn-nav" data-toggle="collapse" href="#infm" aria-expanded="false" aria-controls="infm">
			펼치기
		</a>
		<div class="collapse" id="infm">
			<p>${dto.tourInfm}</p>
		</div>
	</div>


	<div class="col-xs-12">
		<br>
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
		<br>
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
		<h4>교통 및 등산로 안내</h4>		
		<br>
		<p>${dto.trafficGuide}</p>
		<br>
		<p>${dto.mountiontrail}</p>
		<br>
	</div>



		<div class="col-xs-12">
				<h4 id="submit">위치보기</h4>
			<div class="col-xs-12" id="map"></div>
		</div>
		
	</div>

<div class="col-xs-6 left-img">
<c:set var="leftImg" value="${leftImg}"/>

<c:forEach begin="0" end="${leftImg.size()-1}" step="1" var="step">

<div class="col-xs-12 left-img">
	<a class="thumbnail" data-toggle="modal" data-target="#popleft${step}">
		<img alt="사찰 사진" src="${leftImg[step]}" class="img-rounded img-responsive">
	</a>
</div>

<div class="modal fade" id="popleft${step}" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
      	<a data-dismiss="modal">
      		<img src="${leftImg[step]}" alt="img" class="modal-img"/>
      	</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

</c:forEach>

</div>


<div class="col-xs-6 right-img">
<c:set var="rightImg" value="${rightImg}"/>

<c:if test="${!empty rightImg}">

<c:forEach begin="0" end="${rightImg.size()-1}" step="1" var="step">

<div class="col-xs-12 right-img">
	<a class="thumbnail" data-toggle="modal" data-target="#popright${step}">
		<img alt="사찰 사진" src="${rightImg[step]}" class="img-rounded img-responsive">
	</a>
</div>

<div class="modal fade" id="popright${step}" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
      	<a data-dismiss="modal">
      		<img src="${rightImg[step]}" alt="img" class="modal-img"/>
      	</a>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

</c:forEach>

</c:if>

</div>


<div class="col-xs-12">
	<form action="imageSearch.do">
		<input type="hidden" name="subject" value="${dto.subject }">
		<button type="submit" class="btn btn-nav">사찰 이미지 더보기</button>
	</form>
	<hr>
</div>




<div class="row col-xs-12">
	<br>
	<div class="col-xs-6 col-sm-6">
		<small>등록일:${dto.regDt}</small>
	</div>
	<div class="col-xs-6 col-sm-6">
		<small>수정일:${dto.edtDt}</small>
	</div>
	<br>
</div>
<jsp:include page="footer.jsp"></jsp:include>


<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>