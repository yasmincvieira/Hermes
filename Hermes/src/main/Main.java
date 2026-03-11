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
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		TelaCadastro telaCadastro = new TelaCadastro();
		CadastroController cadastroController = new CadastroController();
		
		TelaInicial telaInicial = new TelaInicial();
		
		TelaLogin telaLogin = new TelaLogin();
		LoginController loginController = new LoginController();
		//telaLogin.adicionarOuvinte(loginController);

		

		navegador.adicionarPainel("CADASTRO", telaCadastro);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("INICIO", telaInicial);
		

	}

}
