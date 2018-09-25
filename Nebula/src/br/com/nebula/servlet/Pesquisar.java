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
@WebServlet("/Pesquisar")
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
		
		Integer us_id = Integer.parseInt(request.getParameter("crud_id"));
		
		try {
			
			Usuario usuario = usuarioCTRL.pesquisarUsuarioId(us_id);
			
			if ( usuario != null && usuario.getUs_email() != null )
			{
				
				request.setAttribute("usuario", usuario);
				request.getRequestDispatcher("pesquisarEncontrado.jsp").forward(request, response);;
				
			}
			
			else
			{
				response.sendRedirect("pesquisarNaoEncontrado.jsp");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
