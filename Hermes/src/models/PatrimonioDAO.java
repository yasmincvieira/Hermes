package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatrimonioDAO {

<<<<<<< HEAD
	// CREATE - Adicionar um novo usuário
	public void adicionarPatrimonio(Patrimonio patrimonio) {
		String sql = "INSERT INTO patrimonio (idPatrimonio, status, nome, idEspaco) VALUES (?, ?, ?, ?)";
		Connection conexao = null;
		
		PreparedStatement pstm = null;
		
		EspacoDAO espacoDao = new EspacoDAO();
		

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, patrimonio.getId_patrimonio());
			pstm.setString(2, patrimonio.getStatus());
			pstm.setString(3, patrimonio.getNome());
			pstm.setString(4, patrimonio.getEspaco().getNomeLocal());
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
=======
    // CREATE
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
                try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }
>>>>>>> origin/branchJulia_voltar

    // READ - Listar todos
    public List<Patrimonio> listarpatrimonio() {
        String sql = "SELECT * FROM patrimonio";
        List<Patrimonio> listaPatrimonio = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

<<<<<<< HEAD
			while (rset.next()) {
				Patrimonio patrimonio = new Patrimonio();
				patrimonio.setId_patrimonio(rset.getInt("idPatrimonio"));
			    patrimonio.setNome(rset.getString("nome"));
			    patrimonio.setStatus(rset.getString("status"));
=======
            while (rset.next()) {
                Patrimonio patrimonio = new Patrimonio();
                patrimonio.setId_patrimonio(rset.getString("idPatrimonio"));
                patrimonio.setNome(rset.getString("nome"));
                patrimonio.setStatus(rset.getString("status"));
>>>>>>> origin/branchJulia_voltar

                String idEspaco = rset.getString("idEspaco");
                EspacoDAO espacoDao = new EspacoDAO();
                Espaco espacoPatrimonio = espacoDao.BuscarEspacoPorID(idEspaco);
                patrimonio.setEspaco(espacoPatrimonio);

<<<<<<< HEAD
				EspacoDAO espacoDao = new EspacoDAO();
				Espaco espacoPatrimonio = espacoDao.BuscarEspacoPorID(espaco);
				
				

				patrimonio.setEspaco(espacoPatrimonio);
				listaPatrimonio.add(patrimonio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
	
		}
		return listaPatrimonio;
	}

	// UPDATE - Atualizar um patrimônio existente
	public void atualizarPatrimonio(Patrimonio patrimonio) {
		String sql = "UPDATE patrimonio SET nome = ?, status = ?, idEspaco = ? WHERE idPatrimonio = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, patrimonio.getNome());
			pstm.setString(2, patrimonio.getStatus());
			pstm.setString(3, patrimonio.getEspaco().getNomeLocal());
			pstm.setInt(4, patrimonio.getId_patrimonio());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

	// DELETE - Excluir um patrimonio pelo ID
	public void excluirPatrimonio(int idPatrimonio) {
		String sql = "DELETE FROM patrimonio WHERE idPatrimonio = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, idPatrimonio);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

}
=======
                listaPatrimonio.add(patrimonio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }
        return listaPatrimonio;
    }

  
    public Patrimonio buscarPorId(String id) {
        String sql =
            "SELECT p.idPatrimonio, p.nome, p.status, p.idEspaco, " +
            "e.nome_local, e.bloco, e.andar " +
            "FROM patrimonio p " +
            "JOIN espaco e ON p.idEspaco = e.nome_local " +
            "WHERE p.idPatrimonio = ?";

        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, id);
            rset = pstm.executeQuery();

            if (rset.next()) {
                Espaco espaco = new Espaco();
                espaco.setId_espaco(rset.getString("nome_local")); // ← corrigido
                espaco.setNomeLocal(rset.getString("nome_local"));
                espaco.setBloco(rset.getString("bloco"));
                espaco.setAndar(rset.getString("andar"));

                Patrimonio patrimonio = new Patrimonio();
                patrimonio.setId_patrimonio(rset.getString("idPatrimonio"));
                patrimonio.setNome(rset.getString("nome"));
                patrimonio.setStatus(rset.getString("status"));
                patrimonio.setEspaco(espaco);

                return patrimonio;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            BancoDeDados.desconectar(conexao);
        }

        return null;
    }

    public boolean atualizar(Patrimonio p) {
        String sql = "UPDATE patrimonio SET nome = ?, idEspaco = ?, status = ? WHERE idPatrimonio = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar(); 
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setString(2, p.getEspaco().getNomeLocal());
            pstm.setString(3, p.getStatus());
            pstm.setString(4, p.getId_patrimonio());      
            return pstm.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try { pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
            }
        }
    }

    // DELETE
    public void excluirPatrimonio(String idPatrimonio) {
        String sql = "DELETE FROM patrimonio WHERE idPatrimonio = ?";
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
>>>>>>> origin/branchJulia_voltar
