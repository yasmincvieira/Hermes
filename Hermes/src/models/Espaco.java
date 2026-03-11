package models;

public class Espaco {
	private String bloco, andar, nome_local;

	/**
	 * Construtor da classe candidato.
	 * @param nome Nome do candidato.
	 * @param formacao Formação do candidato.
	 * @param areaDeInteresse Áreas de interesse do candidato.
	 * @param contratado Booleano para representar se o candidato se tornou um contratado.
	 */
	public Espaco(String bloco, String nome_local, String andar){
		this.nome_local = nome_local;
		this.bloco = bloco;
		this.andar = andar;
		
	}

	/**
	 * Método para exibir os dados do candidato.
	 */
	public void imprimir() {
		System.out.println("Nome: "+ this.nome_local);
		System.out.println("Formação: "+ this.bloco);
		System.out.println("Área de Interesse: "+ this.andar);
		//System.out.println("Contratado: "+ this.contratado);
		System.out.println("##################################");
	}

	//Getters e setters.
	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getAndar() {
		return andar;
	}

	public void setAndar(String descricao) {
		this.andar = andar;
	}
}