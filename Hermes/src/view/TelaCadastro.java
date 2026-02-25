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
		//setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][grow 20][grow][grow]", "[grow 50][grow 10][27:n,grow 5][grow 3][grow 5][grow 3][grow 5][grow 3][grow 5][grow 5][grow 50]"));
		
		TelaInicial telaInicial = new TelaInicial();
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				telaInicial.setVisible(true);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaCadastro.class.getResource("/Imagens/40.png")));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		contentPane.add(lblNewLabel, "cell 1 1 2 1,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("Usuário:");
		lblNewLabel_1.setForeground(new Color(39, 79, 65));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_1, "cell 1 3,alignx trailing");
		
		tfUsuarioC = new JTextField();
		tfUsuarioC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfUsuarioC.setBackground(new Color(78, 153, 126));
		contentPane.add(tfUsuarioC, "cell 2 3,grow");
		tfUsuarioC.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("E-mail:");
		lblNewLabel_2.setForeground(new Color(39, 79, 65));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_2, "cell 1 5,alignx trailing");
		
		tfEmailC = new JTextField();
		tfEmailC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tfEmailC.setBackground(new Color(78, 153, 126));
		contentPane.add(tfEmailC, "cell 2 5,grow");
		tfEmailC.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setForeground(new Color(39, 79, 65));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNewLabel_3, "cell 1 7,alignx trailing");
		
		tfSenhaC = new JPasswordField();
		tfSenhaC.setBackground(new Color(78, 153, 126));
		tfSenhaC.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(tfSenhaC, "cell 2 7,grow");
		btnCadastrar.setForeground(new Color(39, 79, 65));
		btnCadastrar.setBackground(new Color(160, 200, 172));
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(btnCadastrar, "cell 1 9 2 1,alignx center");

	}

}
