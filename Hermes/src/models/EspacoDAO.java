package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspacoDAO {

    public void adicionarEspaco(Espaco espaco) {
        String sql = "INSERT INTO espaco (bloco, nome_local, andar) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, espaco.getBloco());
            pstm.setString(2, espaco.getNomeLocal());
            pstm.setString(3, espaco.getAndar());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }

<<<<<<< HEAD
	// READ - Listar todos os espaco
	public List<Espaco> listarEspacos() {
		String sql = "SELECT * FROM espacos";
		List<Espaco> espacos = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; // Objeto que guarda o resultado da consulta
=======
    // ✅ método renomeado para listarTodos() — usado na TelaEditarPatrimonio
    public List<Espaco> listarTodos() {
        String sql = "SELECT * FROM espaco";
        List<Espaco> espacos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
>>>>>>> origin/branchJulia_voltar

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

<<<<<<< HEAD
			while (rset.next()) {
				Espaco espaco = new Espaco(sql, sql, sql);
				espaco.setBloco(rset.getString("bloco"));
				espaco.setNomeLocal(rset.getString("nome_local"));
				espaco.setAndar(rset.getString("andar"));
				espacos.add(espaco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
			// Fechar recursos
		}
		return espacos;
	}
=======
            while (rset.next()) {
                Espaco espaco = new Espaco();                         
                espaco.setBloco(rset.getString("bloco"));
                espaco.setNomeLocal(rset.getString("nome_local"));    
                espaco.setAndar(rset.getString("andar"));             
                espacos.add(espaco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
        return espacos;
    }
>>>>>>> origin/branchJulia_voltar

    public Espaco BuscarEspacoPorID(String nome_local) {
        String sql = "SELECT * FROM espaco WHERE nome_local = ?"; 
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, nome_local);
            rset = pstm.executeQuery();

            if (rset.next()) {
                Espaco espaco = new Espaco();                        
                espaco.setBloco(rset.getString("bloco"));
                espaco.setNomeLocal(rset.getString("nome_local"));
                espaco.setAndar(rset.getString("andar"));
                return espaco;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
        return null;
    }
}