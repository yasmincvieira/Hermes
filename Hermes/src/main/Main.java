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
<<<<<<< HEAD
		ChamadoDAO chamadoDAO = new ChamadoDAO();
=======
		PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
>>>>>>> origin/BranchLara_17

		//Telas
		TelaLogin telaLogin = new TelaLogin();
		TelaCadastro telaCadastro = new TelaCadastro();
		TelaConta telaConta = new TelaConta();
<<<<<<< HEAD
=======
		TelaContaADM telaContaADM = new TelaContaADM();
		TelaHistoricoDeChamados telaHistoricoChamados = new TelaHistoricoDeChamados();
>>>>>>> origin/BranchLara_17
		TelaInicial telaInicial = new TelaInicial();
		TelaNovoChamado telaNovoChamado = new TelaNovoChamado();
<<<<<<< HEAD
		TelaNovoChamadosADM telaNovosChamadosADM = new TelaNovoChamadosADM();
		TelaTabelaPatrimonios telaTabelaPatrimonios = new TelaTabelaPatrimonios();
		MenuContraidoTeste menuCont = new MenuContraidoTeste();
		MenuExpandidoTeste menuExp = new MenuExpandidoTeste();
=======
		TelaCadastrarPatrimonio telaCadastrarPatrimonio = new TelaCadastrarPatrimonio();
		TelaTabelaPatrimonios telaTabelaPatrimonios = new TelaTabelaPatrimonios();
		TelaVizuChamados telaVizuChamados = new TelaVizuChamados();
		TelaVizuChamadosADM telaVizuChamadosADm = new TelaVizuChamadosADM();
>>>>>>> origin/BranchLara_17
		TelaInicialADM inicioADM = new TelaInicialADM();
		TelaVizuChamados telaVizuChamados = new TelaVizuChamados();
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
		CadastroController cadastroController = new CadastroController(telaCadastro, usuarioDAO, navegador, telaConta);
		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador, menu);
		InicialController inicialController = new InicialController(telaInicial, navegador, menu);
<<<<<<< HEAD
		ContaController contaController = new ContaController(telaConta, usuarioDAO, navegador, menu); 
		NovoChamadoController novoChamadoController = new NovoChamadoController(telaNovoChamado, chamadoDAO, navegador);
		InicialADMController inicialAdmController = new InicialADMController(inicioADM, navegador, menu);
		HistoricoController historicoController = new HistoricoController(telaHistoricoChamados, telaVizuChamados, chamadoDAO, navegador);
		HistoricoControllerADM historicoControllerADM = new HistoricoControllerADM(telaNovosChamadosADM, telaHistoricoChamadosADM, telaVizuChamadosADM, chamadoDAO, navegador);
		
=======
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

>>>>>>> origin/BranchLara_17
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
<<<<<<< HEAD
		navegador.adicionarPainel("DETALHES CHAMADO", telaVizuChamados);
		navegador.adicionarPainel("HISTORICO ADMIN", telaHistoricoChamadosADM);
		navegador.adicionarPainel("NOVO CHAMADO ADMIN", telaNovosChamadosADM);
=======
		navegador.adicionarPainel("PERFIL ADM", telaContaADM);
		navegador.adicionarPainel("CADASTRAR PATRIMONIO", telaCadastrarPatrimonio);
>>>>>>> origin/BranchLara_17

		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");
		menu.iniciar();
	}

}
