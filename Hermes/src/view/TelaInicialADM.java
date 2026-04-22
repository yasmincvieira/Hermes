package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Color;

public class TelaInicialADM extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaInicialADM() {
		setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 800, 500);
		setLayout(new MigLayout("", "[grow][grow][grow 10][grow 50][grow]",
				"[grow][grow][grow 10][grow][grow 10][grow][grow]"));
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaInicialADM.class.getResource("/Imagens/40.png")));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		add(lblNewLabel, "cell 1 1 3 1,alignx center");

		JButton btnNewButton = new JButton("Ver Patrimônios");
		btnNewButton.setBackground(new Color(122, 188, 170));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnNewButton, "cell 1 3,grow");

		JButton btnNewButton_3 = new JButton("Novos Chamados");
		btnNewButton_3.setBackground(new Color(122, 188, 170));
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnNewButton_3, "cell 3 3,grow");

		JButton btnNewButton_1 = new JButton("Ver Perfil");
		btnNewButton_1.setBackground(new Color(122, 188, 170));
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnNewButton_1, "cell 1 5,grow");

		JButton btnNewButton_2 = new JButton("Histórico de Chamados");
		btnNewButton_2.setBackground(new Color(122, 188, 170));
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnNewButton_2, "cell 3 5,grow");

	}

}
