package controller;

import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaInicial;

public class InicialController {

	private TelaInicial inicio;
	private Navegador navegador;
	private Menu menu;

	public InicialController(TelaInicial inicio, Navegador navegador, Menu menu) {
		super();
		this.inicio = inicio;
		this.navegador = navegador;
		this.menu = menu;
		this.inicio.historico(e -> {
			navegador.navegarPara("HISTORICO");
		});

		this.inicio.irChamado(e -> {
			navegador.navegarPara("CHAMADO");
		});
	}

}
