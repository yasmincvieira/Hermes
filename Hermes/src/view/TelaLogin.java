package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class TelaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfUsuario;
	private JPasswordField tfSenha;
	private JButton btnCadastrarse;
	private JButton btnLogin;

	

	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		// cria o objeto do controller
		
		
		setBackground(new Color(240, 240, 240));
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
		
		JLabel lbUsuario = new JLabel("Usuário:");
		lbUsuario.setForeground(new Color(39, 79, 65));
		lbUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbUsuario, "cell 1 3,alignx center,growy");
		
		this.tfUsuario = new JTextField();
		this.tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		this.tfUsuario.setBackground(new Color(78, 153, 126));
		add(this.tfUsuario, "cell 2 3,grow");
		this.tfUsuario.setColumns(10);
		
		JLabel lbSenha = new JLabel("Senha:");
		lbSenha.setForeground(new Color(39, 79, 65));
		lbSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(lbSenha, "cell 1 5,alignx center,growy");
		
		
		this.btnLogin = new JButton("Login");
		this.btnLogin.setBackground(new Color(160, 200, 172));
		this.btnLogin.setForeground(new Color(39, 79, 65));
		this.btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.btnLogin, "cell 1 7 2 1,alignx center");
	
		
		this.tfSenha = new JPasswordField();
		this.tfSenha.setBackground(new Color(78, 153, 126));
		this.tfSenha.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(this.tfSenha, "cell 2 5,grow");
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 240, 240));
		add(panel, "flowx,cell 1 9 2 1,alignx center,growy");
		
		JLabel lblNewLabel_3 = new JLabel("Ainda não tem uma conta?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setForeground(new Color(39, 79, 65));
		panel.add(lblNewLabel_3);
		
		
		this.btnCadastrarse = new JButton("Cadastra-se");
		this.btnCadastrarse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		this.btnCadastrarse.setForeground(new Color(39, 79, 65));
		this.btnCadastrarse.setBackground(new Color(160, 200, 172));
		add(this.btnCadastrarse, "cell 1 9 2 1");

	}

	
	 public String getUsuario() {
	        return tfUsuario.getText();
	    }

	    public String getSenha() {
	        return new String(tfSenha.getPassword());
	    }

	    public void setUsuario(String usuario) {
	        tfUsuario.setText(usuario);
	    }

	    public void setSenha(String senha) {
	        tfSenha.setText(senha);
	    }
	
	public void adicionarOuvinte(LoginController loginController) {
		// TODO Auto-generated method stub
		
	}
	public void logar(ActionListener actionListener) {
		this.btnLogin.addActionListener(actionListener);
	}

	
	public void addActionListener(ActionListener l) {
        listenerList.add(ActionListener.class, l);
    }
	
	public void btnCadastrar(ActionListener actionListener) {
		this.btnCadastrarse.addActionListener(actionListener);
	}




	
}
