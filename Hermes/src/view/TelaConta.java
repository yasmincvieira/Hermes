package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import models.Chamado;
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

public class TelaConta extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnExcluirConta;
	private JTextField tfUsuario;
	private JTextField tfSenha;
	private JTextField tfEmail;
	private JLabel lbEditarSenha;
	private JLabel lbEditarNome;
	private JLabelRedondo lbTrocarFoto;
	private JTextField tfChamados;
	private JLabel btVoltar;

	public TelaConta() {
	    System.out.println(">>> CONSTRUTOR TelaConta");

		setLayout(new BorderLayout(0, 0));
		setBounds(100, 100, 800, 500);
		setBounds(100, 100, 800, 500);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 233, 221));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]",
				"[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][][][]"));
		
		btVoltar = new JLabel("");
		btVoltar.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/botao-voltar40.png")));
		panel_1.add(btVoltar, "cell 0 0,aligny top");

		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/40.png")));
		lblNewLabel.setBackground(new Color(39, 79, 65));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panel_1.add(lblNewLabel, "cell 2 0,alignx right");


		lbTrocarFoto = new JLabelRedondo(); 
		lbTrocarFoto.setIcon(new ImageIcon(TelaConta.class.getResource("/ImagensPerfil/foto1.png")));
		lbTrocarFoto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_1.add(lbTrocarFoto, "cell 1 2,alignx right,aligny center");

		JLabel lblNewLabel_2 = new JLabel("Usuário:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_2, "flowx,cell 1 4");
		
		lbEditarNome = new JLabel("Editar usuario");
		lbEditarNome.setBackground(new Color(109, 171, 128));
		lbEditarNome.setForeground(new Color(39, 79, 65));
		panel_1.add(lbEditarNome, "cell 2 4");
				
		lbEditarNome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbEditarNome.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lbEditarNome.setForeground(new Color(109, 171, 128));
			}

			public void mouseExited(MouseEvent e) {
				lbEditarNome.setForeground(new Color(39, 79, 65));
			}
		});

		JLabel lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_3, "flowx,cell 1 6");
		
		lbEditarSenha = new JLabel("Editar senha");
		lbEditarSenha.setBackground(new Color(109, 171, 128));
		lbEditarSenha.setForeground(new Color(39, 79, 65));
		panel_1.add(lbEditarSenha, "cell 2 6");
				
		lbEditarSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lbEditarSenha.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				lbEditarSenha.setForeground(new Color(109, 171, 128));
			}

			public void mouseExited(MouseEvent e) {
				lbEditarSenha.setForeground(new Color(39, 79, 65)); 
			}
		});

		JLabel lblNewLabel_4 = new JLabel("E-Mail:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_4, "flowx,cell 1 8");

		JLabel lblNewLabel_5 = new JLabel("Chamados feitos:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_1.add(lblNewLabel_5, "flowx,cell 1 10");

		btnExcluirConta = new JButton("Excluir conta");
		btnExcluirConta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirConta.setBackground(new Color(160, 200, 172));
		panel_1.add(btnExcluirConta, "cell 0 12,alignx right");

		tfUsuario = new JTextField();
		tfUsuario.setForeground(new Color(0, 0, 0));
		tfUsuario.setBackground(new Color(209, 228, 216));
		tfUsuario.setEditable(false);
		panel_1.add(tfUsuario, "cell 1 4,growx");
		tfUsuario.setColumns(10);

		tfSenha = new JTextField();
		tfSenha.setBackground(new Color(216, 233, 221));
		tfSenha.setEditable(false);
		panel_1.add(tfSenha, "cell 1 6,growx");
		tfSenha.setColumns(10);

		tfEmail = new JTextField();
		tfEmail.setBackground(new Color(216, 233, 222));
		tfEmail.setEditable(false);
		panel_1.add(tfEmail, "cell 1 8,growx");
		tfEmail.setColumns(10);

		tfChamados = new JTextField();
		tfChamados.setBackground(new Color(216, 233, 221));
		tfChamados.setEditable(false);
		panel_1.add(tfChamados, "cell 1 10,growx");
		tfChamados.setColumns(10);

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
		String foto = usuario.getFoto();
	    if (foto != null && !foto.isEmpty()) {
	    	System.out.println(foto);
	        atualizarFoto(foto);
	    }
	}

	public void atualizarFoto(String nomeFoto) {
		System.out.println(TelaConta.class.getResource("/ImagensPerfil/" + nomeFoto));
		lbTrocarFoto.setIcon(new ImageIcon(TelaConta.class.getResource("/ImagensPerfil/" + nomeFoto)));
	}

	public void escolherFoto(MouseListener mouseListener) {
		this.lbTrocarFoto.addMouseListener(mouseListener);
	}
	
	public void atualizarQntdChamado(int quantidade) {
		tfChamados.setText("" + quantidade);
	}

	
	public void irInicioADM(ActionListener actionListener) {
	    this.btVoltar.addMouseListener(new MouseAdapter() {
	        public void mouseClicked(MouseEvent e) {
	            actionListener.actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, null));
	        }
	    });
	}
}