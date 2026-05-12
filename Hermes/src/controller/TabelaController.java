package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import models.Patrimonio;
import models.PatrimonioDAO;
import view.TelaTabelaPatrimonios;

public class TabelaController  extends ComponentAdapter {

	private TelaTabelaPatrimonios telaTabelaPatrimonios;
	private PatrimonioDAO patrimonioDAO;
	private Navegador navegador;

	public TabelaController(TelaTabelaPatrimonios telaTabelaPatrimonios, Navegador navegador,
			PatrimonioDAO patrimonioDao) {
		super();
		this.telaTabelaPatrimonios = telaTabelaPatrimonios;
		this.patrimonioDAO = patrimonioDAO;

		this.telaTabelaPatrimonios.excluirPatri(e -> {
			excluirPatrimonio();
		});
		this.telaTabelaPatrimonios.adicionarPatri(e-> {
			navegador.navegarPara("CADASTRAR PATRIMONIO");
		});

	}

	private void excluirPatrimonio() {
		int linhaSelecionada = telaTabelaPatrimonios.getTable().getSelectedRow();

		String idPatrimonio = (String) telaTabelaPatrimonios.getTable().getValueAt(linhaSelecionada, 0);

		int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);

		if (confirm == JOptionPane.YES_OPTION) {
			patrimonioDAO.excluirPatrimonio(idPatrimonio);

		}

	}

	public void componentShown(ComponentEvent e) {
		this.atualizarTabela();
	}
	public void atualizarTabela() {
		PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
		List<Patrimonio> lista = patrimonioDAO.listarpatrimonio();
		PatrimonioTableModel model = new PatrimonioTableModel(lista);
	}

}
