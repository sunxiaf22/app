<%@ page import="org.church.our.loving.util.StringUtil" %><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp">
	<jsp:param value="登录" name="title"/>
</jsp:include>
<body class="w3-light-grey">
<!-- Sidenav/menu -->
<jsp:include page="menu.jsp"></jsp:include>
<!-- Content -->
<div class="w3-content" style="max-width:1100px;margin-bottom:20px" id="main">
  <div class="w3-panel" id="bigonly" >
    <h1><b>&nbsp;</b></h1>
  </div>
  <!-- Contact -->
  
  <div  class="w3-row-padding w3-card-4 w3-padding-medium w3-round-large w3-padding-bottom">
	  <form class="w3-container" method="POST" action="login.do">
	  	<input type="hidden" name = "formtype" value = "login">
		<div class="w3-group">
		  <label>用户名</label>
		  <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="username" required>
		</div>
		<div class="w3-group">
		  <label>密码</label>
		  <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="password" name="password" required>
		</div>
		<div style="text-align: center;">
		<button type="submit" class="w3-btn w3-padding-12 w3-round">登录</button> &nbsp;|&nbsp;
		<button type="button" class="w3-btn w3-padding-12 w3-round regbtn">注册</button>
		</div>
	  </form>
  </div>
</div>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
