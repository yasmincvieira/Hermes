package view;

import java.awt.Dimension;
import java.awt.EventQueue;

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
	private String panelAtual;


	public Janela() {

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 800, 500);
//		contentPane = new JPanel();
//		
//		this.cardLayout = new CardLayout();
//		
//		this.panelTelas = new JPanel(this.cardLayout);
//		
//		setContentPane(panelTelas);
//		
//		setTitle("Tela de Login");
//		
//		contentPane = new TelaLogin();
//		contentPane.setBackground(new Color(240, 240, 240));
//		
//		
//
//		contentPane = new JPanel(this.cardLayout);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 100, 800, 500);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.cardLayout = new CardLayout();

		contentPane.add(panelTelas, BorderLayout.CENTER);

		panelTelas.setLayout(cardLayout);

		

		setPreferredSize(new Dimension(800,500)); // Tamanho de padrão

		setMinimumSize(new Dimension(800, 500)); // Tamanho minimo

		setLocationRelativeTo(null); // Tela Centralizada

		
	}

	public void adicionarTela(String nome, JPanel tela) {
		this.panelTelas.add(tela, nome);
	}

	public void mostrarTela(String nome) {

		this.cardLayout.show(this.panelTelas, nome);

		this.panelAtual = nome;

		this.pack();

	}

}
