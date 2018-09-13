/**
 * 
 */
package br.com.nebula.dao;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Raquel Zamperlini
 *
 */
public class Criptografia {
	
	public Criptografia () {
		
	}
	
	public String criptografar(String senha) {
		
		MessageDigest md;
		byte messageDigest[] = null;
		
		try {
			
			md = MessageDigest.getInstance("SHA-256");
			messageDigest = md.digest(senha.getBytes("UTF-8"));
			
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		StringBuilder sb = new StringBuilder();
		
		for (byte b : messageDigest)
		{
			sb.append(String.format("%02x", 0xFF & b));
		}
		
		String senhaHex = sb.toString();
		
		return senhaHex;
		
	}
	
}
