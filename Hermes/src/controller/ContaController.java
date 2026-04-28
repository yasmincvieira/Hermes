package controller;

import java.util.List;

import javax.swing.JOptionPane;

import models.Usuario;
import models.UsuarioDAO;
import view.TelaConta;


public class ContaController {

	private TelaConta conta;
	private UsuarioDAO user;
	private Navegador navegador;

	public ContaController(TelaConta conta, UsuarioDAO user, Navegador navegador, Menu menu) {
		super();
		this.conta = conta;
		this.user = user;
		this.navegador = navegador;

		this.conta.excluirConta(e -> {
			verificarExcluir();

		});

		this.conta.atualizarConta(e -> {
			atualizar();

		});
	}
	private void verificarExcluir() {
		
	}
	private void atualizar() {

	}	 
    	

}
