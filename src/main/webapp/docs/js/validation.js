/**
 * 		CH001	2018-11-16		아이디 체크
 * 		CH002	2018-11-16		패스워드 체크
 * 		CH003	2018-11-16		input 공백 체크
 */

// CH001
function checkId($obj)
{
	var regExp = /^[a-zA-Z0-9]{4,12}$/;
	
	if($obj.val() == "" || $obj.val().length <= 0)
	{
		alert("아이디를 입력해주세요.");
		$obj.focus();
		return false;
	}
	
	if(!$obj.val().match(regExp))
	{
		alert("영문, 숫자만 허용하며 4~12자리 이내로 아이디를 입력해주세요.");
		$obj.focus();
		return false;
	}
	
	return true;
}

// CH002
function checkPwd($obj)
{
	var regExp = /^[a-zA-Z0-9]{6,15}$/;
	
	if($obj.val() == "" || $obj.val().length <= 0)
	{
		alert("비밀번호를 입력해주세요.");
		$obj.focus();
		return false;
	}
	
	if(!$obj.val().match(regExp))
	{
		alert("영문, 숫자만 허용하며 6~15자리 이내로 비밀번호를 입력해주세요.");
		$obj.focus();
		return false;
	}
	
	return true;
}

// CH003
function checkEmpty($obj, strCate)
{
	if($.trim($obj.val()) == "" || $.trim($obj.val()).length <= 0)
	{
		alert(strCate+" 입력해주세요.");
		$obj.focus();
		return false;
	}
	
	return true;
}