package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

import java.awt.CardLayout;


public class Janela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Object cardLayout;
//	private CardLayout cardLayout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Janela() {
//		setIconImage(Toolkit.getDefaultToolkit().getImage(Janela.class.getResource("/Imagens/hermes (1).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
//		this.cardLayout = new CardLayout();
		
		//setTitle("Tela de Login");
//		contentPane = new JPanel(this.cardLayout);
		contentPane = new TelaLogin();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

	}

	public void adicionarTela(String nome, JPanel tela) {
		this.contentPane.add(tela, nome);
		// TODO Auto-generated method stub
		
	}

	public void mostrarTela(String nome) {
		((CardLayout) this.cardLayout).show(this.contentPane, nome);
		this.pack();
		// TODO Auto-generated method stub
		
	}

}
