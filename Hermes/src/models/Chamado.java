package models;

/**
 * Classe que representa um candidato.
 */
public class Chamado {
	private String status, descricao, id_chamado;

	/**
	 * Construtor da classe candidato.
	 * @param nome Nome do candidato.
	 * @param formacao Formação do candidato.
	 * @param areaDeInteresse Áreas de interesse do candidato.
	 * @param contratado Booleano para representar se o candidato se tornou um contratado.
	 */
	public Chamado(String id_chamado, String status, String descricao){
		this.id_chamado = id_chamado;
		this.status = status;
		this.descricao = descricao;
		
	}

	/**
	 * Método para exibir os dados do candidato.
	 */
	public void imprimir() {
		System.out.println("Id chamado: "+ this.id_chamado);
		System.out.println("Status: "+ this.status);
		System.out.println("descricao: "+ this.descricao);
		System.out.println("##################################");
	}

	//Getters e setters.
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

	public String getId_chamado() {
		// TODO Auto-generated method stub
		return id_chamado;
	}
	public String setId_chamado(String id_chamado) {
		// TODO Auto-generated method stub
		return id_chamado;
	}
}