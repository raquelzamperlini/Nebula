<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
		
		<link href="<%=request.getContextPath()%>/resources/images/branch/Favicon.ico"
		 rel="icon" />
		
		<title>Nebula</title>
	</head>
	
	<body>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03"
			 aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			
			<img src="<%=request.getContextPath()%>/resources/images/branch/nebula-favicon-transparent.png"
			 height="45" width="45" alt="Nebula Icon" >
			
			<a class="navbar-brand" style="font-size: 26px" href="login.jsp">Nebula</a>
		</nav>
	
		<!-- Bootstrap core JavaScript -->
	    <script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	</body>
</html>