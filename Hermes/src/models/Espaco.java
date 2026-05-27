package models;

public class Espaco {
	private String bloco, andar, nome_local;

	/**
	 * Construtor da classe candidato.
	 * 
	 * @param nome            Nome do candidato.
	 * @param formacao        Formação do candidato.
	 * @param areaDeInteresse Áreas de interesse do candidato.
	 * @param contratado      Booleano para representar se o candidato se tornou um
	 *                        contratado.
	 */
	public Espaco(String bloco, String nome_local, String andar) {
		this.nome_local = nome_local;
		this.bloco = bloco;
		this.andar = andar;

	}
	
	@Override
	public String toString() {
	    return nome; // exibe o nome do espaço no ComboBox
	}

	public Espaco() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Método para exibir os dados do candidato.
	 */
	public void imprimir() {
		System.out.println("Nome: " + this.nome_local);

		System.out.println("Bloco: " + this.bloco);
		System.out.println("Andar: " + this.andar);

		System.out.println("##################################");
	}

	// Getters e setters.
	public String getNomeLocal() {
		return nome_local;
	}

	public void setNomeLocal(String nome_local) {
		this.nome_local = nome_local;
	}

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

	public void setId(String string) {
		// TODO Auto-generated method stub
		
	}

	public String getId() {
		// TODO Auto-generated method stub
		return null;
	}
}