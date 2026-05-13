package models;

/**
 * Classe que representa um candidato.
 */
public class Patrimonio {

	private String nome, id_patrimonio, status, espaco;

	public Patrimonio(String id_patrimonio, String status, String nome, String espaco) {
		this.id_patrimonio = id_patrimonio;
		this.status= status;
		this.nome = nome;
		this.espaco = espaco;
	}

	public void imprimir() {
		System.out.println("Id: " + this.id_patrimonio);
		System.out.println("Nome: " + this.nome);
		System.out.println("Status: " + this.status);
		System.out.println("##################################");
	}

	// Getters e setters.

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getId_patrimonio() {
		return id_patrimonio;
	}

	public void setId_patrimonio(String id_patrimonio) {
		this.id_patrimonio = id_patrimonio;
	}

	public String getEspaco() {
		return espaco;
	}

	public void setEspaco(String espaco2) {
		this.espaco = espaco;
		
	}

	
}