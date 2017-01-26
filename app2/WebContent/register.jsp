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
	<jsp:param value="注册" name="title"/>
</jsp:include>
<body class="w3-light-grey">
<!-- Sidenav/menu -->
<jsp:include page="menu.jsp"></jsp:include>
<!-- Content -->
<div class="w3-content" style="max-width:1100px;margin-bottom:20px" id="main">
  <!-- Contact -->
  <div  class="w3-row-padding w3-card-4 w3-padding-medium w3-round-large w3-padding-bottom">
	  <form class="w3-container" method="POST" enctype="multipart/form-data" action="upload">
	  <input type="hidden" name = "formtype" value = "register">
		<div class="w3-group">
		  <label>姓名</label>
		  <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="username" required>
		</div>
		<div class="w3-group">
		  <label>密码</label>
		  <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="password" required>
		</div>
		<div class="w3-group">
		  <label>邮箱</label>
		  <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="mail" required>
		</div>
		<div class="w3-group">
		  <label>手机</label>
		  <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="phone" required>
		</div>
		<!-- <div class="w3-group">
		  <label>介绍</label>
		  <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="comments">
		</div> -->
		<input type="hidden" name="status" value = "A"/>
		<div class="w3-group">
		  <div class="w3-btn w3-round-xxlarge" id="upload">上传头像</div>
		  <input style="position:absolute; top: 0; left: 0; opacity: 0;" name="headcount" type ="file" id="innerfile">	
		  <br/><img id="blah" width="100" alt="your image" style="display:none; line-height:50%; margin-top: 10px;" />
		</div>
		<button type="submit" class="w3-btn w3-btn-block w3-padding-12 w3-round">提交</button>
	  </form>
  </div>
</div>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
