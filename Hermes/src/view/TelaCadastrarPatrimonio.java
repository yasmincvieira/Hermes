
package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

public class TelaCadastrarPatrimonio extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfPatrimonio;
	private JButton btnConcluir;
	private JComboBox cbLocal, cbNome, cbStatus;
	




	/**
	 * Create the panel.
	 * @param status 
	 * @param nome 
	 * @param local 
	 * @param id_patrimonio 
	 */
	public TelaCadastrarPatrimonio() {
		setLayout(new BorderLayout(0, 0));
		setBounds(100, 100, 800, 500);

		JPanel panelChamado = new JPanel();
		panelChamado.setBackground(new Color(234, 242, 236));
		add(panelChamado, BorderLayout.CENTER);
		panelChamado.setLayout(
				new MigLayout("", "[grow][grow][grow][grow]", "[39.00,grow][49.00][][][][][][][23.00][][][]"));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 200, 172));
		panelChamado.add(panel, "cell 1 0,growx,aligny bottom");

		JLabel lblNewLabel = new JLabel("Cadastrar Patrimônio");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_6 = new JLabel("HERMES");
		lblNewLabel_6.setForeground(new Color(39, 79, 65));
		lblNewLabel_6.setIcon(new ImageIcon(TelaNovoChamado.class.getResource("/Imagens/40.png")));
		lblNewLabel_6.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panelChamado.add(lblNewLabel_6, "cell 2 0 2 1,alignx right,aligny top");

		JLabel lbNomePatrimonio = new JLabel("Nome do Patrimônio:");
		lbNomePatrimonio.setBackground(new Color(38, 76, 63));
		lbNomePatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbNomePatrimonio, "cell 1 2,alignx left");

		cbNome = new JComboBox();
		cbNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbNome.setModel(new DefaultComboBoxModel(new String[] { "Cadeira", "Mesa", "Quadro", "Ar-Condicionado" }));
		cbNome.setForeground(new Color(38, 76, 63));
		cbNome.setBackground(new Color(160, 200, 172));
		panelChamado.add(cbNome, "cell 2 2,growx");

		JLabel lbLocal = new JLabel("Local:");
		lbLocal.setBackground(new Color(38, 76, 63));
		lbLocal.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbLocal, "cell 1 4,alignx left");

		cbLocal = new JComboBox();
		cbLocal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLocal.setModel(new DefaultComboBoxModel(new String[] { "Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5",
				"Sala 6", "Sala 7", "Sala 8", "Sala 9", "Sala 10", "Sala 11", "Sala 12", "Sala 13", "Sala 14",
				"Sala 15", "Sala 16", "Sala 17", "Sala 17", "Sala 18", "Sala 19", "Lab Info 1", "Lab Info 2",
				"Lab Info 3", "Lab Info 4", "Lab Info 5", "Lab Info 6", "Lab Info 7", "Lab Química 1", "Lab Química 2",
				"Lab Química 3", "Lab Química 4", "Lab Química 5", "Lab Química 6" }));
		cbLocal.setForeground(new Color(38, 76, 63));
		cbLocal.setBackground(new Color(160, 200, 172));
		panelChamado.add(cbLocal, "cell 2 4,growx");

		JLabel lbIDPatrimonio = new JLabel("ID do Patrimônio:");
		lbIDPatrimonio.setBackground(new Color(240, 240, 240));
		lbIDPatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbIDPatrimonio, "flowy,cell 1 6,alignx left");

		tfPatrimonio = new JTextField();
		tfPatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tfPatrimonio.setBackground(new Color(160, 200, 172));
		panelChamado.add(tfPatrimonio, "cell 2 6,growx");
		tfPatrimonio.setColumns(10);

		JLabel lbDescricao = new JLabel("Status:");
		lbDescricao.setBackground(new Color(240, 240, 240));
		lbDescricao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbDescricao, "cell 1 8,alignx left,aligny top");

		cbStatus = new JComboBox();
		cbStatus.setForeground(new Color(38, 73, 63));
		cbStatus.setBackground(new Color(255, 255, 255));
		cbStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbStatus.setModel(new DefaultComboBoxModel(new String[] { "Inativo", "Ativo", "Em manutenção" }));
		panelChamado.add(cbStatus, "cell 2 8,grow");

		btnConcluir = new JButton("Concluir");
		btnConcluir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConcluir.setForeground(new Color(38, 76, 63));
		btnConcluir.setBackground(new Color(160, 200, 172));
		panelChamado.add(btnConcluir, "cell 2 10,alignx center");

	}

	
	public JTextField getTfPatrimonio() {
		return tfPatrimonio;
	}


	public void setTfPatrimonio(JTextField tfPatrimonio) {
		this.tfPatrimonio = tfPatrimonio;
	}


	public JComboBox getCbLocal() {
		return cbLocal;
	}


	public void setCbLocal(JComboBox cbLocal) {
		this.cbLocal = cbLocal;
	}


	public JComboBox getCbNome() {
		return cbNome;
	}


	public void setCbNome(JComboBox cbNome) {
		this.cbNome = cbNome;
	}


	public JComboBox getCbStatus() {
		return cbStatus;
	}


	public void setCbStatus(JComboBox cbStatus) {
		this.cbStatus = cbStatus;
	}


	public void concluir(ActionListener actionListener) {
		btnConcluir.addActionListener(actionListener);
	}



}