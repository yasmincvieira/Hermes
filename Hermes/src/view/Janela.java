package view;

import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.CardLayout;

public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private CardLayout cardLayout;

	JPanel panelTelas = new JPanel();
	JPanel panelMenu;
	private String panelAtual;

	public Janela() {

		//this.setIconImage(new ImageIcon(getClass().getResource("/Imagens/HERMES.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Tela de Inicio");

		setBounds(100, 100, 800, 500);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		this.cardLayout = new CardLayout();

		panelMenu = new JPanel(new BorderLayout());

		contentPane.add(panelTelas, BorderLayout.CENTER);

		contentPane.add(panelMenu, BorderLayout.WEST);

		panelTelas.setLayout(cardLayout);

		setPreferredSize(new Dimension(800, 500));

		setMinimumSize(new Dimension(800, 500));

		setLocationRelativeTo(null);

	}

	public void adicionarTela(String nome, JPanel tela) {
		this.panelTelas.add(tela, nome);
	}

	public void mostrarTela(String nome) {
	    this.cardLayout.show(this.panelTelas, nome);
	    this.panelAtual = nome;
	    
	    switch (nome) {
	        case "LOGIN": setTitle("Login"); break;
	        case "CADASTRO USUARIO": setTitle("Cadastro"); break;
	        case "INICIO": setTitle("Início"); break;
	        case "INICIO ADMIN": setTitle("Início - Admin"); break;
	        case "PERFIL": setTitle("Meu Perfil"); break;
	        case "PERFIL ADM": setTitle("Perfil - Administrador"); break;
	        case "HISTORICO": setTitle("Histórico de Chamados"); break;
	        case "HISTORICO ADMIN": setTitle("Histórico - Admin"); break;
	        case "CHAMADO": setTitle("Novo Chamado"); break;
	        case "PATRIMONIO": setTitle("Patrimônios"); break;
	        default: setTitle(nome); break;
	    }
	    
	    this.pack();
	}

	public String getPanelAtual() {

		return panelAtual;

	}

	public void setPanelAtual(String panelAtual) {

		this.panelAtual = panelAtual;

	}

	public void mudarMenu(JPanel menu) {

		panelMenu.removeAll();

		panelMenu.add(menu, BorderLayout.CENTER);

		panelMenu.revalidate();

		panelMenu.repaint();

	}

	public JPanel getPanelMenu() {

		return panelMenu;

	}

	public void setPanelMenu(JPanel panelMenu) {

		this.panelMenu = panelMenu;

	}

	public JPanel getPanelTelas() {

		return panelTelas;

	}

	public void setPanelTelas(JPanel panelTelas) {

		this.panelTelas = panelTelas;

	}

}
