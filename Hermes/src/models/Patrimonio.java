package models;

/**
 * Classe que representa um candidato.
 */
public class Patrimonio {

	private String nome, id_patrimonio, status;
	private Espaco espaco;

	public Patrimonio(String id_patrimonio, String status, String nome) {
		this.id_patrimonio = id_patrimonio;
		this.nome = status;
	}

	public Patrimonio() {
		// TODO Auto-generated constructor stub
	}

	public void imprimir() {
		System.out.println("Id: " + this.id_patrimonio);
		System.out.println("Nome: " + this.nome);
		System.out.println("Status: " + this.status);
		System.out.println("##################################");
	}

    public String getId() { return id_patrimonio; }
    public void setId(String id) { this.id_patrimonio = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Espaco getEspaco() { return espaco; }
    public void setEspaco(Espaco espaco) { this.espaco = espaco; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

}

