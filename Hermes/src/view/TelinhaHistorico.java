package view;

import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class TelinhaHistorico extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelinhaHistorico() {
		setBackground(new Color(187, 215, 194));
		setLayout(new MigLayout("", "[][]", "[][][grow][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Chamado # -");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel_1, "cell 0 0");
		
		JLabel lblNewLabel = new JLabel("Status:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(lblNewLabel, "cell 0 1");
		
		JButton btnNewButton = new JButton("Ver Detalhes...");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(187, 215, 194));
		add(btnNewButton, "cell 0 3");

	}

}
