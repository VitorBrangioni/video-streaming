<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%-- <script type="text/javascript" src="<c:url value="resources/js/jquery.min.js"/>"></script> --%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"
	type="text/javascript"></script>

<!-- player skin -->
<link href="<c:url value="resources/css/skin.css"/>"
	rel="stylesheet" type="text/css" media="all" >

<!-- site specific styling -->
<style>
body {
	font: 12px "Myriad Pro", "Lucida Grande", sans-serif;
	text-align: center;
	padding-top: 5%;
}

.flowplayer {
	width: 80%;
}
</style>

<!-- for video tag based installs flowplayer depends on jQuery 1.7.2+ -->
<!-- <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script> -->

<!-- include flowplayer -->
<script src="<c:url value="resources/js/flowplayer.min.js"/>"></script>
</head>
<body>

	<h1>Video Output</h1>
	<!-- the player -->
	<div class="flowplayer" data-swf="flowplayer.swf" data-ratio="0.4167">
		<video> <source type="video/webm"
			src="${videoPath}">
		<source type="video/mp4" src="https://edge.flowplayer.org/bauhaus.mp4"></video>
	</div>
</body>
</html>