package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar todos os candidatos 
 * cadastrados durante a execução da aplicação. Os candidatos
 * são armazenados em um Arraylist.
 */
public class ChamadoDAO {
	private final ArrayList<Chamado> listaDeChamado;

	/**
	 * Construtor.
	 */
	public ChamadoDAO() {
		this.listaDeChamado = new ArrayList<>();
	}

	/**
	 * Método responsável por adicionar um candidato à lista de candidatos.
	 * @param chamado Candidato que será adicionado na lista.
	 */
	public void adicionar(Chamado chamado) {
		if (chamado != null) {
			this.listaDeChamado.add(chamado);
		}
	}

	/**
	 * Método responsável por recuperar a lista de candidatos.
	 * @return Arraylist com a lista de candidatos.
	 */
	public List<Chamado> listarTodos() {
		return new ArrayList<>(this.listaDeChamado);
	}

	/**
	 * Método responsável por buscar por nome um candidato na lista de candidatos cadastrados.
	 * @param nome Nome do candidato que se deseja buscar.
	 * @return O candidato caso ele seja encontrado e null caso contrário.
	 */
	public Chamado buscarPorNome(String nome) {
		for (Chamado candidato : this.listaDeChamado) {
			if (candidato.getDescricao().equalsIgnoreCase(nome)) {
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
	public boolean atualizar(Chamado chamadoAtualizado) {
		for (int i = 0; i < this.listaDeChamado.size(); i++) {
			Chamado candidatoExistente = this.listaDeChamado.get(i);

			if (candidatoExistente.getStatus().equalsIgnoreCase(chamadoAtualizado.getStatus())) {
				this.listaDeChamado.set(i, chamadoAtualizado);
				return true;
			}
		}
		return false;
	}

	/**
	 * Método responsável por alterar o status de todos 
	 * os candidatos da lista para 'contratado'.
	 */
//	public void contratarTodos() {
//		for (int i = 0; i < this.listaDeChamado.size(); i++) {
//			this.listaDeChamado.get(i).setContratado(true);
//		}
////	}
//
//	/**
//	 * Método responsável por alterar o status de todos
//	 * os candidatos da lista para 'candidato'.
//	 */
//	public void demitirTodos() {
//		for (int i = 0; i < this.listaDeChamado.size(); i++) {
//			this.listaDeChamado.get(i).setContratado(false);
//		}
	}
