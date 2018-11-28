package br.com.nebula.testes;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.NotSupportedException;
import com.mpatric.mp3agic.UnsupportedTagException;

import br.com.nebula.aws.DDB;
import br.com.nebula.mp3.Tag;

public class TestAWSDDB {
	
	public static void main(String[] args) throws IOException, URISyntaxException, UnsupportedTagException, InvalidDataException, NotSupportedException {
		//Informações da tabela
//		DDB.tableInfo();
		File file;
		file = new File("C:\\Users\\Vinicius\\Documents\\neb\\albuns_teste\\_teste\\05 - All The Planes That Come In On The Quiet.mp3");
		HashMap<String, String> tags = new HashMap<String, String>();
		tags.put("artist", "Bridges");
		tags.put("album", "Fakkeltog");
		tags.put("title", "May The Last Dance Be Mine");
		tags.put("track", "3");
		tags.put("year", "1980");
		Tag t = new Tag(file, tags);
		t.setFileKey("jsilveira/a-ha");
//		TagTest tt = new TagTest();
		
		System.out.println(t.toString());
		DDB.deleteItem(t);
		System.out.println("Pronto");
	}
	
}
