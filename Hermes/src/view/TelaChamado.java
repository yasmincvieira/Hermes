package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class TelaChamado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Create the panel.
	 */
	public TelaChamado() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[grow,top][]"));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel.add(lblNewLabel_1, "cell 0 0,alignx left");
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel, "cell 0 1");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[grow][grow 5][204px:n,grow 35][500:n,grow]", "[grow][grow 15][grow 5][grow 3][grow 5][grow 3][grow 5][grow 5][grow 5][grow 5][grow][grow]"));
		
		JLabel lblNewLabel_6 = new JLabel("HERMES");
		lblNewLabel_6.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panel_1.add(lblNewLabel_6, "cell 3 0,alignx left");
		
		JLabel lblNewLabel_2 = new JLabel("Nome do Patrimônio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_2, "cell 1 2,alignx trailing");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 2 2,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Local:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_3, "cell 1 4,alignx left");
		
		textField_1 = new JTextField();
		panel_1.add(textField_1, "cell 2 4,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("ID do Patrimônio:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_4, "cell 1 6,alignx left");
		
		textField_2 = new JTextField();
		panel_1.add(textField_2, "cell 2 6,growx");
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Descrição:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(lblNewLabel_5, "cell 1 8,alignx left");
		
		textField_3 = new JTextField();
		panel_1.add(textField_3, "cell 2 8,growx");
		textField_3.setColumns(10);

	}

}
