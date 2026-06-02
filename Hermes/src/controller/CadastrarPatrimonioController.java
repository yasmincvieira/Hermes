package controller;

import javax.swing.JOptionPane;
import models.Espaco;
import models.EspacoDAO;
import models.Patrimonio;
import models.PatrimonioDAO;
import view.Mensagem;
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
		
		EspacoDAO espacoDAO = new EspacoDAO();
		this.cadastrarPatrimonio.carregarComBoxEspaco(espacoDAO.listarEspacos());

		this.cadastrarPatrimonio.concluir(e -> {
			cadastrarPatrimonio();
		});

	}

	private void cadastrarPatrimonio() {
		String id = (String) cadastrarPatrimonio.getTfPatrimonio().getText().trim();
		String nome = (String) cadastrarPatrimonio.getCbNome().getSelectedItem();
		Espaco espaco =  (Espaco) cadastrarPatrimonio.getCbLocal().getSelectedItem();
		String status = (String) cadastrarPatrimonio.getCbStatus().getSelectedItem();

		if (id.isEmpty()) {
			Mensagem.mostrar("Descreva qual é o id do patrimônio", "Atenção");
			return;
		}

		Integer idPatrimonio = null;
		try {
			idPatrimonio = Integer.parseInt(id);
		} catch (NumberFormatException e) {
			Mensagem.mostrar("O ID do Patrimônio deve conter apenas números!", "Atenção");
			return;
		}
			try {

				Patrimonio patrimonio = new Patrimonio(idPatrimonio, status, nome, espaco);
		
				patrimonioDAO.adicionarPatrimonio(patrimonio);
				tabelaPatrimonios.atualizarTabela();
				limparCampos();
				Mensagem.mostrar("Cadastro feito com sucesso!", "Sucesso");
			} catch (Exception e) {
				Mensagem.mostrar("Erro ao cadastrar patrimônio", "Erro");
				e.printStackTrace();
			}
	}

	public void limparCampos() {
		cadastrarPatrimonio.getTfPatrimonio().setText("");
	}

}
