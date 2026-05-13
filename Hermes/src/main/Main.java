package main;

import java.awt.Font;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import controller.CadastroController;
import controller.ContaController;
import controller.HistoricoController;
import controller.HistoricoControllerADM;
import controller.InicialADMController;
import controller.InicialController;
import controller.LoginController;
import controller.Menu;
import controller.Navegador;
import controller.NovoChamadoController;
import models.ChamadoDAO;
import models.UsuarioDAO;
import view.Janela;
import view.MenuContraidoTeste;
import view.MenuExpandidoTeste;
import view.TelaCadastro;
import view.TelaConta;
import view.TelaHistoricoDeChamados;
import view.TelaHistoricoDeChamadosADM;
import view.TelaInicial;
import view.TelaInicialADM;
import view.TelaLogin;
import view.TelaNovoChamado;
import view.TelaTabelaPatrimonios;
import view.TelaVizuChamados;
import view.TelaVizuChamadosADM;

public class Main {
	public static void main(String[] args) {
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.PLAIN, 18)));

		ToolTipManager manager = ToolTipManager.sharedInstance();

		manager.setInitialDelay(100);
		manager.setDismissDelay(3000);
		manager.setReshowDelay(100);

		Janela janela = new Janela();
		UsuarioDAO usuarioDAO = new UsuarioDAO();

		TelaLogin telaLogin = new TelaLogin();
		TelaCadastro telaCadastro = new TelaCadastro();
		TelaConta telaConta = new TelaConta();
		TelaHistoricoDeChamados telaHistoricoChamados = new TelaHistoricoDeChamados();
		TelaInicial telaInicial = new TelaInicial();
		TelaInicialADM telaInicialADM = new TelaInicialADM();
		TelaNovoChamado telaNovoChamado = new TelaNovoChamado();
		TelaTabelaPatrimonios telaTabelaPatrimonios = new TelaTabelaPatrimonios();
		TelaVizuChamadosADM telaVizuChamadosADM = new TelaVizuChamadosADM();
		MenuContraidoTeste menuCont = new MenuContraidoTeste();
		MenuExpandidoTeste menuExp = new MenuExpandidoTeste();
		TelaInicialADM inicioADM = new TelaInicialADM();
		TelaVizuChamados telaVizuChamados = new TelaVizuChamados();
		TelaHistoricoDeChamadosADM telaHistoricoChamadosADM = new TelaHistoricoDeChamadosADM();

		Menu menu = new Menu(janela, menuExp, menuCont);
		Navegador navegador = new Navegador(janela, telaLogin, menu);
		menu.setNavegador(navegador);

		CadastroController cadastroController = new CadastroController(telaCadastro, usuarioDAO, navegador, telaConta);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador, menu);
		InicialController inicialController = new InicialController(telaInicial, navegador, menu);
		ContaController contaController = new ContaController(telaConta, usuarioDAO, navegador, menu); 
		ChamadoDAO chamadoDAO = new ChamadoDAO();
		NovoChamadoController novoChamadoController = new NovoChamadoController(telaNovoChamado, chamadoDAO, navegador);
		InicialADMController inicialAdmController = new InicialADMController(inicioADM, navegador, menu);
		HistoricoController historicoController = new HistoricoController(telaHistoricoChamados, telaVizuChamados, chamadoDAO, navegador);
		HistoricoControllerADM historicoControllerADM = new HistoricoControllerADM(telaHistoricoChamadosADM, telaVizuChamadosADM, chamadoDAO, navegador);
		
		navegador.setCadastroController(cadastroController);
		navegador.setLoginController(loginController);
		navegador.setInicialController(inicialController);
		navegador.setContaController(contaController);
		navegador.setHistoricoController(historicoController);
		navegador.setHistoricoControllerADM(historicoControllerADM);

		navegador.adicionarPainel("CADASTRO USUARIO", telaCadastro);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("INICIO", telaInicial);
		navegador.adicionarPainel("HISTORICO", telaHistoricoChamados);
		navegador.adicionarPainel("CHAMADO", telaNovoChamado);
		navegador.adicionarPainel("INICIO ADMIN", inicioADM);
		navegador.adicionarPainel("PATRIMONIO", telaTabelaPatrimonios);
		navegador.adicionarPainel("CHAMADO ADMIN", telaVizuChamadosADM);
		navegador.adicionarPainel("PERFIL", telaConta);
		navegador.adicionarPainel("DETALHES CHAMADO", telaVizuChamados);
		navegador.adicionarPainel("HISTORICO ADMIN", telaHistoricoChamadosADM);

		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");
		menu.iniciar();
	}

}
