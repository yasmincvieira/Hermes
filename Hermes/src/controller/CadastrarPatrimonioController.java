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
			Object itemSelecionado = cadastrarPatrimonio.getCbLocal().getSelectedItem();
			Espaco espaco = null;
			EspacoDAO espacoDAO = new EspacoDAO();
			
			if (itemSelecionado instanceof Espaco) {
				espaco = (Espaco) itemSelecionado;
			} else if (itemSelecionado instanceof String) {
				String nomeLocal = (String) itemSelecionado;
				espaco = espacoDAO.BuscarEspacoPorID(nomeLocal);
				
				// Se o local não existe no banco, vamos cadastrá-lo agora para evitar erro de FK
				if (espaco == null) {
					try {
						espaco = new Espaco();
						espaco.setNomeLocal(nomeLocal);
						espaco.setBloco((String) cadastrarPatrimonio.getCbBloco().getSelectedItem());
						espaco.setAndar((String) cadastrarPatrimonio.getCbAndar().getSelectedItem());
						
						espacoDAO.adicionarEspaco(espaco);
					} catch (Exception e) {
						Mensagem.mostrar("Erro ao preparar o local: " + e.getMessage(), "Erro");
						return;
					}
				}
			}
			
			
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
			navegador.navegarPara("TABELA");
		} catch (Exception e) {
			Mensagem.mostrar("Erro ao cadastrar patrimônio"+ e.getMessage(), "Erro");
			e.printStackTrace();
		}
	}

	public void limparCampos() {
		cadastrarPatrimonio.getTfPatrimonio().setText("");
	}

}
