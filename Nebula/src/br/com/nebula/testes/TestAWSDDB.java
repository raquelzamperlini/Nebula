package br.com.nebula.testes;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

import br.com.nebula.aws.DDB;
import br.com.nebula.mp3.Tag;

public class TestAWSDDB {
	
	public static void main(String[] args) throws IOException, URISyntaxException, UnsupportedTagException, InvalidDataException, NotSupportedException {
		//Informações da tabela
		//DDB.tableInfo();
		//Tag t = new Tag();
		//t.setFileKey("usuarios/jsilveira/American Music Club/1988 - California/09 - Jenny.mp3");
		Map<String, String> item = DDB.getItem("usuarios/jsilveira/American Music Club/1988 - California/09 - Jenny.mp3", null);
		
		System.out.println("Pronto");
	}
	
}
