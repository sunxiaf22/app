<%@page import="org.church.our.loving.util.StringUtil"%>
<%@page import="org.church.our.loving.constants.IOurChurchConstants"%><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %><%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
response.setContentType("text/html");
String receiveformid = (String) request.getSession().getAttribute(IOurChurchConstants.FORM_ID);
if (StringUtil.isEmpty(receiveformid)) receiveformid = "";
%>

<footer class="w3-light-grey" >
  <p style="color:red;"><c:out value="${msg }"></c:out></p>
  <h4>&nbsp;</h4>
  <!-- 
   <a href="#" class="w3-btn w3-padding w3-black w3-margin "><i class="fa fa-arrow-up w3-margin-right"></i>To the top</a>
   -->
  <div class="w3-xlarge w3-section">
    <i class="fa fa-facebook-official w3-hover-text-indigo"></i>
    <i class="fa fa-instagram w3-hover-text-purple"></i>
    <i class="fa fa-snapchat w3-hover-text-yellow"></i>
    <i class="fa fa-pinterest-p w3-hover-text-red"></i>
    <i class="fa fa-twitter w3-hover-text-light-blue"></i>
    <i class="fa fa-linkedin w3-hover-text-indigo"></i>
  </div>
  <p>&copy; 2016 Sun Xia</p>
  <div id="mapcontainer"></div>
</footer>

<a href ="javascript:void(0);" id="toTop" class="w3-circle" style="line-height: 400%; display:none; position: fixed; opacity: 0.8; width: 60px; height: 60px; z-index: 4; top: 85%; right: 5px; background-color: gray; text-decoration: none; text-align: center; vertical-align: middle;">
	TOP &uarr;
</a>
<script src="js/jquery-1.11.3.js"  type="text/javascript"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=B3bvuW4fSDy7WFMH8DPvpfI1XqQ2kdFi"></script>
<script type="text/javascript" src="js/convertor.js"></script>
<script src="js/main.js"  type="text/javascript"></script>

<script>
$(document).ready(function () {
	var inputhidden = "<input type = 'hidden' name = 'formid' value = '<%= receiveformid %>'>";
	$("form").prepend(inputhidden);
});
</script>