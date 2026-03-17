package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspacoDAO {

    // CREATE - Adicionar um novo usuário
    public void adicionarEspaco(Espaco espaco) {
        String sql = "INSERT INTO espacos (bloco, nome_local, andar) VALUES (?, ?, ?)";
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
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // READ - Listar todos os espaco
    public List<Espaco> listarEspacos() {
        String sql = "SELECT * FROM espaco";
        List<Espaco> espacos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Espaco espaco = new Espaco(sql, sql, sql);
                espaco.setBloco(rset.getString("bloco"));
                espaco.setNomeLocal(rset.getString("nome"));
                espaco.setAndar(rset.getString("Andar"));
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

    // UPDATE - Atualizar um usuário existente
    public void atualizarEspaco(Espaco espaco) {
        String sql = "UPDATE espacos SET bloco = ?, andar = ? WHERE nome_local = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, espaco.getNomeLocal());
            pstm.setString(2, espaco.getBloco());
            pstm.setString(3, espaco.getAndar());
            
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
    // DELETE - Excluir um usuário pelo ID
    public void excluirEspaco(String nome_local) {
        String sql = "DELETE FROM espacos WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(2, nome_local);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
}
