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

<c:set var="dto" value="${result}"/>

사찰 이름:${dto.subject}<br>
사찰 주소:${dto.addr}<br>
검색 번호:${dto.idx}<br>
시 이름:${dto.govNm}<br>
문의처:${dto.contact}<br>
홈페이지:${dto.homepage}<br>
여행 정보:${dto.tourInfm}<br>
이용 요금:${dto.usefulCharge}<br>
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

<script src="/HighTempler/js/jquery-2.1.4.min.js"></script>
<script src="/HighTempler/js/bootstrap.min.js"></script>
</body>
</html>