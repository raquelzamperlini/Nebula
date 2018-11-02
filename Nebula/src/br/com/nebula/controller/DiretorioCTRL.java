package br.com.nebula.controller;

import java.io.File;
import java.io.InputStream;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.amazonaws.services.s3.model.S3ObjectSummary;

import br.com.nebula.aws.S3;

public class DiretorioCTRL {
	public List<S3ObjectSummary> listarArquivos(String path){
		List<S3ObjectSummary> arquivos = S3.listFiles(path);
		return arquivos;
	}
	
	public void upload(String usuario, File file) {
		S3.uploadFile(usuario,file);
	}
}
