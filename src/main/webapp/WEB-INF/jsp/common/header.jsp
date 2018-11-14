<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/common/init.jsp" %>

<div class="ui menu">
	<a class="item" href="<c:url value="/main/index.do" />">홈</a>
	<a class="item" href="<c:url value="/board/board.do?board_id=notice" />">공지사항</a>
	<a class="item" href="<c:url value="/board/board.do?board_id=free" />">자유게시판</a>
	<!-- 
	<div class="header item"></div>
	<a class="item">Link</a>
	<div class="ui dropdown item" tabindex="0">
		Dropdown
		<i class="dropdown icon"></i>
		<div class="menu" tabindex="-1">
			<div class="item">Action</div>
			<div class="item">Another Action</div>
			<div class="item">Something else here</div>
			<div class="divider"></div>
			<div class="item">Separated Link</div>
			<div class="divider"></div>
			<div class="item">One more separated link</div>
		</div>
	</div>
	-->
	<div class="right menu">
	<!--
		<div class="item">
			<div class="ui action left icon input">
				<i class="search icon"></i>
				<input type="text" placeholder="Search">
				<button class="ui button">Submit</button>
				<div class="ui teal button">Search</div>
			</div>
		</div>
		<a class="item">Link</a>
	-->
	</div>
</div>