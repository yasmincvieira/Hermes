package controller;

import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaInicial;
import view.TelaInicialADM;

public class InicialADMController {

	private TelaInicialADM inicioADM;
	private Navegador navegador;
	private Menu menu;

	public InicialADMController(TelaInicialADM inicioADM, Navegador navegador, Menu menu) {
		super();
		this.inicioADM = inicioADM;
		this.navegador = navegador;
		this.menu = menu;
		this.inicioADM.historico(e -> {
			navegador.navegarPara("HISTORICO");
		});

		this.inicioADM.patrimonio(e -> {
			navegador.navegarPara("PATRIMONIO");
		});
		this.inicioADM.verPerfil(e -> {
			navegador.navegarPara("PERFIL");
		});
		this.inicioADM.chamado(e -> {
			navegador.navegarPara("CHAMADO ADMIN");
		});
	}

}
