package controller;

import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaLogin;

public class LoginController {

	private TelaLogin login;
	private UsuarioDAO user;
	private Navegador navegador;
	private Usuario usuarioLogado;

	public LoginController(TelaLogin login, UsuarioDAO user, Navegador navegador, Menu menu) {
		super();
		this.login = login;
		this.user = user;
		this.navegador = navegador;

		this.login.logar(e -> {
			verificarCadastroUsuario();
		});

		this.login.cadastrarse(e -> {
			navegador.navegarPara("CADASTRO USUARIO");

		});
	}

	private void verificarCadastroUsuario() {
		List<Usuario> usuarios = user.listarUsuarios();
		
		if(login.gettfUsuario().getText().isEmpty() || login.getpfSenha().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(login, "Prencha todos os campos", "Atenção", JOptionPane.ERROR_MESSAGE);
		}
		else {
			boolean usuarioEncontrado = false;

			for (Usuario user : usuarios) {

				if (user.getNome().equals(login.gettfUsuario().getText())
						&& user.getSenha().equals(login.getpfSenha().getText())) {

					usuarioLogado = user; // <- salva o usuário encontrado
					usuarioEncontrado = true;
					break;
				}
			}
			

				if (!usuarioEncontrado) {
					JOptionPane.showMessageDialog(login, "Usuário não encontrado", "Atenção", JOptionPane.WARNING_MESSAGE);
					return;
					
				}
				navegador.setUsuarioLogado(usuarioLogado); // <- passa para o navegador
				
				if (usuarioLogado.isAdmin()) {
		        navegador.navegarPara("INICIO ADMIN");
		    } else {
		        navegador.navegarPara("INICIO");
		    }
		}

	}

	public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

	public void limparCamposLogin() {
		login.gettfUsuario().setText("");
		login.getpfSenha().setText("");
	}

}
