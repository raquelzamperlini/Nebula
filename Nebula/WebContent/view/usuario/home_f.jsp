<%@ page import="br.com.nebula.model.Usuario" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="author" content="Raquel Zamperlini">
		
		<!-- Bootstrap CSS -->
		<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/css/bootstrap.min.css">
		
		<title>Nebula</title>
	</head>
	
	<body>
		<jsp:include page="cabecalhoUSUARIO_f.jsp"></jsp:include>
		
		<div class="container p-2">
			<%
			if ((session.getAttribute("autenticado")) != null) {
				Usuario autenticado = (Usuario) session.getAttribute("autenticado");
				out.println("Bem-vindo, " + autenticado.getUs_nome() + "!");
				Integer id = autenticado.getUs_id();
				String username = autenticado.getUs_username();

				session.setAttribute("userid", String.valueOf(id));
				session.setAttribute("username", username);
			} else {
				response.sendRedirect(request.getContextPath() + "/view/login/loginErro.jsp");
			}
				
		%>
		</div>
		
		<div id="carouselExampleSlidesOnly" class="carousel slide" data-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img class="d-block w-100"
					 src="<%=request.getContextPath()%>/resources/images/background-carousel/arctic-monkeys-am.jpg"
					 alt="First slide">
				</div>
				
				<div class="carousel-item">
					<img class="d-block w-100"
					 src="<%=request.getContextPath()%>/resources/images/background-carousel/qotsa-villains.jpg"
					 alt="Second slide">
				</div>
				
				<div class="carousel-item">
					<img class="d-block w-100"
					 src="<%=request.getContextPath()%>/resources/images/background-carousel/three-days-grace-life-starts-now.jpg"
					 alt="Third slide">
				</div>
				
				<div class="carousel-item">
					<img class="d-block w-100"
					 src="<%=request.getContextPath()%>/resources/images/background-carousel/nx0-norte.jpg"
					 alt="Fourthy slide">
				</div>
				
				<div class="carousel-item">
					<img class="d-block w-100"
					 src="<%=request.getContextPath()%>/resources/images/background-carousel/the-beatles-abbey-road.jpg"
					 alt="Fifty slide">
				</div>
			</div>
		</div>
		
		<!-- Bootstrap core JavaScript -->
    	<script src="<%=request.getContextPath()%>/resources/js/bootstrap.min.js"></script>
	</body>
</html>