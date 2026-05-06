package models;

import java.awt.Toolkit;

public class Chamado {
	private String idChamado;
<<<<<<< HEAD
	private String nome;
	private String local;
	private Integer idPatrimonio;
	private String descricao;
	private String status;

	public Chamado(String nome, String local, Integer idPatrimonio, String descricao) {
		this.nome = nome;
		this.local = local;
		this.idPatrimonio = idPatrimonio;
		this.descricao = descricao;
	}

	// Getters e setters.
	public String getNome() {
		return nome;
	}
=======
    private String nome;
    private String local;
    private Integer idPatrimonio;
    private String descricao;
    private String status;
    private Integer idUsuario;

    public Chamado(String nome, String local, Integer idPatrimonio, String descricao, Integer idUsuario) {
        this.nome = nome;
        this.local = local;
        this.idPatrimonio = idPatrimonio;
        this.descricao = descricao;
        this.idUsuario = idUsuario;
    }

    public String getNome() { 
    	return nome; 
    }
    
    public void setNome(String nome) { 
    	this.nome = nome; 
    }
>>>>>>> 9a3f6d310398054299a6dbd98444b5b808d912c1

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocal() {
		return local;
	}

<<<<<<< HEAD
	public void setLocal(String local) {
		this.local = local;
	}

	public Integer getIdPatrimonio() {
		return idPatrimonio;
	}

	public void setIdPatrimonio(Integer idPatrimonio) {
		this.idPatrimonio = idPatrimonio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
=======
    public String getDescricao() { 
    	return descricao; 
    }
    
    public void setDescricao(String descricao) { 
    	this.descricao = descricao; 
    }
    
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    
>>>>>>> 9a3f6d310398054299a6dbd98444b5b808d912c1

}