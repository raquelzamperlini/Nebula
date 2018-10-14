<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<jsp:include page="cabecalho_f.jsp"></jsp:include> <br />
		
		<form id="crud_form" action="PesquisarServlet" method="post" >
			<input type="text" id="crud_id" name="crud_id" style="width:300px" maxlength="38"> 
			
			<input type="submit" id="crud_pesquisar" name="crud_pesquisar" value="Pesquisar"> <br/>
		</form>
	</body>
</html>