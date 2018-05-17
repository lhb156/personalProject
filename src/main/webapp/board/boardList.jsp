<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>
    
    <!-- jQuery cdn -->
    <script src="https://code.jquery.com/jquery-3.3.1.js"integrity="sha256-2Kok7MbOyxpgUVvAk/HJ2jigOSYS2auK4Pfzbm7uH60="crossorigin="anonymous"></script>
    
    <!-- 합쳐지고 최소화된 최신 자바스크립트 -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

	<!-- 외부 CSS -->
    <link href="${pageContext.request.contextPath }/css/signin.css" rel="stylesheet">

	<!-- 합쳐지고 최소화된 최신 CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script>
	$(function(){	
		$('tr.boardSelect').click(function(){
			var board_seq = $(this).find('td:eq(0)').text();
// 			var reg_id = $(this).find('td:eq(1)').text();
			$('#board_seq').val(board_seq);
// 			$('#reg_id').val(reg_id);
			
			$('#frm').submit();
		})
		$('#writeBtn').click(function(){
			$('#frm').attr('method','post');
			$('#frm').submit();
		})
	})
</script>
<style>
  	tbody tr:hover{
    	background : skyblue;
    }
    thead tr{
    	background : lightgray;
    }
</style>
</head>
<body>

	<%@ include file="/layout/header.jsp"%>
	<br>	
    <div class="container-fluid">
    
      <div class="row">
        
		<%@ include file="/layout/left.jsp" %> 
		
		<form action="${pageContext.request.contextPath }\viewContent" id="frm">
			<input type="hidden" id="board_seq" name="board_seq">
	        <input type="hidden" name="board_kind" value="1">
			<input type="hidden" name="reg_id">
        <h2 class="sub-header"> NOTICE </h2>
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th>No</th>
                  <th>Writer</th>
                  <th>Subject</th>
                  <th>WriteTime</th>
<!--                   <th>Content</th> -->
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${list }" var="vo">
              <c:choose>
              	<c:when test="${vo.del_yn eq 'Y'}">
              	<tr class="boardSelect">
              		<td>${vo.board_seq }</td>
              		<td></td>
              		<td>삭제된 게시물입니다.</td>
              		<td></td>
              	</tr>
              	</c:when>
              	
              	<c:otherwise>
                <tr class="boardSelect">
                  <td>${vo.board_seq }</td>
                  <td>${vo.reg_id }</td>
                  <td>${vo.board_title }</td>
                  <td><fmt:formatDate value="${vo.reg_dt }" pattern="yyyy-MM-dd"/></td>
                </tr>
                </c:otherwise>
                </c:choose>
                </c:forEach>
              </tbody>
            </table>
          </div>
       		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-left: 175px;";>
				<input class="btn btn-default" id="writeBtn" type="button" value="새 글쓰기">
        	</div>
        </form>
      </div>
    </div>

  </body>
</html>