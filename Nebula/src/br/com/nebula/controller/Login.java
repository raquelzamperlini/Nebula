package br.com.nebula.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.nebula.dao.Criptografia;
import br.com.nebula.model.Usuario;

/**
 * Servlet implementation class Login
 * @author Raquel Zamperlini
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		
		if (sessao != null)
			sessao.invalidate();
		
		response.sendRedirect("login.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("login_email");
		String senha = request.getParameter("login_senha");
		
		Criptografia criptografa = new Criptografia();
		senha = criptografa.criptografar(senha);
		
		Usuario usuario = new Usuario(email, senha);
		
		UsuarioCTRL usuarioCTRL = new UsuarioCTRL();
		Usuario autenticado = usuarioCTRL.autenticarUsuario(usuario);
		
		if (autenticado.getUs_nome() != "Deu ruim aqui...")
		{
			HttpSession sessao = request.getSession();
			sessao.setAttribute("autenticado", autenticado);
			//sessao.setMaxInactiveInterval(3000);
			
			request.getRequestDispatcher("home.jsp").forward(request, response);;
		}
		
		else
		{
			response.sendRedirect("loginErro.jsp");
		}
	}

}
