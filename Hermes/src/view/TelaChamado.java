package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;

public class TelaChamado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfIPatrimonio;

	/**
	 * Create the panel.
	 */
	public TelaChamado() {
		setLayout(new BorderLayout(0, 0));
		setBounds(100, 100, 800, 500);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(147, 195, 171));
		panelMenu.setForeground(new Color(147, 195, 171));
		add(panelMenu, BorderLayout.WEST);
		panelMenu.setLayout(new MigLayout("", "[]", "[grow,top][]"));
		
		JLabel lbIconMenu = new JLabel("");
		lbIconMenu.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/30Menu.png")));
		panelMenu.add(lbIconMenu, "cell 0 0,alignx right");
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/30Usuario.png")));
		panelMenu.add(lblNewLabel, "cell 0 1");
		
		JPanel panelChamado = new JPanel();
		panelChamado.setBackground(new Color(234, 242, 236));
		add(panelChamado, BorderLayout.CENTER);
		panelChamado.setLayout(new MigLayout("", "[grow][grow 5][204px:n,grow][grow]", "[][][][][][][][][grow][][][]"));
		
		JLabel lblNewLabel_6 = new JLabel("HERMES");
		lblNewLabel_6.setForeground(new Color(39, 79, 65));
		lblNewLabel_6.setIcon(new ImageIcon(TelaChamado.class.getResource("/Imagens/40.png")));
		lblNewLabel_6.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panelChamado.add(lblNewLabel_6, "cell 2 0 2 1,alignx right");
		
		JLabel lbNomePatrimonio = new JLabel("Nome do Patrimônio:");
		lbNomePatrimonio.setBackground(new Color(38, 76, 63));
		lbNomePatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbNomePatrimonio, "cell 1 2,alignx trailing");
		
		JComboBox cbNomePatrimonio = new JComboBox();
		cbNomePatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbNomePatrimonio.setModel(new DefaultComboBoxModel(new String[] {"Cadeira", "Mesa", "Quadro", "Ar-Condicionado"}));
		cbNomePatrimonio.setForeground(new Color(38, 76, 63));
		cbNomePatrimonio.setBackground(new Color(160, 200, 172));
		panelChamado.add(cbNomePatrimonio, "cell 2 2,growx");
		
		JLabel lbLocal = new JLabel("Local:");
		lbLocal.setBackground(new Color(38, 76, 63));
		lbLocal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbLocal, "cell 1 4,alignx left");
		
		JComboBox cbLocal = new JComboBox();
		cbLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLocal.setModel(new DefaultComboBoxModel(new String[] {"Sala 1", "Sala 2", "Sala 3", "Sala 4"}));
		cbLocal.setForeground(new Color(38, 76, 63));
		cbLocal.setBackground(new Color(160, 200, 172));
		panelChamado.add(cbLocal, "cell 2 4,growx");
		
		JLabel lbIDPatrimonio = new JLabel("ID do Patrimônio:");
		lbIDPatrimonio.setBackground(new Color(240, 240, 240));
		lbIDPatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbIDPatrimonio, "cell 1 6,alignx left");
		
		tfIPatrimonio = new JTextField();
		tfIPatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfIPatrimonio.setBackground(new Color(160, 200, 172));
		panelChamado.add(tfIPatrimonio, "cell 2 6,growx");
		tfIPatrimonio.setColumns(10);
		
		JLabel lbDescricao = new JLabel("Descrição:");
		lbDescricao.setBackground(new Color(240, 240, 240));
		lbDescricao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbDescricao, "cell 1 8,alignx left,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
		panelChamado.add(scrollPane, "cell 2 8,grow");
		
		JTextArea taDescricao = new JTextArea();
		taDescricao.setBackground(new Color(160, 200, 172));
		scrollPane.setViewportView(taDescricao);
		
		JButton btnNewButton = new JButton("Realizar chamado");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setForeground(new Color(38, 76, 63));
		btnNewButton.setBackground(new Color(160, 200, 172));
		panelChamado.add(btnNewButton, "cell 2 10,alignx center");

	}

}
