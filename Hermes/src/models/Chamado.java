package models;

import java.awt.Toolkit;

public class Chamado {
	private int idChamado;
    private String nome;
    private String local;
    private String idPatrimonio;
    private String descricao;
    private String status;

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
	
    public void setIdChamado(int idChamado) { 
    	this.idChamado = idChamado; 
    }

    public String getNome() { 
    	return nome; 
    }
    
    public void setNome(String nome) { 
    	this.nome = nome; 
    }

    public String getLocal() { 
    	return local; 
    }
    
    public void setLocal(String local) { 
    	this.local = local; 
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