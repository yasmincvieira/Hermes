package main;

import java.awt.Font;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import controller.CadastrarPatrimonioController;
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
import controller.TabelaController;
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
import view.TelaHistoricoDeChamadosADM;
import view.TelaInicial;
import view.TelaInicialADM;
import view.TelaLogin;
import view.TelaNovoChamado;
import view.TelaNovoChamadosADM;
import view.TelaTabelaPatrimonios;
import view.TelaVizuChamados;
import view.TelaVizuChamadosADM;
import view.TelinhaHistorico;

public class Main {
	public static void main(String[] args) {
		UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.PLAIN, 18)));

		ToolTipManager manager = ToolTipManager.sharedInstance();

		manager.setInitialDelay(100);
		manager.setDismissDelay(3000);
		manager.setReshowDelay(100);
		
		//DAO
		Janela janela = new Janela();

		UsuarioDAO usuarioDAO = new UsuarioDAO();

		ChamadoDAO chamadoDAO = new ChamadoDAO();

		PatrimonioDAO patrimonioDAO = new PatrimonioDAO();


		//Telas
		TelaLogin telaLogin = new TelaLogin();
		TelaCadastro telaCadastro = new TelaCadastro();
		TelaConta telaConta = new TelaConta();

		TelaContaADM telaContaADM = new TelaContaADM();
	

		TelaInicial telaInicial = new TelaInicial();
		TelaNovoChamado telaNovoChamado = new TelaNovoChamado();

		TelaNovoChamadosADM telaNovosChamadosADM = new TelaNovoChamadosADM();
		TelaTabelaPatrimonios telaTabelaPatrimonios = new TelaTabelaPatrimonios();


		TelaCadastrarPatrimonio telaCadastrarPatrimonio = new TelaCadastrarPatrimonio();
		TelaVizuChamados telaVizuChamados = new TelaVizuChamados();

		TelaInicialADM inicioADM = new TelaInicialADM();
		TelaVizuChamadosADM telaVizuChamadosADM = new TelaVizuChamadosADM();
		TelaHistoricoDeChamados telaHistoricoChamados = new TelaHistoricoDeChamados();
		TelaHistoricoDeChamadosADM telaHistoricoChamadosADM = new TelaHistoricoDeChamadosADM();
		//TelinhaHistorico telinhaHistorico = new TelinhaHistorico();

		MenuContraidoTeste menuCont = new MenuContraidoTeste();
		MenuExpandidoTeste menuExp = new MenuExpandidoTeste();
		Menu menu = new Menu(janela, menuExp, menuCont);
		Navegador navegador = new Navegador(janela, telaLogin, menu);
		menu.setNavegador(navegador);

		//Controllers
		CadastroController cadastroController = new CadastroController(telaCadastro, usuarioDAO, navegador, telaConta, menu);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador, menu);
		InicialController inicialController = new InicialController(telaInicial, navegador, menu);

		ContaController contaController = new ContaController(telaConta, usuarioDAO, navegador, menu); 
		NovoChamadoController novoChamadoController = new NovoChamadoController(telaNovoChamado, chamadoDAO, navegador, contaController);
		InicialADMController inicialAdmController = new InicialADMController(inicioADM, navegador, menu);
		HistoricoController historicoController = new HistoricoController(telaHistoricoChamados, telaVizuChamados, chamadoDAO, navegador);
		HistoricoControllerADM historicoControllerADM = new HistoricoControllerADM(telaNovosChamadosADM, telaHistoricoChamadosADM, telaVizuChamadosADM, chamadoDAO, navegador);
		

	
		TabelaController tabelaController = new TabelaController(telaTabelaPatrimonios, navegador, patrimonioDAO);
		CadastrarPatrimonioController cadastrarPatrimonio = new CadastrarPatrimonioController(telaCadastrarPatrimonio,
				patrimonioDAO, navegador, tabelaController, telaTabelaPatrimonios);
		
		telaTabelaPatrimonios.adicionarOuvinte(tabelaController);
;
//		Chamado chamado = new Chamado();
//		VizuChamadoController vizuChamadoController = new VizuChamadoController(telaVizuChamados, chamado, chamadoDAO,
//				navegador);


		navegador.setCadastroController(cadastroController);
		navegador.setLoginController(loginController);
		navegador.setInicialController(inicialController);
		navegador.setContaController(contaController);
		navegador.setHistoricoController(historicoController);
		navegador.setHistoricoControllerADM(historicoControllerADM);

		//Paineis
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
		navegador.adicionarPainel("NOVO CHAMADO ADMIN", telaNovosChamadosADM);

		navegador.adicionarPainel("PERFIL ADM", telaContaADM);
		navegador.adicionarPainel("CADASTRAR PATRIMONIO", telaCadastrarPatrimonio);


		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");
		menu.iniciar();
	}

}
