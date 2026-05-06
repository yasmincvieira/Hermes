package controller;

import models.Chamado;
import models.ChamadoDAO;
import view.TelaVizuChamados;
import view.TelinhaHistorico;

public class VizuChamadoController {
	private TelaVizuChamados tela;
	private Chamado chamado;
	private ChamadoDAO chamadoDAO;
	private Navegador navegador;
	
	public VizuChamadoController(TelaVizuChamados tela, Chamado chamado, ChamadoDAO chamadoDAO, Navegador navegador) {
		this.tela = tela;
		this.chamado = chamado;
		this.chamadoDAO = chamadoDAO;
		this.navegador = navegador;
		
		this.tela.voltar(e -> {
			voltarTela();
		});
	}
	
	private void voltarTela(){
		
	}

}
