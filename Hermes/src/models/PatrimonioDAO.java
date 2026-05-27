package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import models.BancoDeDados;

public class PatrimonioDAO {

	private Statement ConexaoDB;

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
				Patrimonio patrimonio = new Patrimonio(sql, sql, sql);
				patrimonio.setId_patrimonio(rset.getString("idPatrimonio"));
				patrimonio.setNome(rset.getString("nome"));
				patrimonio.setStatus(rset.getString("status"));

				String espaco = rset.getString("idEspaco");

				EspacoDAO espacoDao = new EspacoDAO();
				Espaco espacoPatrimonio = espacoDao.BuscarEspacoPorID(espaco);

				patrimonio.setEspaco(espacoPatrimonio);
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
	public void atualizarUsuario(Patrimonio patrimonio) {
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
	
	public Patrimonio buscarPorId(String id) throws SQLException {
        String sql = "SELECT p.*, e.id AS espaco_id, e.nome AS espaco_nome " +
                     "FROM patrimonio p " +
                     "JOIN espaco e ON p.espaco_id = e.id " +
                     "WHERE p.id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Espaco espaco = new Espaco();
                espaco.setId(rs.getString("espaco_id"));
                espaco.setNomeLocal(rs.getString("espaco_nome"));

                Patrimonio p = new Patrimonio();
                p.setId(rs.getString("id"));
                p.setNome(rs.getString("nome"));
                p.setEspaco(espaco);
                p.setStatus(rs.getString("status"));
                return p;
            }
        }
        return null;
    }

    public boolean atualizar(Patrimonio p) throws SQLException {
        String sql = "UPDATE patrimonio SET nome = ?, espaco_id = ?, status = ? WHERE id = ?";

        try (Connection conn = ConexaoDB.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, p.getNome());
            ps.setString(2, p.getEspaco().getId()); // ✅ salva a FK do espaço
            ps.setString(3, p.getStatus());
            ps.setString(4, p.getId());             // ✅ ID como String

            return ps.executeUpdate() > 0;
        }
    }
}
