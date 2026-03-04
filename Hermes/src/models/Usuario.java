package models;

public class Usuario {
	private int id;
    private String nome;
    private String email;
    private String senha;

    // construtor
    public Usuario(int id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public String toString() {
    	return this.id + ", " + this.nome + ", " + this.email + ", " +  this.senha;
    }
}
