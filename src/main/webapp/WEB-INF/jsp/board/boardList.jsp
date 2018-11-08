<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/init.jsp" %>
<%@ include file="/WEB-INF/jsp/common/cache.jsp" %>

<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
</head>

<body>
<div class="ui container">
	<c:import url="/WEB-INF/jsp/common/header.jsp" />
	
	<div class="column">
		<table class="ui celled selectable center aligned table">
			<colgroup>
				<col width="7%">
				<col width="*%">
				<col width="15%">
				<col width="15%">
			</colgroup>
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<c:forEach items="${ boardList }" var="list">
						<td>${ list.NO }</td>
						<td class="left aligned" style="cursor:pointer;">${ list.TITLE }</td>
						<td>${ list.ID }</td>
						<td>${ list.HITS }</td>
					</c:forEach>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="4">
						<div class="ui centerb pagination menu">
							<a class="icon item"><i class="left chevron icon"></i></a>
							<a class="item">1</a>
							<a class="item">2</a>
							<a class="item">3</a>
							<a class="item">4</a>
							<a class="icon item"><i class="right chevron icon"></i></a>
						</div>
					</th>
				</tr>
			</tfoot>
		</table>
	</div>
</div>
</body>
</html>
