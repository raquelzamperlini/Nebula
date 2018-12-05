package br.com.nebula.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.nebula.controller.UsuarioCTRL;
import br.com.nebula.dao.Criptografia;
import br.com.nebula.model.Usuario;

/**
 * Servlet implementation class Login
 * @author Raquel Zamperlini
 */
@WebServlet(name = "Login",
			urlPatterns = {
					"/Login",
					"/Nebula/Login",
					"/faces/Login",
					"/Nebula/faces/Login",
					
					"/view/Login",
					"/Nebula/view/Login",
					"/faces/view/Login",
					"/Nebula/faces/view/Login",
					
					"/view/login/Login",
					"/Nebula/view/login/Login",
					"/faces/view/login/Login",
					"/Nebula/faces/view/login/Login",
					
					"/view/administrador/Login",
					"/Nebula/view/administrador/Login",
					"/faces/view/administrador/Login",
					"/Nebula/faces/view/administrador/Login",
					
					"/view/usuario/Login",
					"/Nebula/view/usuario/Login",
					"/faces/view/usuario/Login",
					"/Nebula/faces/view/usuario/Login"
			})
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public Login() {
        super();
        
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession sessao = request.getSession(false);
		
		if (sessao != null)
		{
			Usuario usuario = (Usuario) sessao.getAttribute("autenticado");
			usuario.setUs_licencas(usuario.getUs_licencas() + 1);
			
			sessao.invalidate();
		}
			
		//response.sendRedirect("login.jsp");
		response.sendRedirect(request.getContextPath() + "/view/login/login.jsp");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("login_email");
		String senha = request.getParameter("login_senha");
		
		senha = Criptografia.criptografar(senha);
		
		Usuario usuario = new Usuario(email, senha);
		
		UsuarioCTRL usuarioCTRL = new UsuarioCTRL();
		Usuario autenticado = usuarioCTRL.autenticarUsuario(usuario);
		
		if (autenticado.getUs_nome() != "Deu ruim aqui..." &&
				autenticado.isUs_status() /*&&
				autenticado.getUs_licencas() > 0*/ )
		{
			HttpSession sessao = request.getSession();
			sessao.setAttribute("autenticado", autenticado);
			//sessao.setMaxInactiveInterval(3000);
			
			//usuarioCTRL.consumirLicenca(autenticado);
			
			if (autenticado.getUs_permissao().equals("administrador") )
			{
				//request.getRequestDispatcher("home_f.jsp").forward(request, response);
				//request.getRequestDispatcher(request.getContextPath() + "/view/administrador/home_f.jsp").forward(request, response);
				//request.getRequestDispatcher("../view/administrador/home_f.jsp").forward(request, response);
				response.sendRedirect("../administrador/home_f.jsp");
			}

			if (autenticado.getUs_permissao().equals("usuario") )
				//request.getRequestDispatcher("PAGINADOUSUARIO.jsp").forward(request, response);
				response.sendRedirect("../usuario/home_f.jsp");
				//response.sendRedirect(request.getContextPath() + "/view/usuario/homeUsuario_f.jsp");
				//request.getRequestDispatcher("PAGINADOUSUARIO.jsp").forward(request, response);
		}
		
		else
		{
			//response.sendRedirect("loginErro.jsp");
			//response.sendRedirect(request.getContextPath() + "/view/login/loginErro.jsp");
			response.sendRedirect(request.getContextPath() + "/view/login/loginErro.jsp");
		}
	}

}
