package models;

/**
 * Classe que representa um candidato.
 */
public class Patrimonio {

	private String nome, tipo_patrimonio, id_patrimonio, status;
	private boolean contratado;

	public Patrimonio(String id_patrimonio, String status, String nome) {
		this.id_patrimonio = id_patrimonio;
		this.nome = status;
	}

	public void imprimir() {
		System.out.println("Id: " + this.id_patrimonio);
		System.out.println("Nome: " + this.nome);
		System.out.println("Status: " + this.status);
		System.out.println("##################################");
	}

	// Getters e setters.
	public String getIdpatrimonio() {
		return id_patrimonio;
	}

	public void setIdpatrimonio(String id_patrimonio) {
		this.id_patrimonio = id_patrimonio;
	}

	public String getStatus() {
		return nome;
	}

	public void setStatus(String status) {
		this.nome = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}