package controller;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaCadastro;


/**
 * Classe responsável pela comunicação entre a view (TelaCadastro) e o model (candidatoDAO).
 */
public class CadastroController {
	private final TelaCadastro view;
	private final UsuarioDAO model;
	private final Navegador navegador;

	/**
	 * Construtor da classe
	 * @param view Referência à tela que controla (TelaCadastro).
	 * @param model Referência ao modelo de dados (CandidatoDAO).
	 * @param navegador Referência ao elemento que faz a transição de telas.
	 */
	public CadastroController(TelaCadastro view, UsuarioDAO model, Navegador navegador) {
		this.view = view;
		this.model = model;
		this.navegador = navegador;

		//Define o que será executado quando o botão 'Cadastrar' da TelaCadastro for clicado.
		this.view.btnCadastrar(e -> {
			String nome = view.getNome();
			String email = view.getEmail();
			String senha = view.getSenha();
			

			if(!nome.equals("") && !email.equals("") && !senha.equals("")) {

				Usuario user = new Usuario(0, nome, email, senha);
				
				model.adicionarUsuario(user);
				
				view.exibirMensagem("Sucesso", "Usuário cadastrado", 1);
			}

			else {
				this.view.exibirMensagem("Erro", "Preencha todos os campos!", 0);
			}
		});

		//Define o que será executado quando o botão 'Próximo' da TelaCadastro for clicado.
		this.view btnProximo(e -> {
			if(model.listarusuarios().size() > 0)
				this.navegador.navegarPara("LOGIN");
			else
				this.view.exibirMensagem("Erro", "Nenhum candidato cadastrado! Cadastre antes de avançar." , 0);
		});


}
