package controller;

import javax.swing.JOptionPane;
import models.Usuario;
import view.MensagemSN;
import view.TelaInicialADM;

public class InicialADMController {

    private TelaInicialADM inicioADM;
    private Navegador navegador;
    private Menu menu;

    public InicialADMController(TelaInicialADM inicioADM, Navegador navegador, Menu menu ) {
    	super();
        this.inicioADM = inicioADM;
        this.navegador = navegador;
        this.menu = menu;
		
        this.inicioADM.historico(e -> {
            navegador.navegarPara("HISTORICO ADMIN");
        });
        this.inicioADM.verPatrimonio(e -> {
            navegador.navegarPara("PATRIMONIO");
        });
		this.inicioADM.verPerfil(e -> {
			navegador.navegarPara("PERFIL ADM");
		});
		this.inicioADM.chamado(e -> {
			navegador.navegarPara("NOVO CHAMADO ADMIN");
		});
		this.inicioADM.verPatrimonio(e -> {
			navegador.navegarPara("TABELA");
		});
        this.inicioADM.irLogin(e -> verificarIrLogin());
	}

		private void verificarIrLogin() {
		    MensagemSN.mostrarSN(
		        "Tem certeza que deseja voltar a tela de login?",
		        "Confirmação",
		        e -> {
		            navegador.setUsuarioLogado(null);
		            navegador.navegarPara("LOGIN");
		        },
		        e -> {}
		    );
		}
}
