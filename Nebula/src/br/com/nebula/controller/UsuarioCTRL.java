package br.com.nebula.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import br.com.nebula.dao.UsuarioDAO;
import br.com.nebula.model.Usuario;

public class UsuarioCTRL {
	
	public void adicionarUsuario(Usuario usuario) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.adicionarUsuario(usuario);
		
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
	
	public Usuario pesquisarUsuarioId(String email) throws SQLException {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario us =  usuarioDAO.pesquisarUsuarioEmail(email);
		
		return us;
		
	}
	
	public void alterarUsuario(Usuario usuario) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.alterarUsuario(usuario);
		
	}
	
	public void remover(Usuario usuario) {
		
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
		usuarioDAO.consumirLicenca(usuario);;
	}
	
	public static String gerarSenha() {
		Random rand = new Random();
		String s = String.valueOf(rand.nextInt(99999999) + 10000000);
		return s;
	}
	
}
