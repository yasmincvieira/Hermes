package main;

import controller.CadastroController;
import controller.LoginController;
import controller.Navegador;
import models.UsuarioDAO;
import view.Janela;
import view.TelaCadastro;
import view.TelaInicial;
import view.TelaLogin;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Janela janela = new Janela();
		Navegador navegador = new Navegador(janela);


		TelaCadastro telaCadastro = new TelaCadastro();
		CadastroController cadastroController = new CadastroController(telaCadastro, null, navegador);
		
		TelaInicial telaInicial = new TelaInicial();
		
		TelaLogin telaLogin = new TelaLogin();
		LoginController loginController = new LoginController(telaLogin, null, navegador);
		//telaLogin.adicionarOuvinte(loginController);

		

		navegador.adicionarPainel("CADASTRO", telaCadastro);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("INICIO", telaInicial);
		
		//Seta o jframe para abrir no meio da tela.
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		navegador.navegarPara("LOGIN");

	}

}
