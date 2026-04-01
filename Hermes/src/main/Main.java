package main;

import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.CadastroController;
import controller.LoginController;
import controller.Navegador;
import models.UsuarioDAO;
import view.Janela;
import view.TelaCadastro;
import view.TelaConta;
import view.TelaHistoricoDeChamados;
import view.TelaInicial;
import view.TelaInicialADM;
import view.TelaLogin;
import view.TelaNovoChamado;
import view.TelaTabelaPatrimonios;
import view.TelaVizuChamadosADM;

/**
 * Classe responsável por inicializar os elementos das 3 camadas: model, view e controller.
 * A execução do programa começa por aqui.
 */
public class Main {
	public static void main(String[] args) {
		//Altera a fonte dos JOptionPane para Arial, 18.
		UIManager.put("OptionPane.messageFont", new FontUIResource(
				new Font("Arial", Font.PLAIN, 18)
				));

		Janela janela = new Janela();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		//View
		TelaLogin telaLogin= new TelaLogin();
		TelaCadastro telaCadastro = new TelaCadastro();
		TelaConta  telaConta= new TelaConta();
		TelaHistoricoDeChamados telaHistoricoChamados = new TelaHistoricoDeChamados();
		TelaInicial telaInicial = new TelaInicial();
		TelaInicialADM telaInicialADM = new TelaInicialADM();
		TelaNovoChamado telaNovoChamado = new TelaNovoChamado();
		TelaTabelaPatrimonios telaTabelaPatrimonios = new TelaTabelaPatrimonios();
		TelaVizuChamadosADM telaVizuChamadosADm = new TelaVizuChamadosADM();
		
		Navegador navegador = new Navegador(janela, telaLogin);
		CadastroController cadastroController = new CadastroController(telaCadastro, usuarioDAO, navegador);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador);
		
		
		navegador.setCadastroController(cadastroController);
		navegador.setLoginController(loginController);


		navegador.adicionarPainel("CADASTRO USUARIO", telaCadastro);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("INICIO", telaInicial);

		//Seta o jframe para abrir no meio da tela.
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");
	}
}
