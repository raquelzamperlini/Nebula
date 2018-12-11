package br.com.nebula.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

import br.com.nebula.aws.DDB;
import br.com.nebula.aws.S3;
import br.com.nebula.mp3.Tag;

public class DiretorioCTRL {
	public List<S3ObjectSummary> listarArquivos(String path){
		List<S3ObjectSummary> arquivos = S3.listFiles(path);
		return arquivos;
	}
	
	public void upload(String usuario, InputStream file, String fileName) throws IOException, UnsupportedTagException, InvalidDataException, NotSupportedException {
		//cria arquivo temporário
		File f = new File("C:\\TEMP\\" + fileName);
		FileUtils.copyInputStreamToFile(file, f);
		
		//pega tags presentes no arquivo [medida temporária]
		Tag t = Tag.getTag(f, usuario);
		HashMap<String, String> tags = new HashMap<String, String>();
		tags.put("key", usuario);
		tags.put("album", t.getAlbumTitle());
		tags.put("artist", t.getArtistName());
		tags.put("title", t.getSongTitle());
		tags.put("track", t.getTrackNumber());
		tags.put("year", t.getAlbumYear());
		
		//constrói tags no padrão
		t = new Tag(f, tags);
		
		//atualiza objeto InputStream
		file = new FileInputStream(f);
		
		//upload
		S3.uploadFile(usuario, file, fileName);
		
		//deleta origem
		f = new File("C:\\TEMP\\" + fileName);
		f.delete();
		
		//cria item no dynamo
		DDB.putItem(t);
	}
	
	public void copiar(String usuario, String arquivo, String caminho) {
		S3.copyFile(arquivo, String.format("%s/%s", usuario, caminho));
	}
	
	public String downloadLink(String file) throws IOException {
		return (S3.download(file)).toString();
	}
	
	public void excluir(String caminho, String arquivo) {
		S3.deleteFile(caminho, arquivo);
		DDB.deleteItem(String.format("usuarios/%s/%s", caminho, arquivo));
	}
	
	public void criarPasta(String caminho, String nome) {
		S3.createFolder(caminho, nome);
	}
	
	public void alterarTag(Map<String, String> tags) throws IOException, UnsupportedTagException, InvalidDataException, NotSupportedException {
		File f = new File("C:\\TEMP\\" + tags.get("filename"));
		URL url = new URL(tags.get("link"));
		FileUtils.copyURLToFile(url, f);
		//System.out.println(tags.toString());
		Tag t = new Tag(f, tags);
		//System.out.println(t.toString());
		DDB.putItem(t);
		f = new File("C:\\TEMP\\" + tags.get("filename"));
		InputStream file = new FileInputStream(f);
		S3.uploadFile(tags.get("path"), file, tags.get("filename"));
		System.out.println("Pronto");
		System.out.println(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
	}
}
