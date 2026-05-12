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
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JTextArea;

import models.Chamado;

import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class TelaVizuChamados extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextArea taStatus, taNomePatrimonio, taLocal, taDescricao, taChamado;
	private JButton btnVoltar;

	
	public TelaVizuChamados() {

		setBounds(100, 100, 800, 500);
		setLayout(new BorderLayout(0, 0));

		JPanel panelVizuChamadosADM = new JPanel();
		panelVizuChamadosADM.setBackground(new Color(234, 242, 236));
		add(panelVizuChamadosADM, BorderLayout.CENTER);
		panelVizuChamadosADM.setLayout(new MigLayout("", "[][grow 5][grow][grow 5]", "[][grow 3][grow 2][grow 3][grow 2][grow 3][grow 2][grow 3][grow 3]"));
		
		btnVoltar = new JButton("");
		btnVoltar.setBackground(new Color(234, 242, 236));
		btnVoltar.setIcon(new ImageIcon(TelaVizuChamados.class.getResource("/Imagens/voltar20.png")));
		panelVizuChamadosADM.add(btnVoltar, "cell 0 0,alignx center,growy");

		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(panel_2, "cell 1 0");

		taChamado = new JTextArea();
		taChamado.setFont(new Font("Monospaced", Font.PLAIN, 18));
		taChamado.setEditable(false);
		panel_2.add(taChamado);

		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setIcon(new ImageIcon(TelaVizuChamados.class.getResource("/Imagens/40.png")));
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panelVizuChamadosADM.add(lblNewLabel, "cell 3 0");

		JLabel lblNewLabel_1 = new JLabel("Status:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_1, "cell 1 1,alignx trailing");
		
		taStatus = new JTextArea();
		taStatus.setFont(new Font("Monospaced", Font.PLAIN, 18));
		taStatus.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taStatus, "cell 2 1,growx,aligny center");

		JLabel lblNewLabel_2 = new JLabel("Nome do patrimônio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_2, "cell 1 3,alignx right");

		taNomePatrimonio = new JTextArea();
		taNomePatrimonio.setFont(new Font("Monospaced", Font.PLAIN, 18));
		taNomePatrimonio.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taNomePatrimonio, "cell 2 3,growx,aligny center");

		JLabel lblNewLabel_3 = new JLabel("Local:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_3, "cell 1 5,alignx right");

		taLocal = new JTextArea();
		taLocal.setFont(new Font("Monospaced", Font.PLAIN, 18));
		taLocal.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taLocal, "cell 2 5,growx,aligny center");

		JLabel lblNewLabel_4 = new JLabel("Descrição:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelVizuChamadosADM.add(lblNewLabel_4, "cell 1 7,alignx right");

		taDescricao = new JTextArea();
		taDescricao.setFont(new Font("Monospaced", Font.PLAIN, 18));
		taDescricao.setBackground(new Color(160, 200, 172));
		panelVizuChamadosADM.add(taDescricao, "cell 2 7,grow");

	}
	
	public void preencherDados(Chamado chamado) {
        taChamado.setText("Chamado #" + chamado.getIdChamado());
        taStatus.setText(chamado.getStatus());
        taNomePatrimonio.setText(chamado.getNome());
        taLocal.setText(chamado.getLocal());
        taDescricao.setText(chamado.getDescricao());
    }
	
	public void voltar (ActionListener actionListener) {
		this.btnVoltar.addActionListener(actionListener);
	}

}
