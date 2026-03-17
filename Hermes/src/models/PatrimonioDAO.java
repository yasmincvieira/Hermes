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
        String sql = "INSERT INTO patrimonios (idPatrimonio, status, nome) VALUES (?, ?, ?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, patrimonio.getIdPatrimonio());
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
//    public List<Patrimonio> listarPatrimonio() {
//        String sql = "SELECT * FROM patrimonios";
//        List<Patrimonio> patrimonios = new ArrayList<>();
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
//                Patrimonio patrimonio = new Patrimonio(sql, sql, sql);
//                patrimonio.setIdpatrimonio(rset.getString("idPatrimonio"));
//                patrimonio.setNome(rset.getString("nome"));
//                patrimonio.add(patrimonio);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//        	BancoDeDados.desconectar(conexao);
//            // Fechar recursos
//        }
//        return patrimonios;
//    }

    // UPDATE - Atualizar um usuário existente
    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nome = ?, email = ? WHERE id = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getNome());
            pstm.setString(2, usuario.getEmail());
            pstm.setInt(3, usuario.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }

    // DELETE - Excluir um usuário pelo ID
    public void excluirUsuario(int id) {
        String sql = "DELETE FROM usuarios WHERE id = ?";
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
