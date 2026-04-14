package models;

public class Chamado {
	private int idChamado;
    private String nome;
    private String local;
    private int idPatrimonio;
    private String descricao;
    private String status;

    public Chamado() {}

    public Chamado(String nome, String local, int idPatrimonio, String descricao) {
        this.nome = nome;
        this.local = local;
        this.idPatrimonio = idPatrimonio;
        this.descricao = descricao;
    }

	//Getters e setters.
	public int getIdChamado() { return idChamado; }
    public void setIdChamado(int idChamado) { this.idChamado = idChamado; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLocal() { return local; }
    public void setLocal(String local) { this.local = local; }

    public int getIdPatrimonio() { return idPatrimonio; }
    public void setIdPatrimonio(int idPatrimonio) { this.idPatrimonio = idPatrimonio; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

	
}