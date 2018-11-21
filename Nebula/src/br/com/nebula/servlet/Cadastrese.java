package br.com.nebula.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.nebula.controller.Datas;
import br.com.nebula.controller.UsuarioCTRL;
import br.com.nebula.dao.Criptografia;
import br.com.nebula.model.Usuario;

/**
 * Servlet implementation class Cadastrese
 * @author Raquel Zamperlini
 */
@WebServlet(name = "Cadastrese",
			urlPatterns = {
					"/Cadastrese",
					"/Nebula/Cadastrese",
					"/faces/Cadastrese",
					"/Nebula/faces/Cadastrese",
					
					"/view/Cadastrese",
					"/Nebula/view/Cadastrese",
					"/faces/view/Cadastrese",
					"/Nebula/faces/view/Cadastrese",
					
					"/view/login/Cadastrese",
					"/Nebula/view/login/Cadastrese",
					"/faces/view/login/Cadastrese",
					"/Nebula/faces/view/login/Cadastrese",
					
					"/view/administrador/Cadastrese",
					"/Nebula/view/administrador/Cadastrese",
					"/faces/view/administrador/Cadastrese",
					"/Nebula/faces/view/administrador/Cadastrese",
					
					"/view/usuario/Cadastrese",
					"/Nebula/view/usuario/Cadastrese",
					"/faces/view/usuario/Cadastrese",
					"/Nebula/faces/view/usuario/Cadastrese"
			})
public class Cadastrese extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Cadastrese() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioCTRL usuarioCTRL = new UsuarioCTRL();
		Datas datas = new Datas();

		String nome = request.getParameter("inputNome");
		String email = request.getParameter("inputEmail");
		String cpf = request.getParameter("inputCpf");
		
		cpf = cpf.replaceAll("[.-]", "");

		LocalDate nascimento = datas.stringParaLocalDate(request.getParameter("inputNascimento"));

		String username = request.getParameter("inputUsername");
		String senha = request.getParameter("inputSenha");
		String permissao = "usuario";
		boolean status = true;
		int licencas = 1;

		senha = Criptografia.criptografar(senha);

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

		// UsuarioCTRL usuarioCTRL = new UsuarioCTRL(); -- movido para cima
		usuarioCTRL.adicionarUsuario(usuario);

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Mensagem</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<br><font face=\"arial\" size=\"20\" OnLoad=\"cadastroSalvo()\">=)</font>");
		out.println("</body>");
		out.println("</html>");
		out.println("<script language = 'JavaScript'>"
				+ "$cadastroSalvo() { "
				+ 	"decisao = confirm(\"Cadastro salvo com sucesso!\"); "
				+ 	"if (decisao) { "
				+ 		"window.location=\"login.jsp\"; "
				+	 "} "
				+ "} "
				+ "</SCRIPT>");
	}

}
