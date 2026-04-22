package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaCadastro;
import view.TelaConta;
import view.TelaLogin;

public class CadastroController {

	private TelaCadastro cadastro;
	private UsuarioDAO user;
	private Navegador navegador;
	private TelaConta conta;

	public CadastroController(TelaCadastro cadastro, UsuarioDAO user, Navegador navegador, TelaConta conta) {
		super();
		this.cadastro = cadastro;
		this.user = user;
		this.navegador = navegador;
		this.conta = conta;

		this.cadastro.cadastrar(e -> {
			verificarCadastroUsuario();
		});
		this.cadastro.voltar(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				navegador.navegarPara("LOGIN");
			}
		});

	}

	private void verificarCadastroUsuario() {
		List<Usuario> usuarios = user.listarUsuarios();
		
		if(cadastro.gettfUsuarioC().getText().isEmpty() 
			|| cadastro.gettfEmailC().getText().isEmpty() 
			|| cadastro.getpfSenhaC().getText().isEmpty()) {
			
			
			JOptionPane.showMessageDialog(cadastro, "Prencha todos os campos", "Atenção", JOptionPane.ERROR_MESSAGE);
			return;
		}
		Usuario novoUsuario = new Usuario();
		novoUsuario.setNome(cadastro.gettfUsuarioC().getText());
		novoUsuario.setEmail(cadastro.gettfEmailC().getText());
		novoUsuario.setSenha(cadastro.getpfSenhaC().getText());

		user.adicionarUsuario(novoUsuario);
		conta.preencherDados(novoUsuario);

		JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
		this.navegador.navegarPara("INICIO");

		limparCamposLogin();

	}

	public void limparCamposLogin() {
		cadastro.gettfEmailC().setText("");
		cadastro.gettfUsuarioC().setText("");
		cadastro.getpfSenhaC().setText("");
	}

}
