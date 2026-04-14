package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO {
	
	public void adicionarChamado(Chamado chamado) {
		String sql = "INSERT INTO novoChamado (nome, lugar, patrimonio, descricao) VALUES (?, ?, ?, ?)";
		Connection conexao = null;
        PreparedStatement pstm = null;
		
        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, chamado.getNome());
            pstm.setString(2, chamado.getLocal());
            pstm.setString(3, chamado.getIdPatrimonio());
            pstm.setString(4, chamado.getDescricao());
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

	public List<Chamado> listarChamados() {
		String sql = "SELECT * FROM novoChamado";
        List<Chamado> chamado = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Chamado chamados = new Chamado();
                chamados.setIdChamado(rset.getInt("idChamado"));
                chamados.setNome(rset.getString("nome"));
                chamados.setLocal(rset.getString("lugar"));
                chamados.setIdPatrimonio(rset.getString("idPatrimonio"));
                chamados.setDescricao(rset.getString("descricao"));
                chamado.add(chamados);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return chamado;
    }
	


	}
