package br.com.nebula.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nebula.model.Usuario;
import br.com.nebula.controller.UsuarioCTRL;
import br.com.nebula.controller.Datas;

/**
 * Servlet implementation class UsuarioServletCTRL
 */
@WebServlet("/UsuarioCRUD")
public class UsuarioCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UsuarioCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Usuario usuario = new Usuario();
		UsuarioCTRL usuarioCTRL = new UsuarioCTRL();
		
		String acao = request.getParameter("acao");
		
													/*try {
														List<Usuario> usuarios = usuarioDAO.retornarTodosUsuarios();
														
														for (Usuario u:usuarios) {
															System.out.println("ID: " 				+ u.getUs_id()				+
																			   "Diret�rio Raiz: "	+ u.getUs_diretorio_raiz()	+
																			   "Nome: "				+ u.getUs_nome()			+
																			   "E-mail: "			+ u.getUs_email()			+
																			   "CPF: "				+ u.getUs_cpf()				+
																			   "Nascimento: "		+ u.getUs_nascimento()		+
																			   "Username: "			+ u.getUs_nascimento()		+
																			   "Senha: "			+ u.getUs_senha()			+
																			   "Permiss�o: "		+ u.getUs_permissao());
														}
													} catch (SQLException e) {
														e.printStackTrace();
													}*/
		
		if ( acao != null && acao.equals("listar") )
		{
			
			try {
				
				
				List<Usuario> usuarios = usuarioCTRL.pesquisarTodosUsuarios();
				
				request.setAttribute("usuarios", usuarios);
				
				RequestDispatcher saida = request.getRequestDispatcher("usuarioLista_f.jsp");
				
				saida.forward(request, response);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		else if ( acao != null && acao.equals("excluir") )
		{
			
			int us_id = Integer.parseInt(request.getParameter("us_id"));
			
			try {
				
				Usuario usuario = usuarioCTRL.pesquisarUsuarioId(us_id);
				usuarioCTRL.removerUsuario(usuario);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("UsuarioCRUD?acao=listar");
			
		}
		
		else if ( acao != null && acao.equals("alterar") )
		{
			
			Integer us_id = Integer.parseInt(request.getParameter("us_id"));
			
			try {
				
				Usuario usuario = usuarioCTRL.pesquisarUsuarioId(us_id);
				
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("usuarioAlterar_f.jsp").forward(request, response);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("UsuarioCRUD?acao=listar");
			
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Datas datas = new Datas();
		
		Integer id = Integer.parseInt(request.getParameter("crud_id"));
		String us_nome = request.getParameter("crud_nome");
		String us_email = request.getParameter("crud_email");
		String us_cpf = request.getParameter("crud_cpf");
		LocalDate us_nascimento = datas.stringParaLocalDate(request.getParameter("crud_nascimento"));
		String us_username = request.getParameter("crud_username");
		//String us_senha = request.getParameter("crud_senha");
		//String us_permissao = request.getParameter("crud_permissao");
		
		Usuario usuario = new Usuario();
		UsuarioCTRL usuarioCTRL = new UsuarioCTRL();
		
		try {
			
			usuario = usuarioCTRL.pesquisarUsuarioId(id);
			usuario.setUs_nome(us_nome);
			usuario.setUs_email(us_email);
			usuario.setUs_cpf(us_cpf);
			usuario.setUs_nascimento(us_nascimento);
			usuario.setUs_username(us_username);
			
			usuarioCTRL.alterarUsuario(usuario);
			
			PrintWriter out = response.getWriter();
			out.println("Alterado =D");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("UsuarioCRUD?acao=listar");
		
	}

}
