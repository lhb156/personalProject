<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
 <%@ include file="/layout/css.jsp" %>
<script>
	$(function(){
		
		$('#boardList tr').click(function(){
			var board_seq = $(this).find('td:eq(0)').text();
			
			$('#board_seq').val(board_seq);
			if($(this).find('td:eq(2)').text() != '삭제된 게시물입니다.'){
				$('#frm').submit();
			}
			
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
       <form action="${pageContext.request.contextPath }/viewContent" id="frm">
       
       <input type="hidden" id="board_seq" name="board_seq">
       <input type="hidden" name="board_kind" value="${board_kind }">
       <input type="hidden" name="pbrod_seq" value="">
       <input type="hidden" name="reg_id">
        <h2 class="sub-header"> ${board_kind_nm } </h2>
        
          <div class="table-responsive" style="height: 427px;">
          
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
              <tbody id=boardList>
              
              <c:forEach items="${list }" var="vo">
              <c:choose>
              	<c:when test="${vo.del_yn eq 'y'}">
              	<tr class="boardSelect">
              		<td>${vo.board_seq }</td>
              		<td></td>
              		<td>삭제된 게시물입니다.</td>
              		<td></td>
              	</tr>
              	</c:when>
              	<c:otherwise>
                <tr class="boardSelect">
                  <td style="width: 100px">${vo.board_seq }</td>
                  <td style="width: 300px">${vo.reg_id }</td>
                  <td style="width: 1000px">${vo.board_title }</td>
                  <td style="width: 328px"><fmt:formatDate value="${vo.reg_dt }" pattern="yyyy-MM-dd"/></td>
                </tr>
                </c:otherwise>
                </c:choose>
                </c:forEach>
              </tbody>
            </table>
          </div>
          
        	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main" style="margin-left: 175px;";>
        	${pageNav }
				<input class="btn btn-default" id="writeBtn" type="button" value="새 글쓰기">
        	</div>
        </form>
      </div>
    </div>

  </body>
</html>