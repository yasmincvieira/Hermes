package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class TelaTabelaPatrimonios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaTabelaPatrimonios() {

		setBounds(100, 100, 800, 500);
		setLayout(new BorderLayout(0, 0));
		
		JPanel MenuTabelaPatrimonio = new JPanel();
		MenuTabelaPatrimonio.setBackground(new Color(147, 195, 171));
		add(MenuTabelaPatrimonio, BorderLayout.WEST);
		MenuTabelaPatrimonio.setLayout(new MigLayout("", "[47.00,grow 5]", "[grow]"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaTabelaPatrimonios.class.getResource("/Imagens/voltar20.png")));
		MenuTabelaPatrimonio.add(lblNewLabel_3, "cell 0 0,alignx center,aligny top");
		
		JPanel paneltabelaPatrimonio = new JPanel();
		add(paneltabelaPatrimonio, BorderLayout.CENTER);
		paneltabelaPatrimonio.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][::60px]", "[::60px,grow][100px:n,grow][grow][grow]"));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 200, 172));
		paneltabelaPatrimonio.add(panel, "cell 0 0 2 1");
		
		JLabel lblNewLabel_1 = new JLabel("Patrimônios");
		lblNewLabel_1.setForeground(new Color(38, 76, 63));
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(160, 200, 172));
		
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaTabelaPatrimonios.class.getResource("/Imagens/40.png")));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		paneltabelaPatrimonio.add(lblNewLabel, "cell 3 0 4 1,alignx right");
		
		JScrollPane scrollPane = new JScrollPane();
		paneltabelaPatrimonio.add(scrollPane, "cell 1 1 5 2,grow");
		
				table = new JTable();
				table.setModel(new DefaultTableModel(
					new Object[][] { 
						{"Ar-condicionado", "lab 6", "736073", "Em an\u00E1lise"},
						{"Cpu", "Lab 6", "770744", "Ativo"},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
						{null, null, null, null},
					},
					new String[] {
						"Patrim\u00F4nio", "Espa\u00E7o", "Id", "Status"
					}
				));
				scrollPane.setViewportView(table);
		
		JButton btEditarPatri = new JButton("Editar patrimônios");
		btEditarPatri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btEditarPatri.setForeground(new Color(39, 79, 65));
		btEditarPatri.setBackground(new Color(144, 204, 171));
		paneltabelaPatrimonio.add(btEditarPatri, "cell 2 3,alignx right");
		
		JButton btnNewButton_2 = new JButton("Adicionar patrimônio");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setForeground(new Color(39, 79, 65));
		btnNewButton_2.setBackground(new Color(144, 204, 171));
		paneltabelaPatrimonio.add(btnNewButton_2, "cell 3 3,alignx center");
		
		JButton btnNewButton_1 = new JButton("Excluir patrimônio");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setForeground(new Color(39, 79, 65));
		btnNewButton_1.setBackground(new Color(144, 204, 171));
		paneltabelaPatrimonio.add(btnNewButton_1, "cell 4 3,alignx left");
	}

}
