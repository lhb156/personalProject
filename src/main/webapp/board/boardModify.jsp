<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/layout/css.jsp" %>
<!-- Favicon -->
<link rel="shortcut icon" href="favicon.ico" />
<script src="${pageContext.request.contextPath }/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">

var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

$(document).ready(function() {
	// Editor Setting
	nhn.husky.EZCreator.createInIFrame({
		oAppRef : oEditors, // 전역변수 명과 동일해야 함.
		elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
		sSkinURI : "${pageContext.request.contextPath }/SE2/SmartEditor2Skin.html", // Editor HTML
		fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
		htParams : {
			// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseToolbar : true,
			// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,
			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true, 
		}
	});

	// 전송버튼 클릭이벤트
	$("#savebutton").click(function(){
		if(confirm("저장하시겠습니까?")) {
			// id가 smarteditor인 textarea에 에디터에서 대입
			oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []);

			// 이부분에 에디터 validation 검증
			if(validation()) {
				$("#editBtn").val("확인");
				$("#frm").submit();
			}
		}
	})
});

// 필수값 Check
function validation(){
	var contents = $.trim(oEditors[0].getContents());
	if(contents === '<p>&nbsp;</p>' || contents === ''){ // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
		alert("내용을 입력하세요.");
		oEditors.getById['smarteditor'].exec('FOCUS');
		return false;
	}

	return true;
}

</script>
<style>
	#write{
		margin-left: 10%;
	}
	.writeBtn{
		margin-left: 23%;
	}
</style>
</head>
<body>
<%@ include file="/layout/header.jsp"%>
<br>	
	<div class="container-fluid">
	<form action="${pageContext.request.contextPath}/boardWrite" method="get" id="frm">
	<div class="row">     
	<%@ include file="/layout/left.jsp" %> 
	<div id="write">
	<h2><p>Modify Board</p></h2>
	<br><br>
	
	<h4>제목 : <input type="text" name="edit_title" value="${boardVO.board_title }"></h4>
	<br>
	<textarea name="smarteditor" id="smarteditor" rows="10" cols="100" style="width:766px; height:412px;">${boardVO.board_content}</textarea> 
		<input type="hidden" name="board_kind" value="${board_kind }">
		<input type="hidden" name="smarteditor" value="${boardVO.board_content }">
		<input type="hidden" name="board_seq" value="${boardVO.board_seq }">
		<input id="editBtn" type="hidden" name="editBtn">
	</div>
	<br><br>
		<div class="writeBtn" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-left: 510px;">
			<input class="btn btn-default" type="button" id="savebutton" value="확인" /> &nbsp; <input class="btn btn-default" type="button" value="취소"> 
    	</div>
    </div>
    </form>
</div>
</body>
</html>