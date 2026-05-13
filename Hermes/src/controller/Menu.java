package controller;

import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import models.Usuario;
import models.UsuarioDAO;
import view.MenuContraidoTeste;
import view.MenuExpandidoAdm;
import view.MenuExpandidoTeste;

import view.Janela;

public class Menu {

	private MenuExpandidoTeste mnExp;
	
	private MenuExpandidoAdm mnExpAdm;

	private MenuContraidoTeste mnCont;

	private JPanel menuAtual;

	private Janela janela;

	private Navegador navegador;

	private Usuario usuarioLogado;

	private UsuarioDAO user;

	public Menu(Janela janela, MenuExpandidoTeste mnExp, MenuContraidoTeste mnCont, MenuExpandidoAdm mnExpAdm) {

		this.janela = janela;

		this.mnExp = mnExp;
		
		this.mnExpAdm = mnExpAdm;

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
			if (navegador != null)
				navegador.navegarPara("HISTORICO");
		});
		
		this.mnExpAdm.irInicioADM(e -> {
			if (navegador != null)
				navegador.navegarPara("inicioADM");
		});
		
		this.mnExp.irInicio(e -> {
			if (navegador != null)
				irInicio();
		});
		this.mnExp.irPerfil(e -> {
			if (navegador != null)
				navegador.navegarPara("PERFIL");
		});
	
		this.mnExpAdm.irTabela(e -> {
			if (navegador != null)
				navegador.navegarPara("TABELA");
		});
		
		this.mnExpAdm.irNovosChamados(e -> {
			if (navegador != null)
				navegador.navegarPara("NOVOS_CHAMADOS");
		});
		
		
		if (this.usuarioLogado.isAdmin()) {
		this.mnCont.mostrarMenuExpandidoAdm(new MouseAdapter() {

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
		else {
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
	}


	private void irInicio() {
		navegador.setUsuarioLogado(usuarioLogado);

		if (this.usuarioLogado.isAdmin()) {
			navegador.navegarPara("INICIO ADMIN");
		} else {
			navegador.navegarPara("INICIO");
		}
		
	}
	
	
	public void setUsuarioLogado(Usuario usuarios) {
	    this.usuarioLogado = usuarios;
	}

	public void setNavegador(Navegador navegador) {
		this.navegador = navegador;
	}

	private void dispose() {

		int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Confirmar Ação",
				JOptionPane.YES_NO_OPTION);

		if (resposta == JOptionPane.YES_OPTION) {
			System.exit(0);
		}

	}
	
	

	public void mostrarPanelCont() {

		menuAtual = mnCont;

		janela.mudarMenu(menuAtual);

	}
	
	public void mostrarPanelExpAdm() {

		menuAtual = mnExpAdm;

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

		if (janela.getPanelAtual().equals("LOGIN") || janela.getPanelAtual().equals("CADASTRO")
				|| janela.getPanelAtual().equals("INICIO")) {
			janela.setVisible(true);
			removerMenu();

		} else {

			janela.setVisible(true);

			menuAtual = mnCont;

			janela.mudarMenu(menuAtual);

		}
	}
}
