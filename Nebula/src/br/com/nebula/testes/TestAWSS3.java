package br.com.nebula.testes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.amazonaws.services.s3.model.S3ObjectSummary;

import br.com.nebula.aws.*;

public class TestAWSS3 {

	public static void main(String[] args) throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		
//		// TESTE DE CRIAÇÃO DE PASTA //
//		
//		S3.createFolder("testePasta");
		
		// TESTE DE UPLOAD //
		 
//		JFileChooser chooser = new JFileChooser();
//	    FileNameExtensionFilter filter = new FileNameExtensionFilter("mp3 audio files", "mp3");
//	    chooser.setFileFilter(filter);
//	    int returnVal = chooser.showOpenDialog(null);
//	    if(returnVal == JFileChooser.APPROVE_OPTION) {
//	       System.out.println("You chose to open this file: " +
//	            chooser.getSelectedFile().getName());
//	       S3.uploadFile("testePasta",chooser.getSelectedFile());
//	    }
		
		
//		// TESTE DE LISTAGEM //
//		 		
//		List<S3ObjectSummary> objects = S3.listFiles("teste");
//		for (S3ObjectSummary os: objects) {
//			String file = os.getKey();
//		    System.out.println("* " + file.substring(file.lastIndexOf("/") + 1).trim());
//		}
			
		
//		// TESTE DE DOWNLOAD //
//		
//		System.out.println("URL: " + S3.download("usuarios/jsilveira/02 - Driftwood.mp3"));
		
		
//		// TESTE DE DOWNLOAD PASTA //
//		
//		S3.downloadFolder("teste","C:\\Users\\Vinicius\\");
		
		// TESTE DE COPIAR //
		
	}

}
