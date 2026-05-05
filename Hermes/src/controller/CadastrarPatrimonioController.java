package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import models.PatrimonioDAO;
import models.UsuarioDAO;
import view.TelaCadastrarPatrimonio;
import view.TelaCadastro;
import view.TelaConta;

public class CadastrarPatrimonioController {
	


		private TelaCadastrarPatrimonio cadastrarPatrimonio;
		private PatrimonioDAO patrimonioDao;
		private Navegador navegador;

		public CadastrarPatrimonioController(TelaCadastrarPatrimonio cadastrarPatrimonio, PatrimonioDAO patrimonioDao, Navegador navegador) {
			super();
			this.cadastrarPatrimonio = cadastrarPatrimonio;
			this.patrimonioDao = patrimonioDao;
			this.navegador = navegador;
			

			this.cadastrarPatrimonio.cadastrarPatrimonio(e -> {
			});
		
		
		}


}
