<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%><%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html");
%>
<nav class="w3-sidenav w3-white w3-animate-left w3-center w3-text-grey w3-collapse w3-top w3-round w3-card-4 " style="z-index:3;width:300px;font-weight:bold" id="mySidenav"><br>
  <!--<h3 class="w3-padding-medium"><b>We're One</b></h3>-->
  <a href = "/app2" >
  <img src="images/icon.jpg" width ="90" alt="We're One"></a>
  <div class="logininfo" style="display:inline-flex;">
  <c:if test="${ empty username }">
  	<a href="login.jsp">请点击登录 ！</a>
  </c:if>
  <c:if test="${not empty username }">
  	<img alt="" src="images/timg.jpg" height="35" > <span style="height:35px; line-height:35px; padding-left:5px;"> 欢迎您， <c:out value="${username }"></c:out>! </span>
  </c:if>
  </div>
  <hr/>
  <a href="javascript:void(0)" onclick="w3_close()" class="w3-padding w3-hide-large">CLOSE</a>
  <a href="index.jsp" onclick="w3_close()" class="w3-padding">主页</a> 
  <a href="photo.do" onclick="w3_close()" class="w3-padding">我的相册</a> 
  <a href="register.jsp" onclick="w3_close()" class="w3-padding">注册个人信息</a> 
  <a href="financial.jsp" onclick="w3_close()" class="w3-padding">财务管理</a> 
  <a href="#about" onclick="w3_close()" class="w3-padding">关于我们</a> 
  <a href="#contact" onclick="w3_close()" class="w3-padding">联系我们</a>
</nav>

<!-- Top menu on small screens -->
<header class="w3-container w3-top w3-hide-large w3-white w3-xlarge w3-padding-8" style="opacity:0.9;">
  <span class="w3-left w3-padding"> <a href="/app2"><img alt="" src="images/favicon.ico" width="30" ></a> <b>&nbsp;We're One</b></span>
  <a href="javascript:void(0)" class="w3-right w3-btn w3-white" onclick="w3_open()" style="background-image:url(images/menu.png); background-size: cover;">&nbsp;&nbsp;&nbsp;</a>
</header>

<!-- Overlay effect when opening sidenav on small screens -->
<div class="w3-overlay w3-hide-large w3-animate-opacity" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>
