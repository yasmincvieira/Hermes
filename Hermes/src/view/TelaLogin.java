package view;

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
import javax.swing.JPasswordField;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JPasswordField tfSenha;

	

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setBackground(new Color(234, 242, 236));
		setForeground(new Color(255, 255, 255));
		//setTitle("Tela de Login");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setLayout(new MigLayout("", "[grow][grow 5][204:n,grow][grow]", "[grow][grow 15][grow 5][grow 3][grow 5][grow 3][grow 8][grow 5][grow 5][grow 5][grow]"));
		
		JLabel lblNewLabel_4 = new JLabel("");
		add(lblNewLabel_4, "flowx,cell 0 0");
		
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/Imagens/40.png")));
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		add(lblNewLabel, "cell 1 1 2 1,alignx center,growy");
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setForeground(new Color(39, 79, 65));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_1, "cell 1 3,alignx center,growy");
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUsuario.setBackground(new Color(78, 153, 126));
		add(tfUsuario, "cell 2 3,grow");
		tfUsuario.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Senha:");
		lblNewLabel_2.setForeground(new Color(39, 79, 65));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lblNewLabel_2, "cell 1 5,alignx center,growy");
		
		TelaInicial telaInicial = new TelaInicial();
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(160, 200, 172));
		btnLogin.setForeground(new Color(39, 79, 65));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaInicial.setVisible(true);
				
			}
		});
		
		tfSenha = new JPasswordField();
		tfSenha.setBackground(new Color(78, 153, 126));
		tfSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(tfSenha, "cell 2 5,grow");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnLogin, "cell 1 7 2 1,alignx center");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(234, 242, 236));
		add(panel, "flowx,cell 1 9 2 1,alignx center,growy");
		
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
		add(btnCadastrarse, "cell 1 9 2 1");
		
		
		
		

	}
}
