
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
var subTitle = $("body h1 b").html(titleV);
});