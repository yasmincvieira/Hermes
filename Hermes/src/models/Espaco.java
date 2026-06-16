package models;

public class Espaco {
    private String id_espaco, bloco, andar, nome_local; 

    public Espaco(String id_espaco, String bloco, String nome_local, String andar) {
        this.id_espaco = id_espaco;
        this.nome_local = nome_local;
        this.bloco = bloco;
        this.andar = andar;
    }

    public Espaco() {}


    public void imprimir() {
        System.out.println("ID: " + this.id_espaco);
        System.out.println("Nome: " + this.nome_local);
        System.out.println("Bloco: " + this.bloco);
        System.out.println("Andar: " + this.andar);
        System.out.println("##################################");
    }

  
    public String getId_espaco() { return id_espaco; }
    public void setId_espaco(String id_espaco) { this.id_espaco = id_espaco; }

    public String getNomeLocal() { return nome_local; }
    public void setNomeLocal(String nome_local) { this.nome_local = nome_local; }

    public String getBloco() { return bloco; }
    public void setBloco(String bloco) { this.bloco = bloco; }


	public String getAndar() {
		return andar;
	}

	public void setAndar(String andar) {
		this.andar = andar;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome_local+" - "+this.bloco + " - "+this.andar;
	}
}