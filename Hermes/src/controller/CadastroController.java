package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaCadastro;
import view.TelaLogin;

public class CadastroController {
	
	private TelaCadastro cadastro;
	private UsuarioDAO user;
	private Navegador navegador;

	public CadastroController(TelaCadastro cadastro, UsuarioDAO user, Navegador navegador) {
		super();
		this.cadastro = cadastro;
		this.user = user;
		this.navegador = navegador;
		
		this.cadastro.cadastrar(e -> {
			verificarCadastroUsuario();
		});
		
	}
	

	private void verificarCadastroUsuario() {
		List<Usuario> usuarios = user.listarUsuarios();
		
		if(cadastro.gettfUsuarioC().getText().isEmpty() 
			|| cadastro.gettfEmailC().getText().isEmpty() 
			|| cadastro.gettfSenhaC().getText().isEmpty()) {
			
			
			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
			return;
		}
		Usuario novoUsuario = new Usuario();
	    novoUsuario.setNome(cadastro.gettfUsuarioC().getText());
	    novoUsuario.setEmail(cadastro.gettfEmailC().getText());
	    novoUsuario.setSenha(cadastro.getpfSenhaC().getText());
	  
	    user.adicionarUsuario(novoUsuario); 
	    
	    JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
	    
	    limparCamposLogin();
		
	}
	
	public void limparCamposLogin() {
		cadastro.gettfEmailC().setText("");
		cadastro.gettfUsuarioC().setText("");
		cadastro.getpfSenhaC().setText("");
	}
	
	

}
