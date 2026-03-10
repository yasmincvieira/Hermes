package models;

/**
 * Classe que representa um candidato.
 */
public class Patrimonio {
	private String nome, tipo_patrimonio, id_patrimonio, status;
	private boolean contratado;

	/**
	 * Construtor da classe candidato.
	 * @param nome Nome do candidato.
	 * @param formacao Formação do candidato.
	 * @param areaDeInteresse Áreas de interesse do candidato.
	 * @param contratado Booleano para representar se o candidato se tornou um contratado.
	 */
	public Patrimonio(String id_patrimonio, String status, String tipo_patrimonio, String nome){
		this.id_patrimonio = id_patrimonio;
		this.nome = status;
		this.tipo_patrimonio = tipo_patrimonio;
		
	}

	/**
	 * Método para exibir os dados do candidato.
	 */
	public void imprimir() {
		System.out.println("Id: "+ this.id_patrimonio);
		System.out.println("Nome: "+ this.nome);
		System.out.println("Status: "+ this.status);
		System.out.println("##################################");
	}

	//Getters e setters.
	public String getStatus() {
		return nome;
	}

	public void setStatus(String status) {
		this.nome = status;
	}

	public String getDescricao() {
		return tipo_patrimonio;
	}

	public void setDescricao(String descricao) {
		this.tipo_patrimonio = descricao;
	}
}