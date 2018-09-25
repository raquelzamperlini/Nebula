<!--
/*
 * @author Raquel Zamperlini
 * 
 */
 -->

<%@ page import="br.com.nebula.model.Usuario" %>
<%@ page import="br.com.nebula.dao.Criptografia" %>
<%@ page import="br.com.nebula.controller.UsuarioCTRL" %>
<%@ page import="br.com.nebula.controller.Datas" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDate" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Salvar Cadastro</title>
	</head>
	<body>
		<%
			UsuarioCTRL usuarioCTRL = new UsuarioCTRL();
			Datas datas = new Datas();
			
			String nome = request.getParameter("crud_nome");
			String email = request.getParameter("crud_email");
			String cpf = request.getParameter("crud_cpf");
			
			LocalDate nascimento = datas.stringParaLocalDate(request.getParameter("crud_nascimento"));
			
			String username = request.getParameter("crud_username");
			//String senha = UsuarioCTRL.gerarSenha();
			String senha = request.getParameter("crud_senha");
			String permissao = request.getParameter("crud_permissao");
			boolean status = true;
			//int licencas = Integer.parseInt(request.getParameter("crud_licencas"));
			int licencas = 1;
			
			Criptografia criptografia = new Criptografia();
			senha = criptografia.criptografar(senha);
			
			Usuario usuario = new Usuario();
			
			usuario.setUs_nome(nome);
			usuario.setUs_email(email);
			usuario.setUs_cpf(cpf);
			usuario.setUs_nascimento(nascimento);
			usuario.setUs_username(username);
			usuario.setUs_senha(senha);
			usuario.setUs_permissao(permissao);
			usuario.setUs_status(status);
			usuario.setUs_licencas(licencas);
			
			//UsuarioCTRL usuarioCTRL = new UsuarioCTRL(); --movido pra cima
			usuarioCTRL.adicionarUsuario(usuario);
		%>
		
		<h1>Salvo com Sucesso! =D</h1>
	</body>
</html>