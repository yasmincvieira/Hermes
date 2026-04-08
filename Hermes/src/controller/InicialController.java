package controller;

import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaInicial;

public class InicialController {
	
	private TelaInicial inicio;
	private Navegador navegador;
	private UsuarioDAO usuarioDAO;
	private Menu menu;
	
	public InicialController(TelaInicial inicio, UsuarioDAO usuarioDAO, Navegador navegador, Menu menu) {
		super();
		this.inicio = inicio;
		this.usuarioDAO = usuarioDAO;
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
