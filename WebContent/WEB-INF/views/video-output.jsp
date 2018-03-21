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
			src="https://zencoder-temp-storage-us-east-1.s3.amazonaws.com/o/20180321/967eff11877d6a00e9a24603df0427b3/c075ab6535d1660e2faabcccf4448f3c.mp4?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAI456JQ76GBU7FECA%2F20180321%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20180321T050031Z&X-Amz-Expires=86399&X-Amz-SignedHeaders=host&X-Amz-Signature=845e601a51ff51103ac3d6942228ffe2f2dda13e1cde282a55d0d5ac8ad10ba6">
		<source type="video/mp4" src="https://edge.flowplayer.org/bauhaus.mp4"></video>
	</div>
</body>
</html>