package main;

import java.awt.Font;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.CadastrarPatrimonioController;
import controller.CadastroController;
import controller.ContaController;
import controller.InicialADMController;
import controller.InicialController;
import controller.LoginController;
import controller.Menu;
import controller.Navegador;
import controller.NovoChamadoController;
import controller.TabelaController;
import controller.VizuChamadoController;
import models.Chamado;
import models.ChamadoDAO;
import models.PatrimonioDAO;
import models.UsuarioDAO;
import view.Janela;
import view.MenuContraidoTeste;
import view.MenuExpandidoTeste;
import view.TelaCadastrarPatrimonio;
import view.TelaCadastro;
import view.TelaConta;
import view.TelaContaADM;
import view.TelaHistoricoDeChamados;
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
		PatrimonioDAO patrimonioDAO = new PatrimonioDAO();

		TelaLogin telaLogin = new TelaLogin();
		TelaCadastro telaCadastro = new TelaCadastro();
		TelaConta telaConta = new TelaConta();
		TelaContaADM telaContaADM = new TelaContaADM();
		TelaHistoricoDeChamados telaHistoricoChamados = new TelaHistoricoDeChamados();
		TelaInicial telaInicial = new TelaInicial();
		TelaNovoChamado telaNovoChamado = new TelaNovoChamado();
		TelaCadastrarPatrimonio telaCadastrarPatrimonio = new TelaCadastrarPatrimonio();
		TelaTabelaPatrimonios telaTabelaPatrimonios = new TelaTabelaPatrimonios();
		TelaVizuChamados telaVizuChamados = new TelaVizuChamados();
		TelaVizuChamadosADM telaVizuChamadosADm = new TelaVizuChamadosADM();
		TelaInicialADM inicioADM = new TelaInicialADM();

		MenuContraidoTeste menuCont = new MenuContraidoTeste();
		MenuExpandidoTeste menuExp = new MenuExpandidoTeste();
		Menu menu = new Menu(janela, menuExp, menuCont);

		Navegador navegador = new Navegador(janela, telaLogin, menu);
		menu.setNavegador(navegador);

		CadastroController cadastroController = new CadastroController(telaCadastro, usuarioDAO, navegador, telaConta);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador, menu);
		InicialController inicialController = new InicialController(telaInicial, navegador, menu);
		ContaController contaController = new ContaController(telaConta, usuarioDAO, navegador, menu);
		TabelaController tabelaController = new TabelaController(telaTabelaPatrimonios, navegador, patrimonioDAO);
		CadastrarPatrimonioController cadastrarPatrimonio = new CadastrarPatrimonioController(telaCadastrarPatrimonio,
				patrimonioDAO, navegador, tabelaController, telaTabelaPatrimonios);
		
		telaTabelaPatrimonios.adicionarOuvinte(tabelaController);

		ChamadoDAO chamadoDAO = new ChamadoDAO();
//		Chamado chamado = new Chamado();
		NovoChamadoController novoChamadoController = new NovoChamadoController(telaNovoChamado, chamadoDAO, navegador);
		InicialADMController inicialAdmController = new InicialADMController(inicioADM, navegador, menu);
//		VizuChamadoController vizuChamadoController = new VizuChamadoController(telaVizuChamados, chamado, chamadoDAO,
//				navegador);

		navegador.setCadastroController(cadastroController);
		navegador.setLoginController(loginController);
		navegador.setInicialController(inicialController);
		navegador.setContaController(contaController);

		navegador.adicionarPainel("CADASTRO USUARIO", telaCadastro);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("INICIO", telaInicial);
		navegador.adicionarPainel("HISTORICO", telaHistoricoChamados);
		navegador.adicionarPainel("CHAMADO", telaNovoChamado);
		navegador.adicionarPainel("INICIO ADMIN", inicioADM);
		navegador.adicionarPainel("PATRIMONIO", telaTabelaPatrimonios);
		navegador.adicionarPainel("CHAMADO ADMIN", telaVizuChamadosADm);
		navegador.adicionarPainel("PERFIL", telaConta);
		navegador.adicionarPainel("PERFIL ADM", telaContaADM);
		navegador.adicionarPainel("CADASTRAR PATRIMONIO", telaCadastrarPatrimonio);

		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");
		menu.iniciar();
	}

}
