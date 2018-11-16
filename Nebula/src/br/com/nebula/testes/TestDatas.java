package br.com.nebula.testes;

import java.time.LocalDate;
import br.com.nebula.controller.Datas;

public class TestDatas {
	
	static Datas datas = new Datas();
	
	public static void main(String[] args) {
		
		LocalDate ld = datas.stringParaLocalDate("23/06/1996");
		
		System.out.println(ld);
		
		String s = datas.localDateParaString(ld);
		
		System.out.println(s);
		
	}
	
}
