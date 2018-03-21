
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<c:url value="resources/css/bootstrap.min.css"/>"
	rel="stylesheet" type="text/css">
<!-- <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"
	type="text/javascript"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<script type="text/javascript">
	function page() {
		console.log("test ok")
		$('#main-container').html('<h1>Loading... Please wait');
		// or change this to show a div that covers the page and has a spinner or whatever
		$.ajax({

			url : '/encoding',
			complete : function(response) {
				$('#main-container').html(response.responseText);
			},
			error : function() {
				$('#main-container').html('Bummer: there was an error!');
			},
		});
		return false;
	}
	
	$('#rpp').on('change', function() {
		   var url = [[${url_current}]];
		   var rpp = $('#rpp').val(); 
		   var data = {
		       rpp: rpp
		   };
		   $('body').append('<div id="ajax-loading"></div>');
		   $('#productList').load(url, data, function(){ // callback when completed
		      $('#ajax-loading').remove();
		   });
		});
</script>
</head>
<body>

	<div class="container">

		<h2>Video Streaming</h2>
		<div id="main-container">dada</div>
		<div id="rpp"></div>

		<form method="POST" enctype="multipart/form-data">

			<input type="file" name="file" class="form-control"> <input
				type="submit" name="submit" value="enviar">
			<!-- <button onclick="page()" class="btn btn-primary">add</button> -->

		</form>

	</div>


</body>
</html>