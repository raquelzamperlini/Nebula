package br.com.nebula.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.com.nebula.controller.DiretorioCTRL;
import br.com.nebula.controller.UsuarioCTRL;
import br.com.nebula.dao.Criptografia;
import br.com.nebula.model.Usuario;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class UsuarioServletCTRL
 */
@WebServlet(name = "DiretorioCRUD", urlPatterns = { "/view/usuario/DiretorioCRUD" })
@MultipartConfig
public class DiretorioCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DiretorioCRUD() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String fazer = request.getParameter("action");
		String usuario = request.getParameter("usuario");
		String arquivo = request.getParameter("file");
		String caminho = request.getParameter("caminho");

		PrintWriter out = response.getWriter();
		DiretorioCTRL dir = new DiretorioCTRL();
		
		switch (fazer) {
		case "Upload":
			out.println("Aguarde...");
			Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();
			dir.upload(usuario, fileContent, fileName);

			/*
			File file = new File("C:\\temp\\" + fileName);
			OutputStream outputStream = new FileOutputStream(file);
			IOUtils.copy(fileContent, outputStream);
			outputStream.close();

			dir.upload(usuario, file);
			*/
			break;
		case "copiar":
			
			dir.copiar(usuario, arquivo, caminho);
			break;
		case "mover":
			break;
		case "renomear":
			break;
		default:
			out.println("Algo errado!");
		}
		
		response.sendRedirect("diretorioArquivos_f.jsp");

	}
}
