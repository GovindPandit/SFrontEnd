<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<meta name="description" content="Made with WOW Slider - Create beautiful, responsive image sliders in a few clicks. Awesome skins and animations. Slider jquery" />
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Start WOWSlider.com HEAD section --> <!-- add to the <head> of your page -->
	<link rel="stylesheet" type="text/css" href="<sp:url value='engine1/style.css'></sp:url>" />
	<script type="text/javascript" src="<sp:url value='engine1/jquery.js'></sp:url>"></script>
	<!-- End WOWSlider.com HEAD section -->
</head>
<body>
	
	<!-- Start WOWSlider.com BODY section --> <!-- add to the <body> of your page -->
	<div id="wowslider-container1" class="col-lg-10 col-md-10 col-sm-10" >
	<div class="ws_images"><ul>
		<li><img src="<sp:url value='images/pizza2.jpg'></sp:url>" alt="pizza2" title="pizza2" id="wows1_0"/></li>
		<li><img src="<sp:url value='images/pizza3.jpg'></sp:url>" alt="pizza3" title="pizza3" id="wows1_1"/></li>
		<li><a href="http://wowslider.net"><img src="<sp:url value='images/pizza4.jpg'></sp:url>" alt="wow slider" title="pizza4" id="wows1_2"/></a></li>
		<li><img src="<sp:url value='images/pizza1.jpg'></sp:url>" alt="pizza1" title="pizza1" id="wows1_3"/></li>
	</ul></div>
	<div class="ws_bullets"><div>
		<a href="#" title="pizza2"><span><img src="<sp:url value='tooltips/pizza2.jpg'></sp:url>" alt="pizza2"/>1</span></a>
		<a href="#" title="pizza3"><span><img src="<sp:url value='tooltips/pizza3.jpg'></sp:url>" alt="pizza3"/>2</span></a>
		<a href="#" title="pizza4"><span><img src="<sp:url value='tooltips/pizza4.jpg'></sp:url>" alt="pizza4"/>3</span></a>
		<a href="#" title="pizza1"><span><img src="<sp:url value='tooltips/pizza4.jpg'></sp:url>" alt="pizza1"/>4</span></a>
	</div></div><div class="ws_script" style="position:absolute;left:-99%"><a href="http://wowslider.net">slider jquery</a> by WOWSlider.com v9.0</div>
	<div class="ws_shadow"></div>
	</div>	
	<script type="text/javascript" src="<sp:url value='engine1/wowslider.js'></sp:url>"></script>
	<script type="text/javascript" src="<sp:url value='engine1/script.js'></sp:url>"></script>
	<!-- End WOWSlider.com BODY section -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>