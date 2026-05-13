package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.BancoDeDados;

public class PatrimonioDAO {

	// CREATE - Adicionar um novo usuário
	public void adicionarPatrimonio(Patrimonio patrimonio) {
		String sql = "INSERT INTO patrimonio (idPatrimonio, status, nome) VALUES (?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, patrimonio.getId_patrimonio());
			pstm.setString(2, patrimonio.getStatus());
			pstm.setString(3, patrimonio.getNome());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// READ - Listar todos os patrimônios
	public List<Patrimonio> listarpatrimonio() {
		String sql = "SELECT * FROM patrimonio";
		List<Patrimonio> listaPatrimonio = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; // Objeto que guarda o resultado da consulta

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Patrimonio patrimonio = new Patrimonio(sql, sql, sql, sql);
				patrimonio.setId_patrimonio(rset.getString("idPatrimonio"));
				patrimonio.setNome(rset.getString("nome"));
				patrimonio.setStatus(rset.getString("status"));

				String espaco = rset.getString("idEspaco");

				EspacoDAO espacoDao = new EspacoDAO();
				Espaco espacoPatrimonio = espacoDao.BuscarEspacoPorID(espaco);

				patrimonio.setEspaco(espaco);
				listaPatrimonio.add(patrimonio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
			// Fechar recursos
		}
		return listaPatrimonio;
	}

	// UPDATE - Atualizar um patrimônio existente
	public void atualizarPatrimonio(Patrimonio patrimonio) {
		String sql = "UPDATE patrimonio SET nome = ?, email = ? WHERE id = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, patrimonio.getNome());
			pstm.setString(2, patrimonio.getStatus());
			pstm.setString(3, patrimonio.getId_patrimonio());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

	// DELETE - Excluir um patrimonio pelo ID
	public void excluirPatrimonio(String idPatrimonio) {
		String sql = "DELETE FROM patrimonio WHERE id = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, idPatrimonio);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

}
