package br.com.nebula.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nebula.controller.UsuarioCTRL;
import br.com.nebula.model.Usuario;

/**
 * Servlet implementation class PesquisarUsuario
 */
@WebServlet(name = "PesquisarUsuario",
			urlPatterns = {
					"/PesquisarUsuario",
					"/Nebula/PesquisarUsuario",
					"/faces/PesquisarUsuario",
					"/Nebula/faces/PesquisarUsuario",
					
					"/view/PesquisarUsuario",
					"/Nebula/view/PesquisarUsuario",
					"/faces/view/PesquisarUsuario",
					"/Nebula/faces/view/PesquisarUsuario",
					
					"/view/login/PesquisarUsuario",
					"/Nebula/view/login/PesquisarUsuario",
					"/faces/view/login/PesquisarUsuario",
					"/Nebula/faces/view/login/PesquisarUsuario",
					
					"/view/administrador/PesquisarUsuario",
					"/Nebula/view/administrador/PesquisarUsuario",
					"/faces/view/administrador/PesquisarUsuario",
					"/Nebula/faces/view/administrador/PesquisarUsuario",
					
					"/view/usuario/PesquisarUsuario",
					"/Nebula/view/usuario/PesquisarUsuario",
					"/faces/view/usuario/PesquisarUsuario",
					"/Nebula/faces/view/usuario/PesquisarUsuario"
			})
public class PesquisarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesquisarUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UsuarioCTRL usuarioCTRL = new UsuarioCTRL();
		
		try {
			
			Usuario usuario = usuarioCTRL.pesquisarUsuarioId(Integer.parseInt(request.getParameter("parametroBuscaUsuario")));
			
			if ( usuario != null && usuario.getUs_email() != null )
			{
				
				request.setAttribute("usuarioPesquisado", usuario);
				request.getRequestDispatcher("pesquisarUsuarioEncontrado_f.jsp").forward(request, response);
				//request.getRequestDispatcher(request.getContextPath() + "/view/administrador/pesquisarUsuarioEncontrado.jsp").forward(request, response);
				
			}
			
			else
			{
				response.sendRedirect("pesquisarUsuarioNaoEncontrado_f.jsp");
				//response.sendRedirect(reqeust.getContextPath() + "/view/administrador/pesquisarUsuarioNaoEncontrado.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
