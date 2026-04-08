package controller;

import java.awt.Menu;
import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaLogin;

public class LoginController {
	
	private TelaLogin login;
	private UsuarioDAO user;
	private Navegador navegador;
	private Menu menu;
	
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
			//menu.removerMenu();
		});
	}

	private void verificarCadastroUsuario() {
		List<Usuario> usuarios = user.listarUsuarios();
		
		if(login.gettfUsuario().getText().isEmpty() || login.getpfSenha().getText().isEmpty()) {
			
			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
		}
		else {
			boolean usuarioEncontrado = false;
			
			for(Usuario user : usuarios) {
				
				if(user.getNome().equals(login.gettfUsuario().getText()) 
					&& user.getSenha().equals(login.getpfSenha().getText())){
					
					usuarioEncontrado = true;
					break;
				}
			}
			
			if(usuarioEncontrado == true) {
				this.navegador.navegarPara("INICIO");
			}
			else {
				JOptionPane.showMessageDialog(null, "Usuário não encontrado");
			}
		}
		
	}
	
	public void limparCamposLogin() {
		login.gettfUsuario().setText("");
		login.getpfSenha().setText("");
	}
	

}
