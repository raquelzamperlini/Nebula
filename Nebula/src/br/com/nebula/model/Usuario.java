package br.com.nebula.model;

import java.time.LocalDate;

//import java.sql.Date;
//import java.util.Calendar;

public class Usuario {
	private Integer us_id;
	private String us_diretorio_raiz;
	private String us_nome;
	private String us_email;
	private String us_cpf;
	private LocalDate us_nascimento;
	private String us_username;
	private String us_senha;
	private String us_permissao;
	
	public Usuario(Integer us_id, String us_diretorio_raiz, String us_nome, String us_email, String us_cpf,
			LocalDate us_nascimento, String us_username, String us_senha, String us_permissao) {
		super();
		this.us_id = us_id;
		this.us_diretorio_raiz = us_diretorio_raiz;
		this.us_nome = us_nome;
		this.us_email = us_email;
		this.us_cpf = us_cpf;
		this.us_nascimento = us_nascimento;
		this.us_username = us_username;
		this.us_senha = us_senha;
		this.us_permissao = us_permissao;
	}
	
	public Usuario(String us_diretorio_raiz, String us_nome, String us_email, String us_cpf,
			LocalDate us_nascimento, String us_username, String us_senha, String us_permissao) {
		super();
		this.us_diretorio_raiz = us_diretorio_raiz;
		this.us_nome = us_nome;
		this.us_email = us_email;
		this.us_cpf = us_cpf;
		this.us_nascimento = us_nascimento;
		this.us_username = us_username;
		this.us_senha = us_senha;
		this.us_permissao = us_permissao;
	}
	
	public Usuario(String us_email, String us_senha) {
		super();
		this.us_email = us_email;
		this.us_senha = us_senha;
	}
	
	public Usuario(Usuario usuario) {
		super();
		this.us_id = usuario.getUs_id();
		this.us_diretorio_raiz = usuario.getUs_diretorio_raiz();
		this.us_nome = usuario.getUs_nome();
		this.us_email = usuario.getUs_email();
		this.us_cpf = usuario.getUs_cpf();
		this.us_nascimento = usuario.getUs_nascimento();
		this.us_username = usuario.getUs_username();
		this.us_senha = usuario.getUs_senha();
		this.us_permissao = usuario.getUs_permissao();
	}
	
	public Usuario() {
		
	}

	public int getUs_id() {
		return us_id;
	}

	public void setUs_id(Integer us_id) {
		this.us_id = us_id;
	}

	public String getUs_diretorio_raiz() {
		return us_diretorio_raiz;
	}

	public void setUs_diretorio_raiz(String us_diretorio_raiz) {
		this.us_diretorio_raiz = us_diretorio_raiz;
	}

	public String getUs_nome() {
		return us_nome;
	}

	public void setUs_nome(String us_nome) {
		this.us_nome = us_nome;
	}

	public String getUs_email() {
		return us_email;
	}

	public void setUs_email(String us_email) {
		this.us_email = us_email;
	}

	public String getUs_cpf() {
		return us_cpf;
	}

	public void setUs_cpf(String us_cpf) {
		this.us_cpf = us_cpf;
	}

	public LocalDate getUs_nascimento() {
		return us_nascimento;
	}

	public void setUs_nascimento(LocalDate us_nascimento) {
		this.us_nascimento = us_nascimento;
	}

	public String getUs_username() {
		return us_username;
	}

	public void setUs_username(String us_username) {
		this.us_username = us_username;
	}

	public String getUs_senha() {
		return us_senha;
	}

	public void setUs_senha(String us_senha) {
		this.us_senha = us_senha;
	}

	public String getUs_permissao() {
		return us_permissao;
	}

	public void setUs_permissao(String us_permissao) {
		this.us_permissao = us_permissao;
	}
	
		
}
