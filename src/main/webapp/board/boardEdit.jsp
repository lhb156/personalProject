<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/layout/css.jsp" %>

<title>Insert title here</title>
<script>
	$(function(){
		$('.editBtn').click(function(){
			var kind_yn = $(this).attr("idx");
			$('#status').val('1');
			$('#kind_yn').val(kind_yn);
			$('#frm').submit();
		})
		
		$('#createBtn').click(function(){
			$('#status').val('0');
			$('#careteBoard').css('display','inline');
		})
		
		$('#okbtn').click(function(){
			$('#frm').submit();
		})
	})
</script>
</head>
<body>
<%@ include file="/layout/header.jsp"%>
<br>
<div class="container-fluid">
	<div class="row">     
		<%@ include file="/layout/editLeft.jsp" %> 
		<form action="${pageContext.request.contextPath }/boardEdit" id="frm" method="post">
			<input type="hidden" id="status"name="status">
			<input type="hidden" id="kind_yn" name="kind_yn">
		 
        <h2 class="sub-header"> NOTICE </h2>
          <div class="table-responsive">
            <table class="table">
              <thead>
                <tr>
                  <th>No</th>
                  <th>Creater</th>
                  <th>Board_Name</th>
                  <th>CreateTime</th>
                  <th>Status</th>
                </tr>
              </thead>
              <tbody id="kindList">
              <c:forEach items="${kindList }" var="vo">
              	<c:choose>
              	<c:when test="${vo.board_kind_yn eq 'y' }">
                <tr class="boardSelect">
                  <td>${vo.board_kind_seq }</td>
                  <td>${vo.create_id }</td>
                  <td>${vo.board_kind_nm }</td>
                  <td><fmt:formatDate value="${vo.board_kind_date }" pattern="yyyy-MM-dd"/></td>
                  <td><input class="editBtn" type="button" class="btn btn-default" value="HIDE" name="hideBtn" idx="${vo.board_kind_seq }"></td>
                </tr>
                </c:when>
                <c:otherwise>
                  <tr class="boardSelect">
                  <td>${vo.board_kind_seq }</td>
                  <td>${vo.create_id }</td>
                  <td>${vo.board_kind_nm }</td>
                  <td><fmt:formatDate value="${vo.board_kind_date }" pattern="yyyy-MM-dd"/></td>
                  <td><input class="editBtn" type="button" class="btn btn-default" value="SHOW" name=showBtn idx=${vo.board_kind_seq }></td>
                </tr>	
                </c:otherwise>
                </c:choose>
              </c:forEach>
              </tbody>
            </table>
          </div>
		  <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-left: 175px;";>
				<input class="btn btn-primary" id="createBtn" type="button" value="게시판 생성"> 
				<br><br>
				<div id = "careteBoard" style="display: none">
					<input  type="text" name="careteBoard" style="width: 250px;" placeholder="생성 할 게시판 이름을 입력해 주세요.">
					<br><br>
					<input class="btn btn-default" id="okbtn" type="button" value="확인">
				</div>
          </div>	
       </form>   
	</div>
</div>	
		
</body>
</html>