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

public class Mensagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnOk;
	private JLabel lblMensagem;

	public Mensagem(String mensagem, String titulo) {
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
		
		btnOk = new JButton("Ok");
		btnOk.setForeground(new Color(39, 79, 65));
		btnOk.setBackground(new Color(122, 188, 170));
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnOk.setBounds(165, 110, 100, 30);
		btnOk.setFocusPainted(false);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnOk);
		
		lblMensagem = new JLabel("<html><div style='text-align: center;'>" + mensagem + "</div></html>");
		lblMensagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensagem.setForeground(new Color(39, 79, 65));
		lblMensagem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMensagem.setBounds(10, 20, 414, 80);
		contentPane.add(lblMensagem);
	}
	
	public void ok(ActionListener actionListener) {
		this.btnOk.addActionListener(actionListener);
	}
	
	public static void mostrar(String mensagem, String titulo) {
		Mensagem frame = new Mensagem(mensagem, titulo);
		frame.setVisible(true);
	}
}
