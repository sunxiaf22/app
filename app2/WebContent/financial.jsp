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
    <title>财务管理系统</title>
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
		  <label>类型 :&nbsp; </label>
		  <input class="w3-border w3-hover-border-black" type="radio" name="type" value="O" required checked> (支出) &nbsp;&nbsp;
		  <input class="w3-border w3-hover-border-black" type="radio" name="type" value="I" required> (收入)
		</div>
		<div class="w3-group">
		  <label>栏目</label>
		  <select id="item_o" class="w3-input w3-border w3-hover-border-black" style="width:100%;" name="shoppingitem" required>
		  <option value="1">日用品</option>
		  <option value="2">食品</option>
		  <option value="3">衣物</option>
		  <option value="4">娱乐</option>
		  <option value="5">交通</option>
		  <option value="6">学习用品</option>
		  <option value="7">其他</option>
		  </select>
		</div>
		<div class="w3-group">
		  <label>金额</label>
		  <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="number" name="shoppingcount" required>
		</div>
		<div class="w3-group">
		  <label>备注</label>
		  <input class="w3-input w3-border w3-hover-border-black" style="width:100%;" type="text" name="shoppingComments" required>
		</div>
		<button type="submit" class="w3-btn w3-btn-block w3-padding-12 w3-round">提交</button>
	  </form>
  </div>
</div>

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
