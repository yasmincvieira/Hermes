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
		panelVizuChamadosADM.setLayout(new MigLayout("", "[][grow 5][grow][grow 5]", "[][][grow 3][grow 2][grow 3][grow 1][grow 1][grow 2][grow 3][grow 3]"));
		
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setIcon(new ImageIcon(TelaVizuChamadosADM.class.getResource("/Imagens/40.png")));
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panelVizuChamadosADM.add(lblNewLabel, "cell 3 0");
		
		JLabel lblNewLabel_1 = new JLabel("Status:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_1, "cell 1 2,alignx trailing");
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBackground(new Color(160, 200, 172));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Em análise", "Inativo", "Resolvido", "Invalido"}));
		panelVizuChamadosADM.add(comboBox, "cell 2 2,growx");
		
		JLabel lblNewLabel_2 = new JLabel("Nome do patrimônio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_2, "cell 1 3,alignx right,aligny top");
		
		JTextArea taNomePatrimonio = new JTextArea();
		taNomePatrimonio.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taNomePatrimonio, "cell 2 3,growx,aligny top");
		
		JLabel lblNewLabel_3 = new JLabel("Local:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_3, "cell 1 4,alignx right,aligny top");
		
		JTextArea taLocal = new JTextArea();
		taLocal.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taLocal, "cell 2 4,growx,aligny top");
		
		JLabel lblNewLabel_7 = new JLabel("ID do Patrimônio:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_7, "cell 1 5,alignx right,aligny center");
		
		JTextArea taLocal_1 = new JTextArea();
		taLocal_1.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taLocal_1, "cell 2 5,grow");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 195, 171));
		panelVizuChamadosADM.add(panel, "cell 1 0");
		
		JLabel lblNewLabel_6 = new JLabel("Chamado - ");
		panel.add(lblNewLabel_6);
		lblNewLabel_6.setForeground(new Color(39, 79, 65));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lblNewLabel_4 = new JLabel("Descrição:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_4, "cell 1 7,alignx right");
		
		JTextArea taDescricao = new JTextArea();
		taDescricao.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taDescricao, "cell 2 7 1 2,grow");

	}

}
