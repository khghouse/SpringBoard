<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/jsp/common/init.jsp" %>
<%@ include file="/WEB-INF/jsp/common/cache.jsp" %>

<html>
<head>
	<%@ include file="/WEB-INF/jsp/common/head.jsp" %>
	<script type="text/javascript" src="<c:url value='/docs/js/validation.js' />"></script> 
	
	<script>
		$(function()
		{
			// 등록 폼
			$("#id_btn_reg").click(function()
			{
				$("#id_frm_board_form").submit();
			});
		});
		
	</script>
</head>

<body>
<div class="ui container">
	<c:import url="/WEB-INF/jsp/common/header.jsp" />
	
	<form id="id_frm_board" method="post" action="<c:url value="/board/board.do" />">
		<input type="hidden" name="board_id" value="${ boardId }" />
		<input type="hidden" name="mode" value="I" />
		
		<div class="ui placeholder segment">
			<div class="column">
				<div class="ui form">
					<div class="two fields">
						<div class="field" style="font-weight:bold;">${ boardMap.TITLE }</div>
						<div class="field" style="text-align:right; color:gray;">조회 : ${ boardMap.HITS } &nbsp;|&nbsp; ${ boardMap.REG_DATE }</div>
					</div>
					
					<div style="border-top:1px solid #CCE2FF;"></div>
					
					<div class="field" style="margin-top:5px; margin-left:7px; color:gray;">${ boardMap.ID }</div>
					
					<div class="field" style="margin-top:40px; margin-left:10px; font-size:14px; min-height:300px;">${ boardMap.CONTENTS }</div>
				</div>
			</div>
		</div>
	</form>
	
	<div class="column" style="margin-top:5px;">
		<button class="ui blue button" id="id_btn_reg">답글쓰기</button>
	</div>
</div>

<form id="id_frm_board_form" method="post" action='<c:url value="/board/boardForm.do" />'>
	<input type="hidden" name="board_id" value="${ boardId }" />
	
	<input type="hidden" name="group_id" value="${ boardMap.GROUP_ID }" />
	<input type="hidden" name="step" value="${ boardMap.STEP + 1 }" />
	<%-- <input type="hidden" name="seq" value="${ boardMap.SEQ }" /> --%>
	<input type="hidden" name="u_no" value="${ boardMap.NO }" />
	
	<input type="hidden" name="mode" id="id_hid_mode" value="R" />
</form>

</body>
</html>
