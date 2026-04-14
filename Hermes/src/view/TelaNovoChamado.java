package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;

public class TelaNovoChamado extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField tfPatrimonio;
	private JButton btnRealizarChamado;
	private JComboBox cbLocal, cbNomePatrimonio;
	private JTextArea daDescricao;

	/**
	 * Create the panel.
	 */
	public TelaNovoChamado() {
		setLayout(new BorderLayout(0, 0));
		setBounds(100, 100, 800, 500);
		
		JPanel panelChamado = new JPanel();
		panelChamado.setBackground(new Color(234, 242, 236));
		add(panelChamado, BorderLayout.CENTER);
		panelChamado.setLayout(new MigLayout("", "[grow][grow 5][204px:n,grow][grow]", "[][][][][][][][][grow][][][]"));
		
		JLabel lblNewLabel_6 = new JLabel("HERMES");
		lblNewLabel_6.setForeground(new Color(39, 79, 65));
		lblNewLabel_6.setIcon(new ImageIcon(TelaNovoChamado.class.getResource("/Imagens/40.png")));
		lblNewLabel_6.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panelChamado.add(lblNewLabel_6, "cell 2 0 2 1,alignx right");
		
		JLabel lbNomePatrimonio = new JLabel("Nome do Patrimônio:");
		lbNomePatrimonio.setBackground(new Color(38, 76, 63));
		lbNomePatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbNomePatrimonio, "cell 1 2,alignx left");
		
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
		cbLocal.setModel(new DefaultComboBoxModel(new String[] {"Sala 1", "Sala 2", "Sala 3", "Sala 4", "Sala 5", "Sala 6", "Sala 7", "Sala 8", "Sala 9", "Sala 10", "Sala 11", "Sala 12", "Sala 13", "Sala 14"
				, "Sala 15", "Sala 16", "Sala 17", "Sala 17", "Sala 18", "Sala 19", "Lab Info 1", "Lab Info 2", "Lab Info 3", "Lab Info 4", "Lab Info 5", "Lab Info 6", "Lab Info 7", "Lab Química 1", "Lab Química 2", "Lab Química 3"
				, "Lab Química 4", "Lab Química 5", "Lab Química 6"}));
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
		
		JLabel lbDescricao = new JLabel("Descrição:");
		lbDescricao.setBackground(new Color(240, 240, 240));
		lbDescricao.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelChamado.add(lbDescricao, "cell 1 8,alignx left,aligny top");
		
		JScrollPane scrollPane = new JScrollPane();
        //scrollPane.setPreferredSize(new Dimension(250, 300)); // Largura fixa e altura variável
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		panelChamado.add(scrollPane, "cell 2 8,grow");
		
		JTextArea taDescricao = new JTextArea();
		taDescricao.setBackground(new Color(160, 200, 172));
		taDescricao.setFont(new Font("Tahoma", Font.PLAIN, 17));
		taDescricao.setWrapStyleWord(true); // Quebra de linha em palavras completas
        taDescricao.setLineWrap(true); // Habilita a quebra de linha automática
		scrollPane.setViewportView(taDescricao);
		
		JButton btnRealizarChamado = new JButton("Realizar chamado");
		btnRealizarChamado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnRealizarChamado.setForeground(new Color(38, 76, 63));
		btnRealizarChamado.setBackground(new Color(160, 200, 172));
		panelChamado.add(btnRealizarChamado, "cell 2 10,alignx center");
		
		JLabel lblNewLabel_1 = new JLabel("(opcional)");
		lblNewLabel_1.setForeground(new Color(91, 91, 91));
		panelChamado.add(lblNewLabel_1, "cell 1 6");

	}
	public void realizarChamado(ActionListener actionListener) {
		this.btnRealizarChamado.addActionListener(actionListener);
	}

}
