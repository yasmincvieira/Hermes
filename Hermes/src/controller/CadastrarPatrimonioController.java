package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import models.Patrimonio;
import models.PatrimonioDAO;
import models.UsuarioDAO;
import view.TelaCadastrarPatrimonio;
import view.TelaCadastro;
import view.TelaConta;
import view.TelaTabelaPatrimonios;

public class CadastrarPatrimonioController extends ComponentAdapter{

	private TelaCadastrarPatrimonio cadastrarPatrimonio;
	private PatrimonioDAO patrimonioDAO;
	private Navegador navegador;
	private TabelaController tabelaController;
	private TelaTabelaPatrimonios tabelaPatrimonios;

	public CadastrarPatrimonioController(TelaCadastrarPatrimonio cadastrarPatrimonio, PatrimonioDAO patrimonioDAO,
			Navegador navegador, TabelaController tabelaController, TelaTabelaPatrimonios tabelaPatrimonios) {
		super();
		this.cadastrarPatrimonio = cadastrarPatrimonio;
		this.patrimonioDAO = patrimonioDAO;
		this.navegador = navegador;
		this.tabelaController = tabelaController;
		this.tabelaPatrimonios = tabelaPatrimonios;
		System.out.println("controller de patrimonio");
		this.cadastrarPatrimonio.concluir(e -> {
			cadastrarPatrimonio();
		});

	}
	private void cadastrarPatrimonio() {
		if (cadastrarPatrimonio.getTfPatrimonio().getText().isEmpty()) {

			JOptionPane.showMessageDialog(null, "Prencha todos os campos");
			limparCampos();
			return;
		}

		Object local = cadastrarPatrimonio.getCbLocal().getSelectedItem();
		Object nome = cadastrarPatrimonio.getCbNome().getSelectedItem();
		Object status = cadastrarPatrimonio.getCbStatus().getSelectedItem();
	

		if (local == null && nome == null && status == null) {
			JOptionPane.showMessageDialog(null, "Selecione tudo");
			return;
		}

		Patrimonio patrimonio = new Patrimonio(null, null, null);

		patrimonio.setIdpatrimonio(cadastrarPatrimonio.getTfPatrimonio().getText());
		//patrimonio.setStatus(cadastrarPatrimonio.getCbStatus.getSelectedItem());
		System.out.println(cadastrarPatrimonio.getCbNome().getSelectedItem());
		//patrimonio.setNome();
		//patrimonio.setEspaco(cadastrarPatrimonio.getCbLocal.getSelectedItem());
	

		patrimonioDAO.adicionarPatrimonio(patrimonio);
		tabelaPatrimonios.atualizarTabela();
		limparCampos();

		JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");

	}
	public void limparCampos() {
		cadastrarPatrimonio.getTfPatrimonio().setText("");
	}

}
