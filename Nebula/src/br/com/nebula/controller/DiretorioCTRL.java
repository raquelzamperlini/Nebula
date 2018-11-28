package br.com.nebula.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;
import org.farng.mp3.TagException;

import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

import br.com.nebula.aws.S3;
import br.com.nebula.mp3.Tag;

public class DiretorioCTRL {
	public List<S3ObjectSummary> listarArquivos(String path){
		List<S3ObjectSummary> arquivos = S3.listFiles(path);
		return arquivos;
	}
	
	public void upload(String usuario, InputStream file, String fileName) throws IOException, TagException, UnsupportedTagException, InvalidDataException, NotSupportedException {
		//cria arquivo temporário
		File f = new File("C:\\TEMP\\" + fileName);
		FileUtils.copyInputStreamToFile(file, f);
		
		//pega tags presentes no arquivo [medida temporária]
		Tag t = Tag.getTag(f);
		HashMap<String, String> tags = new HashMap<String, String>();
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
		
	}
	
	public void copiar(String usuario, String arquivo, String caminho) {
		S3.copyFile(arquivo, String.format("%s/%s", usuario, caminho));
	}
	
	public String downloadLink(String file) throws IOException {
		return (S3.download(file)).toString();
	}
}
