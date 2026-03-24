package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JPasswordField;

public class TelaCadastro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfUsuarioC;
	private JTextField tfEmailC;
	private JPasswordField tfSenhaC;
	private JButton btnCadastrar;
	
	

	/**
	 * Create the frame.
	 */
	public TelaCadastro() {
		//setTitle("Tela de Cadastro");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(234, 242, 236));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setBorder(new EmptyBorder(5, 5, 5, 5));

		//setContentPane(contentPane);
		setLayout(new MigLayout("", "[grow][grow 20][grow][grow]", "[grow 50][grow 10][27:n,grow 5][grow 3][grow 5][grow 3][grow 5][grow 3][grow 5][grow 5][grow 50]"));
		
		
		
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaCadastro.class.getResource("/Imagens/40.png")));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		add(lblNewLabel, "cell 1 1 2 1,alignx center");
		
		JLabel lbUsuario = new JLabel("Usuário:");
		lbUsuario.setForeground(new Color(39, 79, 65));
		lbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbUsuario, "cell 1 3,alignx trailing");
		
		this.tfUsuarioC = new JTextField();
		this.tfUsuarioC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.tfUsuarioC.setBackground(new Color(78, 153, 126));
		add(this.tfUsuarioC, "cell 2 3,grow");
		this.tfUsuarioC.setColumns(10);
		
		JLabel lbEmail = new JLabel("E-mail:");
		lbEmail.setForeground(new Color(39, 79, 65));
		lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbEmail, "cell 1 5,alignx trailing");
		
		this.tfEmailC = new JTextField();
		this.tfEmailC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.tfEmailC.setBackground(new Color(78, 153, 126));
		add(this.tfEmailC, "cell 2 5,grow");
		this.tfEmailC.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setForeground(new Color(39, 79, 65));
		lbSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbSenha, "cell 1 7,alignx trailing");
		
		this.tfSenhaC = new JPasswordField();
		this.tfSenhaC.setBackground(new Color(78, 153, 126));
		this.tfSenhaC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.tfSenhaC, "cell 2 7,grow");
		
		this.btnCadastrar = new JButton("Cadastrar");
		this.btnCadastrar.setForeground(new Color(39, 79, 65));
		this.btnCadastrar.setBackground(new Color(160, 200, 172));
		this.btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btnCadastrar, "cell 1 9 2 1,alignx center");
		
	}
	public String getNome() {
		return this.tfUsuarioC.getText();
	}

	/**
	 * Método responsável por recuperar o texto digitado no campo de texto 'formação'.
	 * @return Texto digitado no campo de texto 'formação'.
	 */
	public String getEmail() {
		return this.tfEmailC.getText();
	}

	/**
	 * Método responsável por recuperar o texto digitado na área de texto 'área de interesse'.
	 * @return Texto digitado na área de texto 'área de interesse'.
	 */
	public String getSenha() {
		return new String(this.tfSenhaC.getPassword());
	}
	
	public void btnCadastrar(ActionListener actionListener) {
		this.btnCadastrar.addActionListener(actionListener);
	}

}
