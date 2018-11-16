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
 * Servlet implementation class Pesquisar
 */
@WebServlet(name = "Pesquisar",
			urlPatterns = {
					"/Pesquisar",
					"/Nebula/Pesquisar",
					"/faces/Pesquisar",
					"/Nebula/faces/Pesquisar",
					
					"/view/Pesquisar",
					"/Nebula/view/Pesquisar",
					"/faces/view/Pesquisar",
					"/Nebula/faces/view/Pesquisar",
					
					"/view/login/Pesquisar",
					"/Nebula/view/login/Pesquisar",
					"/faces/view/login/Pesquisar",
					"/Nebula/faces/view/login/Pesquisar",
					
					"/view/administrador/Pesquisar",
					"/Nebula/view/administrador/Pesquisar",
					"/faces/view/administrador/Pesquisar",
					"/Nebula/faces/view/administrador/Pesquisar",
					
					"/view/usuario/Pesquisar",
					"/Nebula/view/usuario/Pesquisar",
					"/faces/view/usuario/Pesquisar",
					"/Nebula/faces/view/usuario/Pesquisar"
			})
public class Pesquisar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Pesquisar() {
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
			
			Usuario usuario = usuarioCTRL.pesquisarUsuarioId(Integer.parseInt(request.getParameter("userid")));
			
			if ( usuario != null && usuario.getUs_email() != null )
			{
				
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("pesquisarEncontrado_f.jsp").forward(request, response);
				//request.getRequestDispatcher(reqeust.getContextPath() + "/view/administrador/pesquisarEncontrado.jsp").forward(request, response);
				
			}
			
			else
			{
				response.sendRedirect("pesquisarNaoEncontrado_f.jsp");
				//response.sendRedirect(reqeust.getContextPath() + "/view/administrador/pesquisarNaoEncontrado.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
