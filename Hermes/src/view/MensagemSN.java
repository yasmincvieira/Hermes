package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class MensagemSN extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JButton btnSim, btnNao;
	private JLabel lblMensagem;

	public MensagemSN(String mensagem, String titulo) {
		setBackground(new Color(122, 188, 170));
		setTitle(titulo);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(203, 228, 221));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSim = new JButton("Sim");
		btnSim.setForeground(new Color(39, 79, 65));
		btnSim.setBackground(new Color(122, 188, 170));
		btnSim.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnSim.setBounds(93, 110, 100, 30);
		btnSim.setFocusPainted(false);
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnSim);
		
		lblMensagem = new JLabel("<html><div style='text-align: center;'>" + mensagem + "</div></html>");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setForeground(new Color(39, 79, 65));
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMensagem.setBounds(10, 20, 414, 80);
		contentPane.add(lblMensagem);
		
		btnNao = new JButton("Não");
		btnNao.setForeground(new Color(39, 79, 65));
		btnNao.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNao.setFocusPainted(false);
		btnNao.setBackground(new Color(122, 188, 170));
		btnNao.setBounds(247, 110, 100, 30);
		btnNao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNao);
	}
	
	public void ok(ActionListener actionListener) {
		this.btnSim.addActionListener(actionListener);
	}
	
	public static void mostrarSN(String mensagemSN, String titulo, ActionListener onSim, ActionListener onNao) {
	    MensagemSN frame = new MensagemSN(mensagemSN, titulo);
	    frame.btnSim.addActionListener(onSim);
	    frame.btnNao.addActionListener(onNao);
	    frame.setVisible(true);
	}
}
