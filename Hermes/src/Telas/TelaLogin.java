package Telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class TelaLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JTextField tfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		getContentPane().setForeground(new Color(255, 255, 255));
		setTitle("Tela de Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		getContentPane().setLayout(new MigLayout("", "[grow][grow 5][204:n,grow 35][grow]", "[grow][grow 15][grow 5][grow 3][grow 5][grow 3][grow 5][grow 5][grow 5][grow 5][grow]"));
		
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/40.png")));
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		getContentPane().add(lblNewLabel, "cell 1 1 2 1,alignx center,growy");
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setForeground(new Color(39, 79, 65));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_1, "cell 1 3,alignx center,growy");
		
		tfUsuario = new JTextField();
		tfUsuario.setBackground(new Color(78, 153, 126));
		getContentPane().add(tfUsuario, "cell 2 3,grow");
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(new Color(39, 79, 65));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(lblNewLabel_2, "cell 1 5,alignx center,growy");
		
		tfSenha = new JTextField();
		tfSenha.setBackground(new Color(78, 153, 126));
		getContentPane().add(tfSenha, "cell 2 5,grow");
		tfSenha.setColumns(10);
		
		TelaInicial telaInicial = new TelaInicial();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(160, 200, 172));
		btnLogin.setForeground(new Color(39, 79, 65));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaInicial.setVisible(true);
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		getContentPane().add(btnLogin, "cell 1 7 2 1,alignx center");
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, "flowx,cell 1 9 2 1,alignx center,growy");
		
		JLabel lblNewLabel_3 = new JLabel("Ainda não tem uma conta?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(39, 79, 65));
		panel.add(lblNewLabel_3);
		
		TelaCadastro telaCadastro = new TelaCadastro();
		
		JButton btnCadastrarse = new JButton("Cadastre-se");
		btnCadastrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrarse.setForeground(new Color(39, 79, 65));
		btnCadastrarse.setBackground(new Color(160, 200, 172));
		btnCadastrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaCadastro.setVisible(true);
				
			}
		});
		getContentPane().add(btnCadastrarse, "cell 1 9 2 1");
		
		
		
		

	}
}
