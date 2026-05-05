package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import java.awt.Color;

public class TelaInicialADM extends JPanel {

	private static final long serialVersionUID = 1L;
	private JButton btnVerPatrimonio, btnNovosChamados, btnHistoricoChamado, btnVerPerfil;

	public TelaInicialADM() {
		setBackground(new Color(240, 240, 240));
		setBounds(100, 100, 800, 500);
		setLayout(new MigLayout("", "[grow][grow][grow 10][grow 50][grow]",
				"[grow][grow][grow 10][grow][grow 10][grow][grow]"));
		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaInicialADM.class.getResource("/Imagens/40.png")));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 70));
		add(lblNewLabel, "cell 1 1 3 1,alignx center");

		btnVerPatrimonio = new JButton("Ver Patrimônios");
		btnVerPatrimonio.setBackground(new Color(122, 188, 170));
		btnVerPatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnVerPatrimonio, "cell 1 3,grow");

		btnNovosChamados = new JButton("Novos Chamados");
		btnNovosChamados.setBackground(new Color(122, 188, 170));
		btnNovosChamados.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnNovosChamados, "cell 3 3,grow");

		btnVerPerfil = new JButton("Ver Perfil");
		btnVerPerfil.setBackground(new Color(122, 188, 170));
		btnVerPerfil.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnVerPerfil, "cell 1 5,grow");

		btnHistoricoChamado = new JButton("Histórico de Chamados");
		btnHistoricoChamado.setBackground(new Color(122, 188, 170));
		btnHistoricoChamado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add(btnHistoricoChamado, "cell 3 5,grow");

	}
	public void verPatrimonio(ActionListener actionListener) {
		this.btnVerPatrimonio.addActionListener(actionListener);
	}

	public void chamado(ActionListener actionListener) {
		this.btnNovosChamados.addActionListener(actionListener);
	}
	public void historico(ActionListener actionListener) {
		this.btnHistoricoChamado.addActionListener(actionListener);
	}

	public void verPerfil(ActionListener actionListener) {
		this.btnVerPerfil.addActionListener(actionListener);
	}

}
