<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
 <%@ include file="/layout/css.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%@ include file="/layout/header.jsp"%>
	<br>	
    <div class="container-fluid">
      <div class="row">
       <%@ include file="/layout/left.jsp" %> 
       
       	<div>
    		<h2>Personal Project Board</h2>
    		<br><br>
    		<img src="${pageContext.request.contextPath }/img/ryan.jpg" alt="라이언 사진"/>
    	</div>
       </div>
    </div>
</body>
</html>