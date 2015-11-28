<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${result.subject}:: 사찰이</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/style.css" rel="stylesheet">
<link href="css/hi.css" rel="stylesheet">
<script type="text/javascript" src="//apis.daum.net/maps/maps3.js?apikey=72b97d5dda12848c175cb0f1374dbcb3&libraries=services"></script>
<script>
window.onload=function(){
	var mapContainer = document.getElementById('map'), 
	mapOption = {
		center : new daum.maps.LatLng(37.573290, 128.473021), 
		level : 4

	};
 
	var map = new daum.maps.Map(mapContainer, mapOption);

	//주소-좌표 변환 객체를 생성합니다
	var geocoder = new daum.maps.services.Geocoder();

	var address = document.getElementById('address').value;

	//주소로 좌표를 검색합니다
	geocoder.addr2coord(address, function(status, result) {

		// 정상적으로 검색이 완료됐으면 
		if (status === daum.maps.services.Status.OK) {

			var coords = new daum.maps.LatLng(result.addr[0].lat,
					result.addr[0].lng);

			var moveLatLon = new daum.maps.LatLng(result.addr[0].lat, result.addr[0].lng);
			    	
			map.setCenter(moveLatLon);
		
			var marker = new daum.maps.Marker({
				map : map,
				position : coords
			});
			var subject = document.getElementById('subject').value;
			
			var infowindow = new daum.maps.InfoWindow({
				content : '<div style="padding:5px;">' + subject + '</div>'
			});
			infowindow.open(map, marker);
		}
	});
}
</script>
</head>
<body onload="kakaoStory()">
	<!-- 헤더부분 -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- 헤더부분 끝 -->


	<div class="col-xs-12 header-img">
		<c:set var="dto" value="${result}" />
		<div class="col-xs-12">
			<img alt="메인 사진" src="${headerImg}"
				class="img-rounded img-responsive">
		</div>

		<div class="col-xs-12 text-left">
			<h2 class="page-header">${dto.subject}</h2>
			<ul style="float: right; list-style: none; text-align: right;">
				<li style="list-style: none; float: right; text-align: right;"><p>
						<script type="text/javascript"
							src="//developers.band.us/js/share/band-button.js?v=20151123"></script>
						<script type="text/javascript">
							new ShareBand.makeButton({
								"lang" : "ko",
								"type" : "f",
								"text" : "",
								"withUrl" : false
							});
						</script>
					</p></li>
				<li style="list-style: none; float: right; text-align: right;"><p
						id="kakaostory-share-button"></p></li>
			</ul>
		</div>

		<div class="col-xs-12 text-left">
			<p id="addrP">
				<small>${dto.addr}</small>
			</p>
			<input type="hidden" name="address" id="address" value="${dto.addr }">
			<input type="hidden" name="subject" id="subject" value="${dto.subject }">
		</div>

	</div>
	<!-- /.header-img -->

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

			<a data-toggle="collapse" href="#infm" aria-expanded="false"
				aria-controls="infm">
				<h3>여행 정보</h3>
			</a> <a class="btn btn-nav" data-toggle="collapse" href="#infm"
				aria-expanded="false" aria-controls="infm"> 펼치기 </a>
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
			<div class="col-xs-12" id="map" style="width:370px;"></div>
		</div>

	</div>

	<div class="col-xs-6 left-img">
		<c:set var="leftImg" value="${leftImg}" />

		<c:forEach begin="0" end="${leftImg.size()-1}" step="1" var="step">

			<div class="col-xs-12 left-img">
				<a class="thumbnail" data-toggle="modal"
					data-target="#popleft${step}"> <img alt="사찰 사진"
					src="${leftImg[step]}" class="img-rounded img-responsive">
				</a>
			</div>

			<div class="modal fade" id="popleft${step}" role="dialog"
				aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-body">
							<a data-dismiss="modal"> <img src="${leftImg[step]}"
								alt="img" class="modal-img" />
							</a>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->

		</c:forEach>

	</div>


	<div class="col-xs-6 right-img">
		<c:set var="rightImg" value="${rightImg}" />

		<c:if test="${!empty rightImg}">

			<c:forEach begin="0" end="${rightImg.size()-1}" step="1" var="step">

				<div class="col-xs-12 right-img">
					<a class="thumbnail" data-toggle="modal"
						data-target="#popright${step}"> <img alt="사찰 사진"
						src="${rightImg[step]}" class="img-rounded img-responsive">
					</a>
				</div>

				<div class="modal fade" id="popright${step}" role="dialog"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-body">
								<a data-dismiss="modal"> <img src="${rightImg[step]}"
									alt="img" class="modal-img" />
								</a>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal-dialog -->
				</div>
				<!-- /.modal -->

			</c:forEach>

		</c:if>

	</div>


	<div class="col-xs-12" id="upMap">
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


	<script src="js/jquery-2.1.4.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
	<script src="js/kakaoStory.js"></script>
</body>
</html>