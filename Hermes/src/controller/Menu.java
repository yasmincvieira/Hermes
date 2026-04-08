package controller;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import view.MenuContraidoTeste;

import view.MenuExpandidoTeste;

import view.Janela;



public class Menu {

	
	private MenuExpandidoTeste mnExp;

	private MenuContraidoTeste mnCont;

	private JPanel menuAtual;

	private Janela janela;

	

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

		

		this.mnCont.mostrarMenuExpandido(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {

				mostrarPanelExp();

			}

			

		});

		

		

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

		if(janela.getPanelAtual().equals("LOGIN") || janela.getPanelAtual().equals("CADASTRO")) {

			removerMenu();

            janela.setVisible(true);

		} else {

			janela.setVisible(true);

			menuAtual = mnCont;

			janela.mudarMenu(menuAtual);

		}

	}



}

