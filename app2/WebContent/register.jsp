<%@ page import="org.church.our.loving.util.StringUtil" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<meta charset="UTF-8">
    <title>个人信息注册</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<link rel="icon" href="images/favicon.ico" type="image/x-icon">
	<link rel="stylesheet" href="css/w3.css">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="images/w3.css" type="text/css">
	<style>
	html,body,h1,h2,h3,h4 {font-family:Verdana, sans-serif}
	.mySlides {display:none}
	.w3-tag, .fa {cursor:pointer}
	.w3-tag {height:15px;width:15px;padding:0;margin-top:6px}
	.fa-arrow-circle-right:before {
	    content: ">>";
	}
	.fa-arrow-circle-left:before {
	    content: "<<";
	}
	@media (max-width:992px){ 
		#main  {
			margin-top: 20%;
		}
	}
	@media (min-width:993px){ 
		#main, footer {
			margin-left: 25%;
		}
	}
	</style>
</head>	
<body class="w3-light-grey">
<!-- Sidenav/menu -->
<jsp:include page="menu.jsp"></jsp:include>
<!-- Content -->
<div class="w3-content" style="max-width:1100px;margin-bottom:20px" id="main">
  <div class="w3-panel">
    <h1><b>&nbsp;</b></h1>
  </div>
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
