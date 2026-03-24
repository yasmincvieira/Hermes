package controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaCadastro;
import view.TelaLogin;

public class LoginController {
	
	private TelaLogin login;
	private UsuarioDAO usuarioDAO;
	private Navegador navegador;
	private Database db;
	private Object view;
	private Navegador controller;
	
	public LoginController(TelaLogin login, UsuarioDAO usuarioDAO, Navegador navegador) {
		super();
		this.login = login;
		this.usuarioDAO = usuarioDAO;
		this.navegador = navegador;
		
		this.login.logar(e -> {
			verificarCadastroUsuario();
		});
		
	}
	
	public void verificarCadastroUsuario() {
		
		List<Usuario> usuarios = usuarioDAO.listarUsuarios();
		
		if(login.getUsuario().isEmpty() || login.getSenha().isEmpty() ) {
			
			JOptionPane.showMessageDialog(null, "Preencha todos os campos");
			return;
		}
		else {
			boolean usuarioEncontrado = false;
			
			for (Usuario usuario : usuarios) {
				if(usuario.getNome().equals(login.getUsuario()) && 
				usuario.getSenha().equals(login.getSenha())) {
					
					usuarioEncontrado = true;
					break;
				}
			}
			
		if(usuarioEncontrado) {
			this.navegador.navegarPara("INICIO");
		}else {
			JOptionPane.showMessageDialog(null, "Usuario não encontrado!", "Informação",1);
		}
		
	}
		}
	public void limparCamposLogin() {
		login.setUsuario("");
		login.setSenha("");
	}
}
	
		
	
