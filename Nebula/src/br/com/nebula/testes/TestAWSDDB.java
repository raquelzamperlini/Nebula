package br.com.nebula.testes;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

import br.com.nebula.aws.DDB;
import br.com.nebula.controller.DiretorioCTRL;
import br.com.nebula.mp3.Tag;

public class TestAWSDDB {
	
	public static void main(String[] args) throws IOException, URISyntaxException, UnsupportedTagException, InvalidDataException, NotSupportedException {
		//Informações da tabela
		//DDB.tableInfo();
		//Tag t = new Tag();
		//t.setFileKey("usuarios/jsilveira/American Music Club/1988 - California/09 - Jenny.mp3");
		DiretorioCTRL dir = new DiretorioCTRL();
		List<S3ObjectSummary> objects = dir.listarArquivos("jsilveira/Bridges");
		Map<String, String> item = new HashMap<String, String>();
		
		for(S3ObjectSummary os: objects) {
			System.out.println(os.getKey());
			
			if (!os.getKey().equals("usuarios/jsilveira/Bridges/")) {
				item = DDB.getItem(os.getKey(), null);
				System.out.println(item.toString());
			}
		}
		//item = DDB.getItem("usuarios/jsilveira/Adam Ant/1990 - Manners & Physique/01 - Room At The Top.mp3", null);
		
		
		System.out.println("Pronto");
	}
	
}
