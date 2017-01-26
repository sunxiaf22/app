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
    <title>出错了</title>
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
<div class="w3-content" id="main">
  <div class="w3-panel">
    <h1><b>&nbsp;</b></h1>
  </div>
  <img alt="Error" src="images/timg_error2.jpg"/>
</div>
<p>
<button name ="返回首页" onclick="javascript: window.location.href='index.jsp'">返回首页</button>
</p>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
