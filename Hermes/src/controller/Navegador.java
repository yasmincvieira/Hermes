package controller;

import javax.swing.JPanel;

import view.Janela;
import view.TelaLogin;

public class Navegador {
	
	private Janela janela;

	TelaLogin telaLogin = new TelaLogin();

	public Navegador(Janela janela,  TelaLogin telaLogin) {
		this.janela = janela;
		
		this.telaLogin = telaLogin;

		this.telaLogin.logar(e ->{
		navegarPara("INICIO");

		});

}
		
	public void adicionarPainel(String nome, JPanel tela) {
		this.janela.adicionarTela(nome, tela);
	}
	
	/**
	 * Método responsável por chamar o método da view que navega para outra tela.
	 * @param nome Nome da tela.
	 */
	public void navegarPara(String nome) {
		this.janela.mostrarTela(nome);
	}
	
	/**
	 * Método responsável por chamar o método da view que fecha a aplicação.
	 */
	public void sair() {
		this.janela.dispose();
	}

}
