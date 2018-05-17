<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
      	
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>	
            <span class="icon-bar"></span>
          </button>
          <a id=bthBtn" class="navbar-brand" href="${pageContext.request.contextPath }/loginProcess?board_kind=1">Project Board</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Option1</a></li>
            <li><a href="#">Option2</a></li>
            <li><a href="#">Option3</a></li>
            <li><a href="#">Option4</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>