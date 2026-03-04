package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Color;
import java.awt.Label;
import java.awt.Choice;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;

public class TelaVizuChamadosADM extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaVizuChamadosADM() {
		
		setBounds(100, 100, 800, 500);
		setLayout(new BorderLayout(0, 0));
		
		JPanel MenuChamadoVizu = new JPanel();
		MenuChamadoVizu.setBackground(new Color(147, 195, 171));
		add(MenuChamadoVizu, BorderLayout.WEST);
		MenuChamadoVizu.setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(TelaVizuChamadosADM.class.getResource("/Imagens/voltar20.png")));
		MenuChamadoVizu.add(lblNewLabel_5, "cell 0 0");
		
		JPanel panelVizuChamadosADM = new JPanel();
		panelVizuChamadosADM.setBackground(new Color(234, 242, 236));
		add(panelVizuChamadosADM, BorderLayout.CENTER);
		panelVizuChamadosADM.setLayout(new MigLayout("", "[][grow 5][grow][grow 5]", "[][][grow 3][grow 2][grow 3][grow 2][grow 3][grow 2][grow 3][grow 3]"));
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(panel_2, "cell 1 0");
		
		JTextArea textArea_3 = new JTextArea();
		panel_2.add(textArea_3);
		
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setIcon(new ImageIcon(TelaVizuChamadosADM.class.getResource("/Imagens/40.png")));
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panelVizuChamadosADM.add(lblNewLabel, "cell 3 0");
		
		JLabel lblNewLabel_1 = new JLabel("Status:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_1, "cell 1 2,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(160, 200, 172));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em análise", "Inativo", "Resolvido", "Invalido"}));
		panelVizuChamadosADM.add(comboBox, "cell 2 2,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Nome do patrimônio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_2, "cell 1 4,alignx right");
		
		JTextArea taNomePatrimonio = new JTextArea();
		taNomePatrimonio.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taNomePatrimonio, "cell 2 4,growx,aligny center");
		
		JLabel lblNewLabel_3 = new JLabel("Local:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_3, "cell 1 6,alignx right");
		
		JTextArea taLocal = new JTextArea();
		taLocal.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taLocal, "cell 2 6,growx,aligny center");
		
		JLabel lblNewLabel_4 = new JLabel("Descrição:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_4, "cell 1 8,alignx right");
		
		JTextArea taDescricao = new JTextArea();
		taDescricao.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taDescricao, "cell 2 8,grow");

	}

}
