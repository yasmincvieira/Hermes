package controller;

import javax.swing.JPanel;
import javax.swing.JTextField;

import view.Janela;
import view.TelaLogin;

public class Navegador {

	private Janela janela;
	private TelaLogin login;
	private LoginController loginController;
	private CadastroController cadastroController;
	private InicialController inicialController;

	
	public Navegador(Janela janela, TelaLogin login) {
		this.janela = janela;
		this.login = login;
	}

	public void adicionarPainel(String nome, JPanel tela) {
		this.janela.adicionarTela(nome, tela);
	}

	public void navegarPara(String nome) {
		this.janela.mostrarTela(nome);
	}

	public void sair() {
		this.janela.dispose();
	}
	public LoginController getloginController() {
		return loginController;
	}
	
	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
	}
	
	public CadastroController getCadastroController() {
		return cadastroController;
	}
	
	public void setCadastroController(CadastroController cadastroController) {
		this.cadastroController = cadastroController;	
	}
	
	public InicialController getInicialController(InicialController inicialController) {
		return inicialController;
	}
	
	public void setInicialController(InicialController inicialController) {
		this.inicialController = inicialController;	
	}
	
    

}
