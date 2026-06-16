package models;

/**
 * Classe que representa um candidato.
 */
public class Patrimonio {

	private String nome, status;
	private int  id_patrimonio;
	private Espaco espaco;
	
	public Patrimonio() {
			
		}
		

	public Patrimonio(int id_patrimonio, String status, String nome, Espaco espaco) {
		this.id_patrimonio = id_patrimonio;
<<<<<<< HEAD
		this.status= status;
		this.nome = nome;
		this.espaco = espaco;
=======
		this.status = status;
	}

	public Patrimonio() {
		// TODO Auto-generated constructor stub
>>>>>>> origin/branchJulia_voltar
	}

	
	public void imprimir() {
		System.out.println("Id: " + this.id_patrimonio);
		System.out.println("Nome: " + this.nome);
		System.out.println("Status: " + this.status);
		System.out.println("##################################");
	}

<<<<<<< HEAD
	// Getters e setters.
=======
    public String getId() { return id_patrimonio; }
    public void setId(String id) { this.id_patrimonio = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public Espaco getEspaco() { return espaco; }
    public void setEspaco(Espaco espaco) { this.espaco = espaco; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

	public String getId_patrimonio() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setId_patrimonio(String string) {
		// TODO Auto-generated method stub
		
	}
>>>>>>> origin/branchJulia_voltar

}

<<<<<<< HEAD
	public void setStatus(String status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId_patrimonio() {
		return id_patrimonio;
	}

	public void setId_patrimonio(int id_patrimonio) {
		this.id_patrimonio = id_patrimonio;
	}
	
	public Espaco getEspaco() {
		return espaco;
	}

	public void setEspaco(Espaco espaco) {
		this.espaco = espaco;
		
	}

	
}
=======
>>>>>>> origin/branchJulia_voltar
