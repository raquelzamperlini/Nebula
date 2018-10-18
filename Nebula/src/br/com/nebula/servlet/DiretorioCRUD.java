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
@WebServlet(name = "DiretorioCRUD", urlPatterns = {"/view/usuario/DiretorioCRUD"})
@MultipartConfig
public class DiretorioCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public DiretorioCRUD() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fazer = request.getParameter("diretorio");
		String usuario = request.getParameter("usuario");
		
		PrintWriter out = response.getWriter();
		if (fazer.equals("Upload")) {
			Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
		    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
		    InputStream fileContent = filePart.getInputStream();
		    
		    File file = new File("C:\\temp\\" + fileName);
    		OutputStream outputStream = new FileOutputStream(file);
    		IOUtils.copy(fileContent, outputStream);
    		outputStream.close();
    		
			DiretorioCTRL dir = new DiretorioCTRL();
			dir.upload(usuario, file);
		}else {
			out.println("Algo errado!");
		}
		
		response.sendRedirect("homeUsuario_f.jsp");
		
	}
}
