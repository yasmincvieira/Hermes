package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar todos os candidatos 
 * cadastrados durante a execução da aplicação. Os candidatos
 * são armazenados em um Arraylist.
 */
public class UsuarioDAO {
	private final ArrayList<Usuario> cadastro;

	/**
	 * Construtor.
	 */
	public UsuarioDAO() {
		this.cadastro = new ArrayList<>();
	}

	/**
	 * Método responsável por adicionar um candidato à lista de candidatos.
	 * @param candidato Candidato que será adicionado na lista.
	 */
	public void cadastrar(Usuario usuario) {
		if (usuario != null) {
			this.cadastro.add(usuario);
		}
	}

	/**
	 * Método responsável por recuperar a lista de candidatos.
	 * @return Arraylist com a lista de candidatos.
	 */
	public List<Usuario> listarTodos() {
		return new ArrayList<>(this.cadastro);
	}

	/**
	 * Método responsável por buscar por nome um candidato na lista de candidatos cadastrados.
	 * @param nome Nome do candidato que se deseja buscar.
	 * @return O candidato caso ele seja encontrado e null caso contrário.
	 */
	public Usuario buscarPorNome(String nome) {
		for (Usuario candidato : this.cadastro) {
			if (candidato.getNome().equalsIgnoreCase(nome)) {
				return candidato;
			}
		}
		return null;
	}

	/**
	 * Método responsável por atualizar um candidato da lista. 
	 * Ao encontrar o candidato pelo nome, altera-se o elemento na lista pelo recebido por parâmetro. 
	 * @param candidatoAtualizado Candidato com os dados atualizados.
	 * @return
	 */
	public boolean atualizar(Usuario candidatoAtualizado) {
		for (int i = 0; i < this.cadastro.size(); i++) {
			Usuario candidatoExistente = this.cadastro.get(i);

			if (candidatoExistente.getNome().equalsIgnoreCase(candidatoAtualizado.getNome())) {
				this.cadastro.set(i, candidatoAtualizado);
				return true;
			}
		}
		return false;
	}
//
//	/**
//	 * Método responsável por alterar o status de todos 
//	 * os candidatos da lista para 'contratado'.
//	 */
//	public void contratarTodos() {
//		for (int i = 0; i < this.listaDeCandidatos.size(); i++) {
//			this.listaDeCandidatos.get(i).setContratado(true);
//		}
//	}
//
//	/**
//	 * Método responsável por alterar o status de todos
//	 * os candidatos da lista para 'candidato'.
//	 */
//	public void demitirTodos() {
//		for (int i = 0; i < this.listaDeCandidatos.size(); i++) {
//			this.listaDeCandidatos.get(i).setContratado(false);
//		}
	}