package controller;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import models.Patrimonio;
import models.PatrimonioDAO;
import view.TelaCadastrarPatrimonio;
import view.TelaEditarPatrimonio;
import view.TelaTabelaPatrimonios;

public class TabelaController {

	private TelaEditarPatrimonio telaEditarPatrimonio;
	private TelaTabelaPatrimonios telaTabelaPatrimonios;
	private PatrimonioDAO patrimonioDAO;
	private Navegador navegador;
	private java.util.List<Patrimonio> listaPatrimonio;
	
	public TabelaController(TelaTabelaPatrimonios telaTabelaPatrimonios, TelaEditarPatrimonio telaEditarPatrimonio,
			TelaCadastrarPatrimonio telaCadastrarPatrimonio, PatrimonioDAO patrimonioDAO, Navegador navegador,Menu menu) {
		super();
		
		this.telaTabelaPatrimonios = telaTabelaPatrimonios;
		this.telaEditarPatrimonio = telaEditarPatrimonio;
		this.patrimonioDAO = patrimonioDAO;
		this.navegador = navegador;

		this.telaTabelaPatrimonios.excluirPatri(e -> {
			excluirPatrimonio();
		});
		
		this.telaTabelaPatrimonios.irInicioADM(e -> {
			navegador.navegarPara("INICIO ADMIN");
		});
		
		this.telaTabelaPatrimonios.editarPatri(e -> {
		    int linhaSelecionada = telaTabelaPatrimonios.getTable().getSelectedRow();

		    if (linhaSelecionada == -1) {
		        JOptionPane.showMessageDialog(null,
		            "Selecione um patrimônio para editar.",
		            "Aviso",
		            JOptionPane.WARNING_MESSAGE);
		        return;
		    }

		    // Pega o ID da coluna 0 da linha selecionada
		    String idPatrimonio = (String) telaTabelaPatrimonios.getTable().getValueAt(linhaSelecionada, 2).toString();
		    
		    // Preenche os campos ANTES de navegar
		    telaEditarPatrimonio.preencherCampos(idPatrimonio);
		    
		    this.navegador.navegarPara("EDITAR PATRIMONIO");
		});
		}
	
	public void preencherEdicao() {
	    int linhaSelecionada = telaTabelaPatrimonios.getTable().getSelectedRow();
	    if (linhaSelecionada != -1) {
	        String idPatrimonio = (String) telaTabelaPatrimonios.getTable().getValueAt(linhaSelecionada, 0);
	        telaEditarPatrimonio.preencherCampos(idPatrimonio);
	    }
	}

	private void excluirPatrimonio() {
	    int linhaSelecionada = telaTabelaPatrimonios.getTable().getSelectedRow();

	    if (linhaSelecionada == -1) {
	        JOptionPane.showMessageDialog(null, 
	            "Selecione um patrimônio para excluir.", 
	            "Aviso", 
	            JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    String idPatrimonio = (String) telaTabelaPatrimonios.getTable().getValueAt(linhaSelecionada, 0);

	    int confirm = JOptionPane.showConfirmDialog(null, "Deseja excluir?", "Confirmação", JOptionPane.YES_NO_OPTION);

	    if (confirm == JOptionPane.YES_OPTION) {
	        patrimonioDAO.excluirPatrimonio(idPatrimonio);
	    }
	}
	



}
