package view;

import java.awt.Color;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class TelaEditarPatrimonio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public TelaEditarPatrimonio() {
		
		setBackground(new Color(240, 240, 240));
		setForeground(new Color(255, 255, 255));
		setBounds(100, 100, 800, 500);
		setLayout(new MigLayout("", "[grow][163.00,grow][370.00,grow][grow]", "[137.00,grow][43][43][43][43][72.00,grow]"));
		
		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel, "cell 0 0,alignx left,aligny top");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 200, 172));
		add(panel, "flowx,cell 2 0,growx,aligny center");
		
		JLabel lblNewLabel_1 = new JLabel("Editar Patrimônio");
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(38, 76, 63));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(160, 200, 172));
		
		JLabel lblNewLabel_2 = new JLabel("HERMES");
		lblNewLabel_2.setIcon(new ImageIcon(TelaEditarPatrimonio.class.getResource("/Imagens/40.png")));
		lblNewLabel_2.setForeground(new Color(39, 79, 65));
		lblNewLabel_2.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		add(lblNewLabel_2, "flowx,cell 3 0,alignx right,aligny top");
		
		JLabel lblNewLabel_3 = new JLabel("ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNewLabel_3, "cell 1 1,alignx trailing");
		
		textField = new JTextField();
		add(textField, "cell 2 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("Patrimônio");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNewLabel_3_1, "cell 1 2,alignx trailing");
		
		textField_1 = new JTextField();
		add(textField_1, "cell 2 2,growx");
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Espaço");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNewLabel_3_1_1, "cell 1 3,alignx trailing");
		
		JComboBox cbEspaco = new JComboBox();
		add(cbEspaco, "cell 2 3,growx");
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Status");
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		add(lblNewLabel_3_1_1_1, "cell 1 4,alignx trailing");
		
		JComboBox cbStatus = new JComboBox();
		add(cbStatus, "cell 2 4,growx");
		
		JButton btnSalvar = new JButton("Salvar Alterações");
		btnSalvar.setBackground(new Color(126, 182, 143));
		btnSalvar.setForeground(new Color(0, 64, 0));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnSalvar, "cell 2 5,alignx right,aligny top");

		
	}

}
