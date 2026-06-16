package main;

import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.ToolTipManager;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import controller.CadastrarPatrimonioController;
import controller.CadastroController;
import controller.ContaADMController;
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
import models.PatrimonioDAO;
import view.Janela;
import view.MenuContraidoTeste;
import view.MenuExpandidoAdm;
import view.MenuExpandidoTeste;
import view.TelaCadastrarPatrimonio;
import view.TelaCadastro;
import view.TelaConta;
import view.TelaContaADM;
import view.TelaEditarPatrimonio;
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
		PatrimonioDAO patrimonioDAO = new PatrimonioDAO();


		ChamadoDAO chamadoDAO = new ChamadoDAO();

		


		//Telas
		TelaLogin telaLogin = new TelaLogin();
		TelaCadastro telaCadastro = new TelaCadastro();
		TelaConta telaConta = new TelaConta();
		TelaContaADM telaContaADM = new TelaContaADM();
		TelaHistoricoDeChamados telaHistoricoChamados = new TelaHistoricoDeChamados();
		TelaInicial telaInicial = new TelaInicial();
		TelaNovoChamado telaNovoChamado = new TelaNovoChamado();

		TelaNovoChamadosADM telaNovosChamadosADM = new TelaNovoChamadosADM();
		TelaTabelaPatrimonios telaTabelaPatrimonios = new TelaTabelaPatrimonios();
		TelaVizuChamadosADM telaVizuChamadosADM = new TelaVizuChamadosADM();
		MenuContraidoTeste menuCont = new MenuContraidoTeste();
		MenuExpandidoTeste menuExp = new MenuExpandidoTeste();
		MenuExpandidoAdm menuExpAdm = new MenuExpandidoAdm();
		
		TelaInicialADM inicioADM = new TelaInicialADM();
		TelaVizuChamados telaVizuChamados = new TelaVizuChamados();
		TelaTabelaPatrimonios telaTabelaParimonios = new TelaTabelaPatrimonios();
		TelaEditarPatrimonio telaEditarPatrimonio = new TelaEditarPatrimonio();
		TelaCadastrarPatrimonio telaCadastrarPatrimonio =  new TelaCadastrarPatrimonio();
		


		
		TelaHistoricoDeChamadosADM telaHistoricoChamadosADM = new TelaHistoricoDeChamadosADM();
		//TelinhaHistorico telinhaHistorico = new TelinhaHistorico();

		
		Menu menu = new Menu(janela, menuExp, menuCont, menuExpAdm);
		Navegador navegador = new Navegador(janela, telaLogin, menu);
		menu.setNavegador(navegador);
		

		//Controllers
		CadastroController cadastroController = new CadastroController(telaCadastro, usuarioDAO, navegador, telaConta, menu);
		InicialController inicialController = new InicialController(telaInicial, navegador, menu);

		
		ContaController contaController = new ContaController(telaConta,telaContaADM, usuarioDAO, navegador, menu);
		ContaADMController contaADMController = new ContaADMController(telaContaADM, usuarioDAO, navegador, menu);
		NovoChamadoController novoChamadoController = new NovoChamadoController(telaNovoChamado, chamadoDAO, navegador, contaController);
		InicialADMController inicialAdmController = new InicialADMController(inicioADM, navegador, menu);
		HistoricoController historicoController = new HistoricoController(telaHistoricoChamados, telaVizuChamados, chamadoDAO, navegador);
		HistoricoControllerADM historicoControllerADM = new HistoricoControllerADM(telaNovosChamadosADM, telaHistoricoChamadosADM, telaVizuChamadosADM, chamadoDAO, navegador);
		

		TabelaController tabelaController = new TabelaController (telaTabelaPatrimonios, telaEditarPatrimonio, telaCadastrarPatrimonio, patrimonioDAO, navegador, menu);
		
		CadastrarPatrimonioController cadastrarPatrimonio = new CadastrarPatrimonioController(telaCadastrarPatrimonio,
				patrimonioDAO, navegador, tabelaController, telaTabelaPatrimonios);
		
		telaTabelaPatrimonios.adicionarOuvinte(tabelaController);


		LoginController loginController = new LoginController(telaLogin, usuarioDAO, navegador, menu, telaInicial);
		 
		
		
		
		
		
		navegador.setTabelaController(tabelaController);
		navegador.setCadastroController(cadastroController);
		navegador.setLoginController(loginController);
		navegador.setInicialController(inicialController);
		navegador.setContaController(contaController);
		navegador.setContaADMController(contaADMController); 
		navegador.setHistoricoController(historicoController);
		navegador.setHistoricoControllerADM(historicoControllerADM);

		//Paineis
		navegador.adicionarPainel("CADASTRO USUARIO", telaCadastro);
		navegador.adicionarPainel("LOGIN", telaLogin);
		navegador.adicionarPainel("INICIO", telaInicial);
		navegador.adicionarPainel("HISTORICO", telaHistoricoChamados);
		navegador.adicionarPainel("CHAMADO", telaNovoChamado);
		navegador.adicionarPainel("INICIO ADMIN", inicioADM);
	
		navegador.adicionarPainel("CHAMADO ADMIN", telaVizuChamadosADM);
		navegador.adicionarPainel("PERFIL", telaConta);

		
		navegador.adicionarPainel("PERFIL ADM", telaContaADM);
		navegador.adicionarPainel("TABELA", telaTabelaPatrimonios);
		navegador.adicionarPainel("CADASTRAR PATRIMONIO", telaCadastrarPatrimonio);
		navegador.adicionarPainel("HISTORICO ADMIN", telaHistoricoChamadosADM);
		navegador.adicionarPainel("NOVO CHAMADO ADMIN", telaNovosChamadosADM);
		navegador.adicionarPainel("NOVOS_CHAMADOS", telaVizuChamados);
		navegador.adicionarPainel("EDITAR PATRIMONIO", telaEditarPatrimonio);
		

		navegador.adicionarPainel("DETALHES CHAMADO", telaVizuChamados);
		


		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

		navegador.navegarPara("LOGIN");
		menu.iniciar();
	}

}
