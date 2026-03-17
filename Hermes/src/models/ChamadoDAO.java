package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.BancoDeDados;

public class ChamadoDAO {

    // CREATE - Adicionar um novo usuário
    public void adicionarUsuario(Chamado chamado) {
        String sql = "INSERT INTO chamados (id_chamado, status, descricao) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;
//        String id_chamado, String status, String descricao

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, chamado.getId_chamado());
            pstm.setString(2, chamado.getStatus());
            pstm.setString(3, chamado.getDescricao());
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
    public List<Chamado> listarChamados() {
        String sql = "SELECT * FROM chamados";
        List<Chamado> chamados = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Chamado chamado = new Chamado (sql, sql, sql);
                chamado.setId_chamado(rset.getString("id_chamado"));
                chamado.setStatus(rset.getString("status"));
                chamado.setDescricao(rset.getString("descricao"));
                chamados.add(chamado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return chamados;
    }

    // UPDATE - Atualizar um usuário existente
    public void atualizarChamado(Chamado chamado) {
        String sql = "UPDATE chamados SET status = ?, WHERE id_chamado = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(2, chamado.getStatus());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }

    // DELETE - Excluir um usuário pelo ID
    public void excluirChamado(int id) {
        String sql = "DELETE FROM chamados WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
}
