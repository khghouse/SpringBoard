<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/init.jsp" %>
<%@ include file="/WEB-INF/jsp/common/cache.jsp" %>

<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
	
	<script>
		$(function()
		{
			if('${ scriptMessage }'.length > 0)
			{
				alert('${ scriptMessage }');
			}
			
			// 등록 폼
			$("#id_btn_reg").click(function()
			{
				$("#id_hid_mode").val("I");
				$("#id_frm_board_form").submit();
			});
			
			// 상세화면
			$("td[name=td_title]").click(function()
			{
				$("#id_frm_board #id_hid_mode").val("V");
				$("#id_frm_board  #id_hid_no").val($(this).data("no"));
				$("#id_frm_board").submit();
			});
		});
	</script>
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
				<c:forEach items="${ boardList }" var="list">
					<tr>
						<td>${ list.STEP eq 0 ? list.NO : '' }</td>
						<td class="left aligned" name="td_title" data-no="${ list.NO }" style="cursor:pointer;">
							<c:if test="${ list.STEP > 0 }">
								<c:forEach begin="0" end="${ list.STEP }">&nbsp;&nbsp;</c:forEach>ㄴ&nbsp;
							</c:if>
							${ list.TITLE }
						</td>
						<td>${ list.ID }</td>
						<td>${ list.HITS }</td>
					</tr>
				</c:forEach>
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
	
	<c:if test="${ userRegYn eq 'Y' }">
		<div class="column" style="margin-top:5px;">
			<button class="ui blue button" id="id_btn_reg">글 등록</button>
		</div>
	</c:if>
</div>

<form id="id_frm_board_form" method="post" action='<c:url value="/board/boardForm.do" />'>
	<input type="hidden" name="board_id" value="${ boardId }" />
	
	<input type="hidden" name="mode" id="id_hid_mode" value="" />
</form>

<form id="id_frm_board" method="post" action='<c:url value="/board/board.do" />'>
	<input type="hidden" name="board_id" value="${ boardId }" />
	<input type="hidden" name="no" id="id_hid_no" value="" />
	
	<input type="hidden" name="mode" id="id_hid_mode" value="" />
</form>

</body>
</html>
