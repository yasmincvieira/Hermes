package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ChamadoDAO {
	private final ArrayList<Chamado> listaDeChamado;

	public ChamadoDAO() {
		this.listaDeChamado = new ArrayList<>();
	}

	public void adicionar(Chamado chamado) {
		if (chamado != null) {
			this.listaDeChamado.add(chamado);
		}
	}

//	public List<Chamado> listarChamados() {
//		return new ArrayList<>(this.listaDeChamado);
//		String sql = "SELECT * FROM chamado";
//        List<Chamado> chamado = new ArrayList<>();
//        Connection conexao = null;
//        PreparedStatement pstm = null;
//        ResultSet rset = null; // Objeto que guarda o resultado da consulta
//
//        try {
//            conexao = BancoDeDados.conectar();
//            pstm = conexao.prepareStatement(sql);
//            rset = pstm.executeQuery();
//
//            while (rset.next()) {
//                Chamado chamado = new Chamado(0, sql, sql, sql);
//                chamado.setId(rset.getInt("idChamado"));
//                chamado.setNome(rset.getString("nome"));
//                chamado.setLocal(rset.getString("lugar"));
//                chamado.setIdPatrimonio(rset.getInt("IdPatrimonio"));
//                chamado.add(null);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//        	BancoDeDados.desconectar(conexao);
//            // Fechar recursos
//        }
//        return chamado;
//    }
	

	public Chamado buscarPorNome(String nome) {
		for (Chamado candidato : this.listaDeChamado) {
			if (candidato.getDescricao().equalsIgnoreCase(nome)) {
				return candidato;
			}
		}
		return null;
	}

	
	public boolean atualizar(Chamado chamadoAtualizado) {
		for (int i = 0; i < this.listaDeChamado.size(); i++) {
			Chamado candidatoExistente = this.listaDeChamado.get(i);

			if (candidatoExistente.getStatus().equalsIgnoreCase(chamadoAtualizado.getStatus())) {
				this.listaDeChamado.set(i, chamadoAtualizado);
				return true;
			}
		}
		return false;
	}

//	public void contratarTodos() {
//		for (int i = 0; i < this.listaDeChamado.size(); i++) {
//			this.listaDeChamado.get(i).setContratado(true);
//		}
//	}
//
//	/**
//	 * Método responsável por alterar o status de todos
//	 * os candidatos da lista para 'candidato'.
//	 */
//	public void demitirTodos() {
//		for (int i = 0; i < this.listaDeChamado.size(); i++) {
//			this.listaDeChamado.get(i).setContratado(false);
//		}
	}
