package br.com.nebula.controller;

import java.sql.SQLException;
import java.util.List;

import br.com.nebula.dao.UsuarioDAO;
import br.com.nebula.model.Usuario;

public class UsuarioCTRL {
	
	public void adicionarUsuario(Usuario usuario) {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.adicionarUsuario(usuario);
		
	}
	
	public Usuario pesquisarUsuario(Integer id) throws SQLException {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario us =  usuarioDAO.pesquisarUsuario(id);
		
		return us;
		
	}
	
	public List<Usuario> pesquisarTodosUsuarios() throws SQLException {
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		List<Usuario> usuarios =  usuarioDAO.pesquisarTodosUsuarios();
		
		return usuarios;
		
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
	
}
