package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ChamadoDAO {
	
	public void adcionarChamado(Chamado chamado) {
		String sql = "INSERT INTO produtos (id, nome, local, patrimonio) VALUES (?, ?, ?, ?)";
		
		try (Connection conn = BancoDeDados.conectar();
	            PreparedStatement stmt = conn.prepareStatement(sql)) {
	
	           stmt.setString(1, chamado.getNome());
	           stmt.setString(2, chamado.getLocal());
	           stmt.setInt(3, chamado.getIdPatrimonio());
	           stmt.executeUpdate();
	           System.out.println("Chamado feito com sucesso!");
	
	       } catch (SQLException e) {
	           System.err.println("Erro ao fazer chamado: " + e.getMessage());
	       }
   }
	
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
//                Chamado chamado = new Chamado(sql, sql, sql, sql);
//                chamado.setNome(rset.getString("nome"));
//                chamado.setLocal(rset.getString("lugar"));
//                chamado.setIdPatrimonio(rset.getInt("IdPatrimonio"));
//                chamado.setDescricao(rset.getString("descricao"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//        	BancoDeDados.desconectar(conexao);
//            
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


	}
