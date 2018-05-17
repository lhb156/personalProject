<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/layout/css.jsp" %>

<style>
	#write{
		margin-left: 10%;
	}
	.writeBtn{
		margin-left: 23%;
	}
</style>

<script>
	$(function(){
		var yn = '${yn}';
		
		if(yn == "NO"){
			$('#modifyBtn').css('display',' none');
			$('#deleteBtn').css('display',' none');
		}
		$('#nReg_id').click(function(){
			
		})
		
		$('#replyWrtie').click(function(){
			$('#frm').attr('method','get');
			$("#editBtn").val("등록");
			$('#frm').submit();
			
		})
		$('#reWrite').click(function(){
			$('#frm').attr('method','get');
			$("#editBtn").val("답글");
			$('#frm').submit();
		})
		
		
		$('.reg_id').click(function(){
			$('#frm').attr('method','get');
			if( $(this).val() == "수정"){
				$('#editBtn').val("수정");
			}else if($(this).val() == "삭제"){
				$("#editBtn").val("삭제");
			}
			
			$('#frm').submit();
		})
	})
</script>
</head>
<body>
<%@ include file="/layout/header.jsp"%>
<br>	
<div class="container-fluid" >
	<form action="${pageContext.request.contextPath }/boardWrite" method="post" id="frm">
		<div class="row">     
			<%@ include file="/layout/left.jsp" %> 
			<h2><p>Board View</p></h2>
			
			<div id="view" class="panel panel-default" style="margin-left: 190px; width: 800px;" >
				<div class="panel-heading" ><label name="new_subject" style="width: 550px;"><h4>제목 : ${boardVO.board_title }</h4></label></div>
				<div class="panel-body">
				<h4> 내용 :  </h4>
				<input type="hidden" name="edit_subject">
				<input type="hidden" name="smarteditor" value='${boardVO.board_content }'>
				<input type="hidden" name="board_seq" value="${boardVO.board_seq }">
				<input type="hidden" name="edit_title" value="${boardVO.board_title }">
				<input type="hidden" name="group_seq" value="${boardVO.group_seq }">
				<input type="hidden" name="pboard_seq" value="${boardVO.pboard_seq }">
				<input id="editBtn" type="hidden" name="editBtn">
				<div>
				${boardVO.board_content }
				</div>
				</div>
				<br><br>
				<input type="hidden" name="board_kind" value="${board_kind }">
				<br>
			</div>
			
			<div class="writeBtn" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-left: 190px;">
				<input id="nReg_id" class="btn btn-default" type="button" id="okBtn" value="확인"> 
				<input class="btn btn-default" class="reg_id"  type="button" id="modifyBtn" value="수정" style="margin-left: 560px;"  /> &nbsp; 
				<input class="btn btn-default" class="reg_id"  type="button" id="deleteBtn" value="삭제" 	>
				<input class="btn btn-default" id="reWrite"  type="button" value="답글" style="float: right;margin-right: 930px;">
			</div>
			<br><br>
			<div class="writeBtn" class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-left: 190px; width: 793px; height: 60px; ">
				<textarea id="replytxt" rows="2" cols="101" style="height: 46px;vertical-align: middle;"></textarea> <input id="replyWrtie"class="btn btn-default"  type="button" value="등록" style="text-align: right; height: 46px;vertical-align: middle;" >
		   	</div>
	   		<div class="panel panel-default" style="margin-left: 188px;width: 800px;">
	   		<table class="table table-hover">
			   <thead>
			     <tr>
			       <th>Writer</th>
			       <th>Content</th>
			       <th>WriteDate</th>	
			       <th></th>
			     </tr>
			   </thead>
			   <tbody id="reqly">
			     <tr>
			       <td>John</td>
			       <td>Doe</td>
			       <td>john@example.com</td>
			       <td><input type="button" class="btn btn-default" value="삭제"></td>
			     </tr>
			   </tbody>
			 </table>
		   		</div>
		  	</div>
	</form>  	
</div>
</body>
</html>