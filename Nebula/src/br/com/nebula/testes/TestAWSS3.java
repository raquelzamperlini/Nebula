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
		
		String prefix = "jsilveira";
		
//		// TESTE DE LISTAGEM //
//		String prefix = "jsilveira/Bridges"; 		
//		List<S3ObjectSummary> objects = S3.listFiles(prefix);
//		for (S3ObjectSummary os: objects) {
//			String file = os.getKey();
//			//(depois do prefixo)
//			//se o objeto tem só mais uma / e é a última da string, exibir
//			//se o objeto não tem mais uma /, exibir
//			//se o objeto tem mais caracteres depois da /, não exibir
//			String result = file.toString().substring(prefix.length() + 10);
//			
//			//System.out.println("*" + result);
//			if(result.contains("/") ) { 
//				if(result.lastIndexOf("/") == result.length() - 1) {
//					System.out.println(file.toString().substring(prefix.length() + 10));
//				}
//			}else {
//				System.out.println(file.toString().trim().substring(prefix.length() + 10));
//			}
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
