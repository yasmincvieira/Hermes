package controller;

import view.TelaInicialADM;

public class InicialADMController {

    private TelaInicialADM inicioADM;
    private Navegador navegador;
    private Menu menu;

<<<<<<< HEAD
    public InicialADMController(TelaInicialADM inicioADM, Navegador navegador, Menu menu) {
        this.inicioADM = inicioADM;
        this.navegador = navegador;
        this.menu = menu;
=======
	public InicialADMController(TelaInicialADM inicioADM, Navegador navegador, Menu menu) {
		super();
		this.inicioADM = inicioADM;
		this.navegador = navegador;
		this.menu = menu;
		
		this.inicioADM.historico(e -> {
			navegador.navegarPara("HISTORICO");
		});
>>>>>>> origin/branchJulia_voltar

        this.inicioADM.historico(e -> {
            navegador.navegarPara("HISTORICO ADMIN");
        });

<<<<<<< HEAD
        this.inicioADM.verPatrimonio(e -> {
            navegador.navegarPara("PATRIMONIO");
        });
=======
		this.inicioADM.verPerfil(e -> {
			navegador.navegarPara("PERFIL");
		});
		this.inicioADM.chamado(e -> {
			navegador.navegarPara("CHAMADO ADMIN");
		});
		this.inicioADM.verPatrimonio(e -> {
			navegador.navegarPara("TABELA");
		});
		
		this.inicioADM.irLogin(e -> {
			navegador.navegarPara("LOGIN");
		});
	}
>>>>>>> origin/branchJulia_voltar

        this.inicioADM.verPerfil(e -> {
            navegador.navegarPara("PERFIL ADM");
        });

        this.inicioADM.chamado(e -> {
            navegador.navegarPara("NOVO CHAMADO ADMIN");
        });
    }
}
