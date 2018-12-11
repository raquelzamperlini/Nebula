package br.com.nebula.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.nebula.aws.DDB;
import br.com.nebula.controller.DiretorioCTRL;
import br.com.nebula.model.S3ListItem;

import org.apache.commons.lang3.StringUtils;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.google.gson.Gson;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

/**
 * Servlet implementation class UsuarioServletCTRL
 */
@WebServlet(name = "DiretorioCRUD",
			urlPatterns = {
					"/DiretorioCRUD",
					"/Nebula/DiretorioCRUD",
					"/faces/DiretorioCRUD",
					"/Nebula/faces/DiretorioCRUD",
					
					"/view/DiretorioCRUD",
					"/Nebula/view/DiretorioCRUD",
					"/faces/view/DiretorioCRUD",
					"/Nebula/faces/view/DiretorioCRUD",
					
					"/view/login/DiretorioCRUD",
					"/Nebula/view/login/DiretorioCRUD",
					"/faces/view/login/DiretorioCRUD",
					"/Nebula/faces/view/login/DiretorioCRUD",
					
					"/view/administrador/DiretorioCRUD",
					"/Nebula/view/administrador/DiretorioCRUD",
					"/faces/view/administrador/DiretorioCRUD",
					"/Nebula/faces/view/administrador/DiretorioCRUD",
					
					"/view/usuario/DiretorioCRUD",
					"/Nebula/view/usuario/DiretorioCRUD",
					"/faces/view/usuario/DiretorioCRUD",
					"/Nebula/faces/view/usuario/DiretorioCRUD"
			})
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
		String caminho = request.getParameter("caminho");
		String chave = request.getParameter("chave");
		
		PrintWriter out = response.getWriter();
		DiretorioCTRL dir = new DiretorioCTRL();
		HashMap<String, String> infos = new HashMap<String,String>();
		
		switch (fazer) {
		case "upload":
			Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
			InputStream fileContent = filePart.getInputStream();

			try {
				dir.upload(caminho, fileContent, fileName);
			} catch (UnsupportedTagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case "copiar":			
			dir.copiar(usuario, chave, caminho);
			break;
		case "mover":
			break;
		case "renomear":
			break;
		case "excluir":
			dir.excluir(caminho, chave);
			break;
		case "tags":
			System.out.println("Começou!");
			System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
			infos.put("key", caminho);
			infos.put("path", caminho);
			infos.put("filename", chave.substring(chave.lastIndexOf("/") + 1));
			infos.put("link", request.getParameter("link"));
			infos.put("album", request.getParameter("album"));
			infos.put("artist", request.getParameter("artist"));
			infos.put("title", request.getParameter("title"));
			infos.put("track", request.getParameter("track"));
			infos.put("year", request.getParameter("year"));
			System.out.println(infos.toString());
			
			try {
				dir.alterarTag(infos);
			} catch (UnsupportedTagException | InvalidDataException | NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		case "criar":
			dir.criarPasta(caminho, chave);
			break;
		case "listar":
			List<S3ObjectSummary> objects = dir.listarArquivos(caminho);
			List<S3ListItem> arquivos = new ArrayList<S3ListItem>();
			
			for (S3ObjectSummary os: objects) {
				String file = os.getKey();
				//(depois do prefixo)
				//se o objeto tem só mais uma / e é a última da string, exibir
				//se o objeto não tem mais uma /, exibir
				//se o objeto tem mais caracteres depois da /, não exibir
				String result = file.toString().substring(caminho.length() + 10);
				
				if(result.contains("/") ) { 
					if(StringUtils.countMatches(result, "/") > 1) {
						continue;
					}else {
						if(result.lastIndexOf("/") == result.length() - 1) {
							S3ListItem item = new S3ListItem(file.trim().substring(caminho.length() + 10),caminho + "/" + file.trim().substring(caminho.length() + 10), true);
							arquivos.add(item);
						}
					}
				}else {
					if(result.trim().isEmpty()) {
						if(caminho.equals(usuario)) {
							continue;
						}
						S3ListItem item = new S3ListItem("../",caminho.substring(0, caminho.lastIndexOf("/") + 1), true);
						arquivos.add(item);
						continue;
					}
					S3ListItem item = new S3ListItem(file.trim().substring(caminho.length() + 10),dir.downloadLink(file), false);
					Map<String, String> tags = DDB.getItem(os.getKey(), null);
					item.setAlbum(tags.get("albumTitle"));
					item.setArtist(tags.get("artistName"));
					item.setDuration(tags.get("trackDuration"));
					item.setKeyLong(file);
					item.setNumber(tags.get("trackNumber"));
					item.setSize(tags.get("fileSize"));
					item.setTitle(tags.get("songTitle"));
					item.setYear(tags.get("albumYear"));
					arquivos.add(item);
				}
			}
			String json = new Gson().toJson(arquivos);
			response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    
		    out.print(json);
		    out.flush();
			break;
		default:
			out.println("Algo errado!");
		}

	}
}
