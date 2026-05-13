package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import models.Chamado;
import models.ChamadoDAO;
import models.Patrimonio;
import models.PatrimonioDAO;
import models.UsuarioDAO;
import view.TelaCadastrarPatrimonio;
import view.TelaCadastro;
import view.TelaConta;
import view.TelaNovoChamado;
import view.TelaTabelaPatrimonios;

public class CadastrarPatrimonioController{

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
			JOptionPane.showMessageDialog(cadastrarPatrimonio, "Descreva qual é o id do patrimônio", "Atenção", JOptionPane.ERROR_MESSAGE);
			return;
		}

        Integer idPatrimonio = null;
        if (id != null && !id.trim().isEmpty()) {
            try {
            	idPatrimonio = Integer.valueOf(id);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(cadastrarPatrimonio, "O ID do Patrimônio deve conter apenas números!");
                return;
            }
        }
	        
	        
	        Patrimonio patrimonio = new Patrimonio(id, nome, espaco, status);
	
			try {
			patrimonioDAO.adicionarPatrimonio(patrimonio);
			JOptionPane.showMessageDialog(cadastrarPatrimonio, "Cadastro feito com sucesso!", "Sucesso",
					JOptionPane.INFORMATION_MESSAGE);

			cadastrarPatrimonio.getTfPatrimonio().setText("");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(cadastrarPatrimonio, "Erro ao cadastrar patrimônio ", "Erro", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}

	}


	
	public void limparCampos() {
		cadastrarPatrimonio.getTfPatrimonio().setText("");
	}

}
