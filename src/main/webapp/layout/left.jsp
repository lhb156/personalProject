<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="col-sm-3 col-md-2 sidebar" style="width: 10%;"> 
  <ul class="nav nav-sidebar">
    <li class="active" style="background: #428bca;"><a href="${pageContext.request.contextPath }/boardEdit?board_kind=1" style="color: #fff;">BOARD CONTROLL<span class="sr-only">(current)</span></a></li>
  
    <input type="hidden" name ="board_kind" value='${board_kind }'>
    <c:forEach items="${kindList }" var="vo">
    
    <c:if test="${vo.board_kind_yn eq 'y'}">
    <li><a href="${pageContext.request.contextPath }/viewExchange?board_kind=${vo.board_kind_seq }" name="board_kind" >${vo.board_kind_nm }</a></li>
    </c:if>
    
    </c:forEach>
 
  </ul>
</div>