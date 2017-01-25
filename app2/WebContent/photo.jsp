<%@ page import="org.church.our.loving.util.StringUtil" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath%>">
	<meta charset="UTF-8">
    <title>My Photos</title>
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
<div class="w3-main" style="margin-left:300px">
  <div class="w3-panel w3-form" style="padding-top: 32px !important;">
    <h1><b>我的相册</b></h1>
  </div>
  <!-- Push down content on small screens --> 
  <div class="w3-hide-large" style=""></div>
  
  <!-- Photo grid -->
  <div class="w3-row">
    <c:out value="${images }" escapeXml="false"></c:out>
    <div class="w3-third">
      <img src="images/natureboy.jpg" style="width:100%" onclick="onClick(this)" alt="A boy surrounded by beautiful nature">
    </div>
    <div class="w3-third">
      <img src="images/girl_mountain.jpg" style="width:100%" onclick="onClick(this)" alt="What a beautiful scenery this sunset">
    </div>
    <div class="w3-third">
      <img src="images/girl.jpg" style="width:100%" onclick="onClick(this)" alt="The Beach. Me. Alone. Beautiful">
    </div>
    <div class="w3-third">
      <img src="images/natureboy.jpg" style="width:100%" onclick="onClick(this)" alt="A boy surrounded by beautiful nature">
    </div>
    <div class="w3-third">
      <img src="images/girl_mountain.jpg" style="width:100%" onclick="onClick(this)" alt="What a beautiful scenery this sunset">
    </div>
    <div class="w3-third">
      <img src="images/girl.jpg" style="width:100%" onclick="onClick(this)" alt="The Beach. Me. Alone. Beautiful">
    </div>
  </div>

  <!-- Pagination -->
  <div class="w3-center w3-padding-32">
    <ul class="w3-pagination">
      <li><a class="w3-black" href="#">1</a></li>
      <li><a class="w3-hover-black" href="#">2</a></li>
      <li><a class="w3-hover-black" href="#">3</a></li>
      <li><a class="w3-hover-black" href="#">4</a></li>
      <li><a class="w3-hover-black" href="#">»</a></li>
    </ul>
  </div>
  
  <!-- Modal for full size images on click-->
  <div id="modal01" class="w3-modal w3-black w3-padding-0" onclick="this.style.display='none'">
    <span class="w3-closebtn w3-text-white w3-opacity w3-hover-opacity-off w3-xxlarge w3-container w3-display-topright">×</span>
    <div class="w3-modal-content w3-animate-zoom w3-center w3-transparent w3-padding-64">
      <img id="img01" class="w3-image">
      <p id="caption"></p>
    </div>
  </div>
</div>
<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>
<script>

// Modal Image Gallery
function onClick(element) {
  document.getElementById("img01").src = element.src;
  document.getElementById("modal01").style.display = "block";
  var captionText = document.getElementById("caption");
  captionText.innerHTML = element.alt;
}
</script>
</body>
</html>
