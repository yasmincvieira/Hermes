package controller;

import models.Patrimonio;
import models.PatrimonioDAO;
import view.TelaCadastrarPatrimonio;
import view.TelaEditarPatrimonio;
import view.TelaTabelaPatrimonios;

public class EditarPatriController {
	
	private TelaEditarPatrimonio telaEditarPatrimonio;
	private TelaTabelaPatrimonios telaTabelaPatrimonios;
	private PatrimonioDAO patrimonioDAO;
	private Navegador navegador;
	
	

	public EditarPatriController(TelaTabelaPatrimonios telaTabelaPatrimonios, TelaEditarPatrimonio telaEditarPatrimonio,
			TelaCadastrarPatrimonio telaCadastrarPatrimonio, PatrimonioDAO patrimonioDAO, Navegador navegador,Menu menu) {
		super();
		
		this.telaTabelaPatrimonios = telaTabelaPatrimonios;
		this.telaEditarPatrimonio = telaEditarPatrimonio;
		this.patrimonioDAO = patrimonioDAO;
		this.navegador = navegador;
		
		this.preencherCampos();

	}
	
	public void preencherCampos() {
		Patrimonio patrimonioAdicionado = navegador.getPatrimonioAdicionado();
		
	if  (patrimonioAdicionado != null) {
		telaEditarPatrimonio.preencherCampos(patrimonioAdicionado);
	}
	}
	
	
}
