package br.com.nebula.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import br.com.nebula.aws.S3;
import br.com.nebula.dao.Criptografia;
import br.com.nebula.dao.UsuarioDAO;
import br.com.nebula.model.Usuario;

public class UsuarioCTRL {
	
	public void criarAmbienteUsuario(Usuario usuario) {
		S3.createFolder(usuario.getUs_username(), null);
		//a fazer:
		//criar metadados no DynamoDB
	}
	
	public boolean adicionarUsuario(Usuario usuario) {
		
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.adicionarUsuario(usuario);
			criarAmbienteUsuario(usuario);
			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public List<Usuario> pesquisarTodosUsuarios() throws SQLException {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios =  usuarioDAO.pesquisarTodosUsuarios();
		
		return usuarios;
		
	}
	
	public Usuario pesquisarUsuarioId(Integer id) throws SQLException {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario us =  usuarioDAO.pesquisarUsuarioId(id);
		
		return us;
		
	}
	
	public Usuario pesquisarUsuarioUsername(String username) throws SQLException {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario us =  usuarioDAO.pesquisarUsuarioUsername(username);
		
		return us;
		
	}
	
	public Usuario pesquisarUsuarioEmail(String email) throws SQLException {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario us =  usuarioDAO.pesquisarUsuarioEmail(email);
		
		return us;
		
	}
	
	public Usuario pesquisarUsuarioNome(String nome) throws SQLException {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario us =  usuarioDAO.pesquisarUsuarioNome(nome);
		
		return us;
		
	}
	
	public void alterarUsuario(Usuario usuario) {
		
		if(usuario.getUs_senha() != null) {
			usuario.setUs_senha(Criptografia.criptografar(usuario.getUs_senha()));
		}
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterarUsuario(usuario);
		
	}
	
	public void removerUsuario(Usuario usuario) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.removerUsuario(usuario);
		
	}
	
	public Usuario autenticarUsuario(Usuario usuario) {
		
		Usuario us = new Usuario();
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		us = usuarioDAO.autenticarUsuario(usuario);
		
		return us;
		
	}
	
	public void consumirLicenca(Usuario usuario) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.consumirLicenca(usuario);
	}
	
	public static String gerarSenha() {
		Random rand = new Random();
		String s = String.valueOf(rand.nextInt(99999999) + 10000000);
		return s;
	}
	
}
