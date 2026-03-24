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
        String sql = "INSERT INTO patrimonio (id_patrimonio, status, nome) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, patrimonio.getIdpatrimonio());
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

    // READ - Listar todos os usuários
    public List<Patrimonio> listarpatrimonio() {
        String sql = "SELECT * FROM patrimonio";
        List<Patrimonio> patrimonio = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Patrimonio patrimonios = new Patrimonio(sql, sql, sql);
                patrimonios.setIdpatrimonio(rset.getString("id"));
                patrimonios.setNome(rset.getString("nome"));
                patrimonios.setStatus(rset.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return patrimonio;
    }

    // UPDATE - Atualizar um usuário existente
    public void atualizarUsuario(Patrimonio patrimonio) {
        String sql = "UPDATE patrimonio SET nome = ?, email = ? WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, patrimonio.getNome());
            pstm.setString(2, patrimonio.getStatus());
            pstm.setString(3, patrimonio.getIdpatrimonio());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        BancoDeDados.desconectar(conexao);
        }
    }

    // DELETE - Excluir um usuário pelo ID
    public void excluirPatrimonio(String id_patrimonio) {
        String sql = "DELETE FROM patrimonio WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, id_patrimonio);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        BancoDeDados.desconectar(conexao);
        }
    }
}

