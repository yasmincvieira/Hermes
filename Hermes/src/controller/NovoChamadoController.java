package controller;

import models.ChamadoDAO;
import view.TelaNovoChamado;

public class NovoChamadoController {

	private TelaNovoChamado novoChamado;
	private ChamadoDAO chamado;
	private Navegador navegador;

	public NovoChamadoController(TelaNovoChamado novoChamado, ChamadoDAO chamado, Navegador navegador) {
		super();
		this.novoChamado = novoChamado;
		this.chamado = chamado;
		this.navegador = navegador;

		this.novoChamado.realizarChamado(e -> {
			// realizarChamado();
		});

	}

//	private void realizarChamado() {
//		List<>
//	}

}
