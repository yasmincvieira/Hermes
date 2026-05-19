package controller;

import javax.swing.JOptionPane;

import models.Patrimonio;
import models.PatrimonioDAO;
import view.TelaCadastrarPatrimonio;
import view.TelaTabelaPatrimonios;

public class CadastrarPatrimonioController {

	private TelaCadastrarPatrimonio cadastrarPatrimonio;
	private PatrimonioDAO patrimonioDAO;
	private Navegador navegador;
	private TabelaController tabelaController;
	private TelaTabelaPatrimonios tabelaPatrimonios;

	public CadastrarPatrimonioController(TelaCadastrarPatrimonio cadastrarPatrimonio, PatrimonioDAO patrimonioDAO,
			Navegador navegador, TabelaController tabelaController, TelaTabelaPatrimonios tabelaPatrimonios) {
		super();
		this.cadastrarPatrimonio = cadastrarPatrimonio;
		this.navegador = navegador;
		this.patrimonioDAO = patrimonioDAO;
		this.tabelaController = tabelaController;
		this.tabelaPatrimonios = tabelaPatrimonios;

		this.cadastrarPatrimonio.concluir(e -> {
			cadastrarPatrimonio();
		});

	}

	private void cadastrarPatrimonio() {
		String id = (String) cadastrarPatrimonio.getTfPatrimonio().getText();
		String nome = (String) cadastrarPatrimonio.getCbNome().getSelectedItem();
		String espaco = (String) cadastrarPatrimonio.getCbLocal().getSelectedItem();
		String status = (String) cadastrarPatrimonio.getCbStatus().getSelectedItem();

		if (id.trim().isEmpty()) {
			JOptionPane.showMessageDialog(cadastrarPatrimonio, "Descreva qual é o id do patrimônio", "Atenção",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		String idPatrimonio = null;
		if (id != null && !id.trim().isEmpty()) {
			try {
				idPatrimonio = String.valueOf(id);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(cadastrarPatrimonio, "O ID do Patrimônio deve conter apenas números!");
				return;
			}
		}

		try {

			Patrimonio patrimonio = new Patrimonio(idPatrimonio, status, nome, espaco);
			patrimonioDAO.adicionarPatrimonio(patrimonio);
			JOptionPane.showMessageDialog(cadastrarPatrimonio, "Cadastro feito com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

			cadastrarPatrimonio.getTfPatrimonio().setText("");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(cadastrarPatrimonio, "Erro ao cadastrar patrimônio ", "Erro",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}

	public void limparCampos() {
		cadastrarPatrimonio.getTfPatrimonio().setText("");
	}

}
