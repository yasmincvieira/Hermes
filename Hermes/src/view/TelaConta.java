package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import models.Usuario;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class TelaConta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea taUsuario;
	private JTextArea taSenha;
	private JTextArea taEmail;
	private JTextArea taChamadosFeitos;
	private JButton btnExcluirConta, btnAtualizar;

	/**
	 * Create the panel.
	 */
	public TelaConta() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 195, 171));
		setBounds(100, 100, 800, 500);
		add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[grow,top][]"));
		setBounds(100, 100, 800, 500);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/30Menu.png")));
		panel.add(lblNewLabel_6, "cell 0 0,alignx center");

		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/30Usuario.png")));
		panel.add(lblNewLabel_7, "cell 0 1");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 233, 221));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]",
				"[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][][][]"));

		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/40.png")));
		lblNewLabel.setBackground(new Color(39, 79, 65));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panel_1.add(lblNewLabel, "cell 2 0,alignx right");

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/adicionar-usuario150.png")));
		panel_1.add(lblNewLabel_1, "cell 1 2,alignx right,aligny center");

		JLabel lblNewLabel_2 = new JLabel("Usuário:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_2, "cell 1 4");

		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_3, "cell 1 6");

		JLabel lblNewLabel_4 = new JLabel("E-Mail:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_4, "flowx,cell 1 8");

		JLabel lblNewLabel_5 = new JLabel("Chamados feitos:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_5, "cell 1 10");

		taUsuario = new JTextArea();
		panel_1.add(taUsuario, "cell 1 4");

		taSenha = new JTextArea();
		panel_1.add(taSenha, "cell 1 6");

		taEmail = new JTextArea();
		panel_1.add(taEmail, "cell 1 8");

		taChamadosFeitos = new JTextArea();
		taChamadosFeitos.setEditable(false);
		panel_1.add(taChamadosFeitos, "cell 1 10");

		btnAtualizar = new JButton("AtualizarDados");
		panel_1.add(btnAtualizar, "cell 1 12");

		btnExcluirConta = new JButton("Excluir conta");
		btnExcluirConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirConta.setBackground(new Color(160, 200, 172));
		panel_1.add(btnExcluirConta, "cell 0 12,alignx right");

	}

	public void preencherDados(Usuario usuario) {
		taUsuario.setText(usuario.getNome());
		taSenha.setText(usuario.getSenha());
		taEmail.setText(usuario.getEmail());
	}

}
