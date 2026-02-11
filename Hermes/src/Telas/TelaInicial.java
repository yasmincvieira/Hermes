package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class TelaInicial extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setTitle("Tela Inicial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new MigLayout("", "[grow][][][][grow]", "[grow][64.00][47.00][100.00][grow]"));
		
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/Imagens/40.png")));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 55));
		getContentPane().add(lblNewLabel, "cell 1 1 3 1,alignx center");
		
		JButton btnHistorico = new JButton("Histórico de Chamados");
		btnHistorico.setBackground(new Color(122, 188, 170));
		btnHistorico.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnHistorico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		getContentPane().add(btnHistorico, "cell 1 3");
		
		JButton btnNewButton_1 = new JButton("Realizar novo Chamado");
		btnNewButton_1.setBackground(new Color(122, 188, 170));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		getContentPane().add(btnNewButton_1, "cell 3 3");

	}
}
