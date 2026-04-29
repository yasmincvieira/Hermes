package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChamadoDAO {
	
	public void adicionarChamado(Chamado chamado) {
		String sql = "INSERT INTO novoChamado (nome, lugar, idPatrimonio, descricao) VALUES (?, ?, ?, ?)";
		Connection conexao = null;
        PreparedStatement pstm = null;
		
        try {
            conexao = BancoDeDados.conectar();
            if (conexao == null) {
                throw new SQLException("Não foi possível conectar ao banco de dados.");
            }
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, chamado.getNome());
            pstm.setString(2, chamado.getLocal());
            if (chamado.getIdPatrimonio() != null) {
                pstm.setInt(3, chamado.getIdPatrimonio());
            } else {
                pstm.setNull(3, java.sql.Types.INTEGER);
            }
            
            pstm.setString(4, chamado.getDescricao());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar no banco: " + e.getMessage());
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
        List<Chamado> listaChamados = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Chamado chamado = new Chamado(rset.getString("nome"), rset.getString("lugar"), rset.getInt("idPatrimonio"), rset.getString("descricao") );
                listaChamados.add(chamado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return listaChamados;
    }

	}