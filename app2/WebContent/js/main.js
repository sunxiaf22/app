
function w3_open() {
    document.getElementById("mySidenav").style.display = "block";
    document.getElementById("myOverlay").style.display = "block";
}
 
function w3_close() {
    document.getElementById("mySidenav").style.display = "none";
    document.getElementById("myOverlay").style.display = "none";
}



$(document).scroll( function () {
	var winHeight = $(window).height();
	var scrollheight = $(window).scrollTop();
	if (scrollheight >= winHeight) {
		$("#toTop").show("slow");
	} else {
		$("#toTop").hide("slow");
	}
});


function readURL(input) {

    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#blah').attr('src', e.target.result);
        }

        reader.readAsDataURL(input.files[0]);
    }
}


function initMap(point){ 
	$("#mapcontainer").html("initMap...");
	map = new BMap.Map("mapcontainer"); 
	map.addControl(new BMap.NavigationControl()); 
	map.addControl(new BMap.ScaleControl()); 
	map.addControl(new BMap.OverviewMapControl()); 
	map.centerAndZoom(point, 15); 
	map.addOverlay(new BMap.Marker(point)) 
} 


function showPosition(position){
	$("#mapcontainer").html("translate point...");
	var currentLat = position.coords.latitude; 
	var currentLon = position.coords.longitude; 
	$("#mapcontainer").html(currentLat + ", " + currentLon);
	var gpsPoint = new BMap.Point(currentLon, currentLat); 
	BMap.Convertor.translate(gpsPoint, 0, initMap); 
} 

function showError (error) {
	
	$("#mapcontainer").html(error);
	
	switch(error.code)
    {
    case error.PERMISSION_DENIED:
      $("#mapcontainer").html("User denied the request for Geolocation.");
      break;
    case error.POSITION_UNAVAILABLE:
      $("#mapcontainer").html("Location information is unavailable.");
      break;
    case error.TIMEOUT:
      $("#mapcontainer").html("The request to get user location timed out.");
      break;
    case error.UNKNOWN_ERROR:
      $("#mapcontainer").html("An unknown error occurred.");
      break;
    }
}

function getPosition() {
	if(navigator.geolocation) { 
		navigator.geolocation.getCurrentPosition(showPosition, showError,{
			  enableHighAcuracy: true,
			  timeout: 5000,
			  maximumAge: 3000
			}); 
		$("#mapcontainer").html("HTML5 Geolocation is supported in your browser.");
	}else {
		$("#mapcontainer").html("HTML5 Geolocation is not supported in your browser.");
	}
}



$(document).ready(function () {
$("#toTop").click (function () {
	$(window).scrollTop(0);
	
});
$("#upload").click (function () {
	$("#innerfile").click();
} );

$("#innerfile").change(function () {
readURL(this);
$('#blah').show();
});
$(".regbtn").click (function () {
	window.location.href = "/app2/register.jsp";
});
var titleV = $("title").html();
var subTitle = $("#nav span").html(titleV);
var pctitle = "<div class=\"w3-panel\" id=\"pconly\"><h3><b>"+titleV+"</b></h3></div>";
$("#main").prepend(pctitle);

getPosition();
});



