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
			$("#id_btn_reg").click(function()
			{
				if(isValidation())
				{
					$("#id_frm_board").submit();
				}
			});
		});
		
		function isValidation()
		{
			if(!checkId($("#id_hid_id")))
			{
				return false;
			}
			if(!checkPwd($("#id_hid_pwd")))
			{
				return false;
			}
			if(!checkEmpty($("#id_hid_title"), "제목을"))
			{
				return false;
			}
			if(!checkEmpty($("#id_txtarea_contents"), "내용을"))
			{
				return false;
			}
			
			return true;
		}
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
					<div class="field" style="width:80%;">
						<!-- 로그인 기능이 구현된다면 수정 -->
						<label>작성자 정보</label>
						<div class="two fields">
							<div class="field">
								<div class="ui input"><input type="text" name="id" id="id_hid_id" placeholder="아이디"></div>
							</div>
							<div class="field">
								<div class="ui input"><input type="password" name="pwd" id="id_hid_pwd" placeholder="패스워드"></div>
							</div>
						</div>
					</div>
					
					<div class="field" >
						<label>제 목</label>
						<div class="ui input" style="width:80%;"><input type="text" name="title" id="id_hid_title" placeholder="제목을 입력해주세요."></div>
					</div>
					
					<div class="field" >
						<label>내 용</label>
						<textarea class="error" style="width:80%;" name="contents" id="id_txtarea_contents" placeholder="내용을 작성해주세요."></textarea>
					</div>
				</div>
			</div>
		</div>
	</form>
	
	<div class="column" style="margin-top:5px;">
		<button class="ui blue button" id="id_btn_reg">등록하기</button>
	</div>
</div>
</body>
</html>
