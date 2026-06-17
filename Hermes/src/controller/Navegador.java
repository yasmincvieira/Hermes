package controller;

import javax.swing.JPanel;
import javax.swing.JTextField;
import models.Patrimonio;
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
    private TabelaController tabelaController;
    private Patrimonio patrimonioAdicionado;

//	private Janela janela;
//	private TelaLogin login;
//	private LoginController loginController;
//	private CadastroController cadastroController;
//	private InicialController inicialController;
//	private Menu menu;
//	private Usuario usuarioLogado;
//	private ContaController contaController;

	private ContaADMController contaADMController;
	//private HistoricoController historicoController;
	private HistoricoControllerADM historicoControllerADM;

	//private Patrimonio patrimonioAdicionado;

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

        if (nome.equals("LOGIN") || nome.equals("CADASTRO USUARIO")) {
            menu.removerMenu();
        } else if (nome.equals("INICIO ADMIN")) {
            menu.mostrarPanelExpAdmInicio();
        } else if (nome.equals("INICIO")) {
            menu.mostrarPanelExpInicio();
        } else {
            menu.mostrarPanelCont();
        }

        if (nome.equals("PERFIL") && usuarioLogado != null) {
            contaController.preencherDados();
            contaController.atualizarContagem(); 
        }
        if (nome.equals("PERFIL ADM") && usuarioLogado != null && contaADMController != null) {
            contaADMController.preencherDados();
        }
        if (nome.equals("HISTORICO") && historicoController != null) {
            historicoController.carregarHistorico();
        }
        if ((nome.equals("NOVO CHAMADO ADMIN") || nome.equals("HISTORICO ADMIN")) && historicoControllerADM != null) {
            historicoControllerADM.carregarChamados();
        }
        if (nome.equals("TABELA") && tabelaController != null) {
            tabelaController.atualizarTabela();
        }
    }

    public void sair() {
        this.janela.dispose();
    }

    public void setLoginController(LoginController loginController) {
        this.loginController = loginController;
    }

    public void setCadastroController(CadastroController cadastroController) {
        this.cadastroController = cadastroController;
    }

    public void setInicialController(InicialController inicialController) {
        this.inicialController = inicialController;
    }
   
    public void setTabelaController(TabelaController tabelaController) {
        this.tabelaController = tabelaController;
    }

    public void setContaController(ContaController contaController) {
        this.contaController = contaController;
    }

    public void setHistoricoController(HistoricoController historicoController) {
        this.historicoController = historicoController;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setUsuarioLogado(Usuario usuario) {
        this.usuarioLogado = usuario;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

	
	public Patrimonio getPatrimonioAdicionado() {
		return patrimonioAdicionado;
	}

	public void setPatrimonioAdicionado(Patrimonio patrimonio) {
		this.patrimonioAdicionado = patrimonio;
	}

	
	public void setHistoricoControllerADM (HistoricoControllerADM historicoControllerADM) {
		this.historicoControllerADM   = historicoControllerADM;
	}
	public void setContaADMController(ContaADMController contaADMController) {
	    this.contaADMController = contaADMController;
	}

}

