package controller;

import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import models.UsuarioDAO;
<<<<<<< HEAD
import view.Mensagem;
=======
import view.TelaInicial;
>>>>>>> origin/branchJulia_voltar
import view.TelaLogin;

public class LoginController {

	private TelaLogin login;
	private UsuarioDAO user;
	private Navegador navegador;
	private Usuario usuarioLogado;
	private Menu menu;
	private TelaInicial inicio;

	public LoginController(TelaLogin login, UsuarioDAO user, Navegador navegador, Menu menu, TelaInicial inicio) {
		super();
		this.login = login;
		this.user = user;
		this.navegador = navegador;
		this.menu = menu;
		this.inicio = inicio;

		this.login.logar(e -> {
			verificarCadastroUsuario();
		});

		this.login.cadastrarse(e -> {
			navegador.navegarPara("CADASTRO USUARIO");

		});
	}

	private void verificarCadastroUsuario() {
		List<Usuario> usuarios = user.listarUsuarios();

		if (login.gettfUsuario().getText().isEmpty() || login.getpfSenha().getText().isEmpty()) {

			Mensagem.mostrar("Prencha todos os campos", "Atenção");		
			} else {
			boolean usuarioEncontrado = false;

			for (Usuario user : usuarios) {

				if (user.getNome().equals(login.gettfUsuario().getText())
						&& user.getSenha().equals(login.getpfSenha().getText())) {

					usuarioLogado = user;
					usuarioEncontrado = true;
					break;
				}
			}

			if (!usuarioEncontrado) {
				Mensagem.mostrar("Usuário não encontrado", "Atenção");				
				return;

			}
			navegador.setUsuarioLogado(usuarioLogado);
			this.menu.setUsuarioLogado(usuarioLogado); 

			if (usuarioLogado.isAdmin()) {
				navegador.navegarPara("INICIO ADMIN");
			} else {
				navegador.navegarPara("INICIO");
			}
		}
		limparCamposLogin();
	}


	public void limparCamposLogin() {
		login.gettfUsuario().setText("");
		login.getpfSenha().setText("");
	}

}
