package controller;

import javax.swing.JPanel;
import javax.swing.JTextField;

import view.Janela;
import view.TelaLogin;

/**
 * Classe responsável por gerenciar a troca de telas.
 */
public class Navegador {

	private Janela janela;
	private TelaLogin login;
	private LoginController loginController;
	private CadastroController cadastroController;
	private InicialController inicialController;

	/**
	 * Construtor da classe.
	 * @param janela Referência ao JFrame.
	 */
	public Navegador(Janela janela, TelaLogin login) {
		this.janela = janela;
		this.login = login;
	}

	/**
	 * Método responsável por chamar o método da view que adiciona as telas ao painel principal.
	 * @param nome Nome do painel.
	 * @param tela Painel que será adicionado.
	 */
	public void adicionarPainel(String nome, JPanel tela) {
		this.janela.adicionarTela(nome, tela);
	}

	public void navegarPara(String nome) {
		this.janela.mostrarTela(nome);
	}

	/**
	 * Método responsável por chamar o método da view que fecha a aplicação.
	 */
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
