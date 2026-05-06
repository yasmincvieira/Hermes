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
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import java.awt.event.MouseEvent;
import javax.swing.DropMode;

public class TelaContaADM extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnExcluirConta;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JTextField tfEmail;
	private JLabel lbEditarSenha;
	private JLabel lbEditarNome;
	private JLabel lbTrocarFoto;

	/**
	 * Create the panel.
	 */
	public TelaContaADM() {
		setLayout(new BorderLayout(0, 0));
		setBounds(100, 100, 800, 500);
		setBounds(100, 100, 800, 500);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 233, 221));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]",
				"[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][][][]"));

		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaContaADM.class.getResource("/Imagens/40.png")));
		lblNewLabel.setBackground(new Color(39, 79, 65));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panel_1.add(lblNewLabel, "cell 2 0,alignx right");

		lbTrocarFoto = new JLabel("");
		lbTrocarFoto.setIcon(new ImageIcon(TelaContaADM.class.getResource("/ImagensPerfil/foto1.png")));
		lbTrocarFoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(lbTrocarFoto, "cell 1 2,alignx right,aligny center");

		JLabel lblNewLabel_2 = new JLabel("Usuário:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_2, "flowx,cell 1 4");

		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_3, "flowx,cell 1 6");

		JLabel lblNewLabel_4 = new JLabel("E-Mail:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_4, "flowx,cell 1 8");

		tfUsuario = new JTextField();
		tfUsuario.setEnabled(false);
		tfUsuario.setForeground(new Color(216, 233, 222));
		tfUsuario.setEditable(false);
		tfUsuario.setBackground(new Color(216, 233, 222));
		panel_1.add(tfUsuario, "cell 1 4");
		tfUsuario.setColumns(10);

		tfSenha = new JTextField();
		tfSenha.setEnabled(false);
		tfSenha.setEditable(false);
		tfSenha.setBackground(new Color(216, 233, 222));
		tfSenha.setForeground(new Color(216, 233, 222));
		panel_1.add(tfSenha, "cell 1 6");
		tfSenha.setColumns(10);

		tfEmail = new JTextField();
		tfEmail.setForeground(new Color(216, 233, 222));
		tfEmail.setEnabled(false);
		tfEmail.setBackground(new Color(216, 233, 222));
		tfEmail.setEditable(false);
		panel_1.add(tfEmail, "cell 1 8");
		tfEmail.setColumns(10);

		lbEditarSenha = new JLabel("Editar senha");
		lbEditarSenha.setForeground(new Color(128, 0, 255));
		panel_1.add(lbEditarSenha, "cell 1 6");

		lbEditarNome = new JLabel("Editar usuario");
		lbEditarNome.setForeground(new Color(128, 0, 255));
		panel_1.add(lbEditarNome, "cell 1 4");

		lbEditarSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbEditarSenha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbEditarSenha.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbEditarSenha.setForeground(new Color(128, 0, 255)); // volta à cor original
			}
		});

		lbEditarNome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
				btnExcluirConta = new JButton("Excluir conta");
				btnExcluirConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
				btnExcluirConta.setBackground(new Color(160, 200, 172));
				panel_1.add(btnExcluirConta, "cell 0 10,alignx right");
		lbEditarNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lbEditarNome.setForeground(Color.BLUE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lbEditarNome.setForeground(new Color(128, 0, 255));
			}
		});

	}

	public void editarSenha(MouseListener mouseListener) {
		this.lbEditarSenha.addMouseListener(mouseListener);
	}

	public void editarNome(MouseListener mouseListener) {
		this.lbEditarNome.addMouseListener(mouseListener);
	}

	public void excluirConta(ActionListener actionListener) {
		this.btnExcluirConta.addActionListener(actionListener);
	}

	public void preencherDados(Usuario usuario) {
		tfUsuario.setText(usuario.getNome());
		tfSenha.setText(usuario.getSenha());
		tfEmail.setText(usuario.getEmail());
	}

	public void atualizarFoto(String nomeFoto) {
		lbTrocarFoto.setIcon(new ImageIcon(TelaContaADM.class.getResource("/ImagensPerfil/" + nomeFoto)));
	}

	public void escolherFoto(MouseListener mouseListener) {
		this.lbTrocarFoto.addMouseListener(mouseListener);
	}
}