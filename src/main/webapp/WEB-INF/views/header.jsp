<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- 헤더부분 -->
<nav class="navbar navbar-fixed-top menubar">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle menu-button" data-toggle="collapse" data-target="#myNavbar" aria-expanded="true">
			<span class="glyphicon glyphicon-align-justify"></span>
	  </button>
      <a class="navbar-brand logo" href="home.do">사찰이</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right navstyle">
        <li><a href="home.do">Home</a></li>
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