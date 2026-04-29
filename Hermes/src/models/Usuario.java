package models;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String senha;
	private boolean admin;
	private String foto;

	// construtor

	public Usuario() {
	}

	public Usuario(int id, String nome, String email, String senha, boolean admin) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.admin = admin;
	}

	public String getFoto() { return foto; }
	public void setFoto(String foto) { this.foto = foto; }
	
	public String toString() {
		return this.id + ", " + this.nome + ", " + this.email + ", " + this.senha;
	}

	// Getters e setters.
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	

}