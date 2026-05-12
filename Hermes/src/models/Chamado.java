package models;

import java.awt.Toolkit;

public class Chamado {
	private int idChamado;
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
        this.status = "Em análise";
    }
    public int getIdChamado() {
        return idChamado;
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
	
	public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}