package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.Color;

public class TelaConta extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaConta() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 195, 171));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[grow,top][]"));
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/30Menu.png")));
		panel.add(lblNewLabel_6, "cell 0 0,alignx center");
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/30Usuario.png")));
		panel.add(lblNewLabel_7, "cell 0 1");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(216, 233, 221));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][][][]"));
		
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/40.png")));
		lblNewLabel.setBackground(new Color(39, 79, 65));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panel_1.add(lblNewLabel, "cell 2 0,alignx right");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaConta.class.getResource("/Imagens/adicionar-usuario150.png")));
		panel_1.add(lblNewLabel_1, "cell 1 2,alignx right");
		
		JLabel lblNewLabel_2 = new JLabel("Usuário:");
		panel_1.add(lblNewLabel_2, "cell 1 4");
		
		JLabel lblNewLabel_3 = new JLabel("Senha:");
		panel_1.add(lblNewLabel_3, "cell 1 6");
		
		JLabel lblNewLabel_4 = new JLabel("E-Mail:");
		panel_1.add(lblNewLabel_4, "cell 1 8");
		
		JLabel lblNewLabel_5 = new JLabel("Chamados feitos:");
		panel_1.add(lblNewLabel_5, "flowx,cell 1 10");
		
		JButton btnNewButton = new JButton("Excluir conta");
		btnNewButton.setBackground(new Color(160, 200, 172));
		panel_1.add(btnNewButton, "cell 0 12,alignx right");

	}

}
