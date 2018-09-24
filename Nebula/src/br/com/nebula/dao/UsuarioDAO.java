package br.com.nebula.dao;

import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Calendar;
import java.util.List;

import br.com.nebula.controller.Datas;
import br.com.nebula.dao.ConnectionFactory;
import br.com.nebula.model.Usuario;

public class UsuarioDAO {
	
	private Connection connection;
	Datas datas = new Datas();
	
	public UsuarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adicionarUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario (us_id, "
				+ 						  "us_diretorio_raiz, "
				+ 						  "us_nome, "
				+ 						  "us_email, "
				+ 						  "us_cpf, "
				+ 						  "us_nascimento, "
				+ 						  "us_username, "
				+ 						  "us_senha, "
				+ 						  "us_permissao,"
				+ 						  "us_status, "
				+ 						  "us_licencas) "
				+     "VALUES (us_id_seq.nextval, "
				+ 			   "?, "
				+ 			   "?, "
				+ 			   "?, "
				+ 			   "?, "
				+ 			   "TO_DATE(?, 'DD/MM/YYYY'), "
				+ 			   "?, "
				+ 			   "?, "
				+ 			   "?,"
				+ 			   "?,"
				+ 			   "? )";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			// Monta statement
			stmt.setString(1, "/usuarios/" + usuario.getUs_username());
			stmt.setString(2, usuario.getUs_nome());
			stmt.setString(3, usuario.getUs_email());
			stmt.setString(4, usuario.getUs_cpf());
			//stmt.setDate(5, new Date(usuario.getUs_nascimento().getTimeInMillis()));
			//stmt.setDate(5, usuario.getUs_nascimento());
			stmt.setDate(5, java.sql.Date.valueOf(usuario.getUs_nascimento()));
			stmt.setString(6, usuario.getUs_username());
			stmt.setString(7, usuario.getUs_senha());
			stmt.setString(8, usuario.getUs_permissao());
			stmt.setBoolean(9, usuario.isUs_status());
			stmt.setInt(10, usuario.getUs_licencas());
			
			// Executa
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		
	}
	
	public List<Usuario> pesquisarTodosUsuarios() throws SQLException {
		
		String sql = "SELECT * FROM usuario";
		
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		while (rs.next()) {
			// Cria o objeto e instancia
			Usuario us = new Usuario();
			us.setUs_id(rs.getInt("us_id"));
			us.setUs_diretorio_raiz(rs.getString("us_diretorio_raiz"));
			us.setUs_nome(rs.getString("us_nome"));
			us.setUs_email(rs.getString("us_email"));
			us.setUs_cpf(rs.getString("us_cpf"));
			
			/*
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("us_nascimento"));
			us.setUs_nascimento(data);
			*/
			//us.setUs_nascimento(Date.valueOf(rs.getString("us_nascimento")));
			us.setUs_nascimento(datas.stringParaLocalDate(rs.getDate("us_nascimento").toString()));
			
			us.setUs_username(rs.getString("us_username"));
			us.setUs_senha(rs.getString("us_senha"));
			us.setUs_permissao(rs.getString("us_permissao"));
			us.setUs_status(rs.getBoolean("us_status"));
			us.setUs_licencas(rs.getInt("us_licencas"));
			
			// Adiciona instância à lista
			usuarios.add(us);			
			
		}
		
		rs.close();
		stmt.close();
		
		ConnectionFactory.closeConnection(connection);
		
		return usuarios;
	}
	
	public Usuario pesquisarUsuarioId(Integer us_id) throws SQLException {
		
		String sql = "SELECT * FROM usuario "
				+     "WHERE us_id = ?";
		
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setInt(1, us_id);
		ResultSet rs = stmt.executeQuery();
		
		Usuario us = new Usuario();
		
		if (rs.next()) {
			// Instancia o objeto
			us.setUs_id(rs.getInt("us_id"));
			us.setUs_diretorio_raiz(rs.getString("us_diretorio_raiz"));
			us.setUs_nome(rs.getString("us_nome"));
			us.setUs_email(rs.getString("us_email"));
			us.setUs_cpf(rs.getString("us_cpf"));
			
			/*
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("us_nascimento"));
			us.setUs_nascimento(data);
			*/
			//us.setUs_nascimento(Date.valueOf(rs.getString("us_nascimento")));
			us.setUs_nascimento(datas.stringParaLocalDate(rs.getDate("us_nascimento").toString()));
			
			us.setUs_username(rs.getString("us_username"));
			us.setUs_senha(rs.getString("us_senha"));
			us.setUs_permissao(rs.getString("us_permissao"));
			us.setUs_status(rs.getBoolean("us_status"));
			us.setUs_licencas(rs.getInt("us_licencas"));			
		}
		
		rs.close();
		stmt.close();
		
		ConnectionFactory.closeConnection(connection);
		
		return us;
	}
	
	public Usuario pesquisarUsuarioUsername(String us_username) throws SQLException {
		
		String sql = "SELECT * FROM usuario "
				+     "WHERE us_username = ?";
		
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, us_username);
		ResultSet rs = stmt.executeQuery();
		
		Usuario us = new Usuario();
		
		if (rs.next()) {
			// Instancia o objeto
			us.setUs_id(rs.getInt("us_id"));
			us.setUs_diretorio_raiz(rs.getString("us_diretorio_raiz"));
			us.setUs_nome(rs.getString("us_nome"));
			us.setUs_email(rs.getString("us_email"));
			us.setUs_cpf(rs.getString("us_cpf"));
			
			/*
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("us_nascimento"));
			us.setUs_nascimento(data);
			*/
			//us.setUs_nascimento(Date.valueOf(rs.getString("us_nascimento")));
			us.setUs_nascimento(datas.stringParaLocalDate(rs.getDate("us_nascimento").toString()));
			
			us.setUs_username(rs.getString("us_username"));
			us.setUs_senha(rs.getString("us_senha"));
			us.setUs_permissao(rs.getString("us_permissao"));
			us.setUs_status(rs.getBoolean("us_status"));
			us.setUs_licencas(rs.getInt("us_licencas"));			
		}
		
		rs.close();
		stmt.close();
		
		ConnectionFactory.closeConnection(connection);
		
		return us;
	}
	
	public Usuario pesquisarUsuarioEmail(String us_email) throws SQLException {
		
		String sql = "SELECT * FROM usuario "
				+     "WHERE us_email = ?";
		
		PreparedStatement stmt = this.connection.prepareStatement(sql);
		stmt.setString(1, us_email);
		ResultSet rs = stmt.executeQuery();
		
		Usuario us = new Usuario();
		
		if (rs.next()) {
			// Instancia o objeto
			us.setUs_id(rs.getInt("us_id"));
			us.setUs_diretorio_raiz(rs.getString("us_diretorio_raiz"));
			us.setUs_nome(rs.getString("us_nome"));
			us.setUs_email(rs.getString("us_email"));
			us.setUs_cpf(rs.getString("us_cpf"));
			
			/*
			Calendar data = Calendar.getInstance();
			data.setTime(rs.getDate("us_nascimento"));
			us.setUs_nascimento(data);
			*/
			//us.setUs_nascimento(Date.valueOf(rs.getString("us_nascimento")));
			us.setUs_nascimento(datas.stringParaLocalDate(rs.getDate("us_nascimento").toString()));
			
			us.setUs_username(rs.getString("us_username"));
			us.setUs_senha(rs.getString("us_senha"));
			us.setUs_permissao(rs.getString("us_permissao"));
			us.setUs_status(rs.getBoolean("us_status"));
			us.setUs_licencas(rs.getInt("us_licencas"));			
		}
		
		rs.close();
		stmt.close();
		
		ConnectionFactory.closeConnection(connection);
		
		return us;
	}
	
	public void alterarUsuario(Usuario usuario) {
		String sql = "UPDATE usuario "
				+    "SET us_diretorio_raiz = ?, "
				+ 		 "us_nome = ?, "
				+        "us_email = ?, "
				+ 		 "us_cpf = ?, "
				+ 		 "us_nascimento = TO_DATE(?, 'DD/MM/YYYY'), "
				+ 		 "us_username = ?, "
				+ 		 "us_senha = ?, "
				+ 		 "us_permissao = ?, "
				+ 		 "us_status = ?, "
				+ 		 "us_licencas = ? "
				+ 	"WHERE us_id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, "/usuarios/" + usuario.getUs_username());
			stmt.setString(2, usuario.getUs_nome());
			stmt.setString(3, usuario.getUs_email());
			stmt.setString(4, usuario.getUs_cpf());
			//stmt.setDate(5, new Date(usuario.getUs_nascimento().getTimeInMillis()));
			//stmt.setDate(5, usuario.getUs_nascimento());
			stmt.setDate(5, java.sql.Date.valueOf(usuario.getUs_nascimento()));
			stmt.setString(6, usuario.getUs_username());
			stmt.setString(7, usuario.getUs_senha());
			stmt.setString(8, usuario.getUs_permissao());
			stmt.setBoolean(9, usuario.isUs_status());
			stmt.setInt(10, usuario.getUs_licencas());
			stmt.setInt(11, usuario.getUs_id());
			
			stmt.executeQuery();
			stmt.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
	
	public void removerUsuario(Usuario usuario) {
		
		String sql = "DELETE FROM usuario "
				+     "WHERE us_id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, usuario.getUs_id());
			
			stmt.executeQuery();
			stmt.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		
	}
	
	public Usuario autenticarUsuario(Usuario usuario) {
		
		Usuario us = new Usuario();
		
		String sql = "SELECT * FROM usuario "
				+     "WHERE us_email = ? "
				+      "AND us_senha = ?";
		
		try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setString(1, usuario.getUs_email());
			stmt.setString(2, usuario.getUs_senha());
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				// Intancia o objeto
				us.setUs_id(Integer.parseInt(rs.getString("us_id")));
				us.setUs_diretorio_raiz(rs.getString("us_diretorio_raiz"));
				us.setUs_nome(rs.getString("us_nome"));
				us.setUs_email(rs.getString("us_email"));
				us.setUs_cpf(rs.getString("us_cpf"));
				
				/*
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("us_nascimento"));
				us.setUs_nascimento(data);
				*/
				//us.setUs_nascimento(Date.valueOf(rs.getString("us_nascimento")));
				us.setUs_nascimento(datas.stringParaLocalDate(rs.getDate("us_nascimento").toString()));
				
				us.setUs_username(rs.getString("us_username"));
				us.setUs_senha(rs.getString("us_senha"));
				us.setUs_permissao(rs.getString("us_permissao"));
				us.setUs_status(rs.getBoolean("us_status"));
				us.setUs_licencas(rs.getInt("us_licencas"));
				
			}
			
			else
			{
				us.setUs_nome("Deu ruim aqui...");
				us.setUs_email(usuario.getUs_email());
				us.setUs_senha(usuario.getUs_senha());
			}
			
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
		
		return us;
		
	}
	
	public void consumirLicenca(Usuario usuario) {
		String sql = "UPDATE usuario "
				+    "SET us_licencas = us_licencas - 1 "
				+ 	"WHERE us_email = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, usuario.getUs_email());
			
			stmt.executeQuery();
			stmt.close();
			
		} catch(SQLException e) {
			throw new RuntimeException(e);
		} finally {
			ConnectionFactory.closeConnection(connection);
		}
	}
}
