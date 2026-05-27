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

    // ✅ método renomeado para listarTodos() — usado na TelaEditarPatrimonio
    public List<Espaco> listarTodos() {
        String sql = "SELECT * FROM espaco";
        List<Espaco> espacos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Espaco espaco = new Espaco();                          // ✅ era new Espaco(sql,sql,sql)
                espaco.setId_espaco(rset.getString("id_espaco"));      // ✅ carrega o ID
                espaco.setBloco(rset.getString("bloco"));
                espaco.setNomeLocal(rset.getString("nome_local"));     // ✅ era "nome"
                espaco.setAndar(rset.getString("andar"));              // ✅ era "Andar" (case-sensitive)
                espacos.add(espaco);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
        return espacos;
    }

    public Espaco BuscarEspacoPorID(String id_espaco) {
        String sql = "SELECT * FROM espaco WHERE id_espaco = ?"; // ✅ busca por ID, não nome_local
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, id_espaco);
            rset = pstm.executeQuery();

            if (rset.next()) {
                Espaco espaco = new Espaco();                          // ✅ era new Espaco(sql,sql,sql)
                espaco.setId_espaco(rset.getString("id_espaco"));      // ✅ carrega o ID
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