package controller;

import javax.swing.JPanel;
import javax.swing.JTextField;
import models.Usuario;
import view.Janela;
import view.TelaLogin;

public class Navegador {

	private Janela janela;
	private TelaLogin login;
	private LoginController loginController;
	private CadastroController cadastroController;
	private InicialController inicialController;
	private Menu menu;
	private Usuario usuarioLogado;
	private ContaController contaController;
	private HistoricoController historicoController;

	public Navegador(Janela janela, TelaLogin login, Menu menu) {
		this.janela = janela;
		this.login = login;
		this.menu = menu;
	}

	public void adicionarPainel(String nome, JPanel tela) {
		this.janela.adicionarTela(nome, tela);
	}

	public void navegarPara(String nome) {
		this.janela.mostrarTela(nome);

		if (nome.equals("LOGIN") || nome.equals("CADASTRO USUARIO") || nome.equals("INICIO")) {
			menu.removerMenu();
		} else {
			menu.mostrarPanelCont();
		}
		if (nome.equals("PERFIL") && usuarioLogado != null) {
			contaController.preencherDados();
		}
		if (nome.equals("HISTORICO") && historicoController != null) {
            historicoController.carregarHistorico();
        }
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

	public Menu getMenu(Menu menu) {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuario) {
		this.usuarioLogado = usuario;
	}

	public void setContaController(ContaController contaController) {
		this.contaController = contaController;
	}
	
	public void setHistoricoController(HistoricoController historicoController) {
		this.historicoController = historicoController;
	}

}
