package models;

public class Chamado {
	private String status, descricao, id_chamado, nome, local, idPatrimonio;

	public Chamado(String id_chamado, String status, String descricao, String nome, String local, String idPatrimonio) {
		this.id_chamado = id_chamado;
		this.status = status;
		this.descricao = descricao;
		this.nome = nome;
		this.local = local;
		this.idPatrimonio = idPatrimonio;
	}

	public void imprimir() {
		System.out.println("Nome: " + this.id_chamado);
		System.out.println("Formação: " + this.status);
		System.out.println("Área de Interesse: " + this.descricao);
		System.out.println("##################################");
	}

	// Getters e setters.
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome() {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal() {
		this.local = local;
	}

	public String getIdPatrimonio() {
		return idPatrimonio;
	}

	public void setIsPatrimonio() {
		this.idPatrimonio = idPatrimonio;
	}

}