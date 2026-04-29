package controller;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import view.MenuContraidoTeste;

import view.MenuExpandidoTeste;

import view.Janela;

public class Menu {

	private MenuExpandidoTeste mnExp;

	private MenuContraidoTeste mnCont;

	private JPanel menuAtual;

	private Janela janela;
	
	private Navegador navegador;

	public Menu(Janela janela, MenuExpandidoTeste mnExp, MenuContraidoTeste mnCont) {

		this.janela = janela;

		this.mnExp = mnExp;

		this.mnCont = mnCont;

		menuAtual = mnCont;

		janela.mudarMenu(menuAtual);
		
		

		this.mnExp.mostrarMenuContraido(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {

				mostrarPanelCont();
		}

		
		});
		this.mnExp.sair(e -> {
			dispose();
		});
		this.mnExp.irHistorico(e -> {
			if (navegador != null) navegador.navegarPara("HISTORICO");
		});
		this.mnExp.irInicio(e -> {
			if (navegador != null) navegador.navegarPara("INICIO");
		});
		this.mnExp.irPerfil( e -> {
			
			if (navegador != null) navegador.navegarPara("PERFIL");
			
		});
	

		this.mnCont.mostrarMenuExpandido(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {

				mostrarPanelExp();

			}

			public void iniciarMenu() {
				menuAtual = mnCont;
				janela.mudarMenu(menuAtual);
			}

		});

	}
	public void setNavegador(Navegador navegador) {
        this.navegador = navegador;
    }

	
		private void dispose() {
			
			int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmar Ação", JOptionPane.YES_NO_OPTION);
			
			if (resposta == JOptionPane.YES_OPTION) {
	            System.exit(0); // Fecha o sistema
			}
			
		}

		public void mostrarPanelCont() {
	
			menuAtual = mnCont;
	
			janela.mudarMenu(menuAtual);
	
		}

		public void mostrarPanelExp() {
	
			menuAtual = mnExp;
	
			janela.mudarMenu(menuAtual);
	
		}

		public void removerMenu() {
	
			janela.getPanelMenu().removeAll();
	
			janela.revalidate();
	
			janela.repaint();
	
		}

		public void iniciar() {
	
			if (janela.getPanelAtual().equals("LOGIN") || janela.getPanelAtual().equals("CADASTRO") || janela.getPanelAtual().equals("INICIO")) {
				janela.setVisible(true);
				removerMenu();
	
			} else {
	
				janela.setVisible(true);
	
				menuAtual = mnCont;
	
				janela.mudarMenu(menuAtual);
	
			}
	}
}
