package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.BancoDeDados;

public class UsuarioDAO {

	// CREATE - Adicionar um novo usuário
	public void adicionarUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuarios (nome, email, senha, admin) VALUES (?, ?, ?, ?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet generatedKeys = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS); //" PreparedStatement.RETURN_GENERATED_KEYS" acrescentei isso pois quando é apagado uma conta e dps é feita ela novamente, dá erro no novoChamado e isso pede o id gerado de volta																			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			pstm.setBoolean(4, usuario.isAdmin());
			pstm.executeUpdate();
			generatedKeys = pstm.getGeneratedKeys();
			if (generatedKeys.next()) {
			     usuario.setId(generatedKeys.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
			  if (generatedKeys != null) {
				  try { generatedKeys.close(); } catch (SQLException e) { e.printStackTrace(); }
			  }
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
	public List<Usuario> listarUsuarios() {
		String sql = "SELECT * FROM usuarios";
		List<Usuario> usuarios = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; // Objeto que guarda o resultado da consulta

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rset.getInt("id"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setAdmin(rset.getBoolean("admin"));
				usuario.setFoto(rset.getString("foto"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
			// Fechar recursos
		}
		return usuarios;
	}

	// UPDATE - Atualizar um usuário existente
	public void atualizarUsuario(Usuario usuario) {
		String sql = "UPDATE usuarios SET nome = ?, email = ?, admin = ? WHERE id = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setBoolean(3, usuario.isAdmin());
			pstm.setInt(4, usuario.getId());

			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

	public void atualizarSenha(int id, String novaSenha) {
		String sql = "UPDATE usuarios SET senha = ? WHERE id = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;
		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, novaSenha);
			pstm.setInt(2, id);
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

	public void atualizarFoto(int id, String nomeFoto) {
		String sql = "UPDATE usuarios SET foto = ? WHERE id = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;
		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, nomeFoto);
			pstm.setInt(2, id);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}
	public int contarChamadosPorUsuario(int idUsuario) {
	    String sql = "SELECT COUNT(*) FROM novoChamado WHERE idUsuario = ?";
	    Connection conexao = null;
	    PreparedStatement pstm = null;
	    ResultSet rset = null;
	    try {
	        conexao = BancoDeDados.conectar();
	        pstm = conexao.prepareStatement(sql);
	        pstm.setInt(1, idUsuario);
	        rset = pstm.executeQuery();
	        if (rset.next()) {
	            return rset.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        BancoDeDados.desconectar(conexao);
	    }
	    return 0;
	}
	
	public void excluirChamadosDoUsuario(int idUsuario) {
	    String sql = "DELETE FROM novoChamado WHERE idUsuario = ?";
	    Connection conexao = null;
	    PreparedStatement pstm = null;
	    try {
	        conexao = BancoDeDados.conectar();
	        pstm = conexao.prepareStatement(sql);
	        pstm.setInt(1, idUsuario);
	        pstm.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        BancoDeDados.desconectar(conexao);
	    }
	}
}
