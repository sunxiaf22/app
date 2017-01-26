<%@ page import="org.church.our.loving.util.StringUtil" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
request.setCharacterEncoding("utf-8"); 
%>
<!DOCTYPE html>
<html>
<jsp:include page="header.jsp">
	<jsp:param value="出错了" name="title"/>
</jsp:include>
<body class="w3-light-grey">
<!-- Sidenav/menu -->
<jsp:include page="menu.jsp"></jsp:include>
<!-- Content -->
<div class="w3-content" style="max-width:1100px;margin-bottom:20px" id="main"  style="text-align: center;">
  <div class="w3-panel">
    <h1><b>&nbsp;</b></h1>
  </div>
  <img alt="Error" src="images/timg_error2.jpg"/>
<p>
<button name ="btn1" class="w3-btn w3-padding-12 w3-round" onclick="javascript: window.location.href='index.jsp'">返回首页</button>
</p>
</div>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
