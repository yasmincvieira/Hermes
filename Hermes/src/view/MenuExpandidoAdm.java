
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MenuExpandidoAdm extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbFechar;
	private JButton btnHistorico, btnSair, btnPerfilAdm, btnInicioAdm;
	private JButton btnTabela;
	private JButton btnNovosChamados;

	public MenuExpandidoAdm() {

		setBackground(new Color(147, 195, 171));

		setPreferredSize(new Dimension(200, 640));

		setLayout(new MigLayout("gap 18", "[200.00,grow]", "[35.00][31.00][31.00][][372.00][31.00][31.00]"));

		lbFechar = new JLabel("");
		lbFechar.setIcon(new ImageIcon(MenuExpandidoTeste.class.getResource("/Imagens/30FecharMenu.png")));
		add(lbFechar, "cell 0 0,alignx right");

		btnInicioAdm = new JButton("Início");
		btnInicioAdm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInicioAdm.setBackground(new Color(175, 207, 198));
		add(btnInicioAdm, "cell 0 1,grow");

		btnHistorico = new JButton("Histórico");
		btnHistorico.setBackground(new Color(175, 207, 198));
		btnHistorico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnHistorico, "cell 0 2,grow");
		
		btnNovosChamados = new JButton("Novos Chamados");
		btnNovosChamados.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnNovosChamados, "cell 0 3,growx");
		
		btnTabela = new JButton("Tabela de Patrimônios");
		btnTabela.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnTabela, "cell 0 4,growx,aligny top");

		btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(175, 207, 198));
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnSair, "cell 0 5,grow");

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuExpandidoTeste.class.getResource("/Imagens/30Usuario.png")));
		add(lblNewLabel_1, "flowx,cell 0 6");

		btnPerfilAdm = new JButton("Ver Perfil");
		btnPerfilAdm.setBackground(new Color(175, 207, 198));
		btnPerfilAdm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnPerfilAdm, "cell 0 6,growx");

	}

	public void mostrarMenuContraido(MouseListener mouseListener) {

		this.lbFechar.addMouseListener(mouseListener);
	}

	public void irHistorico(ActionListener actionListener) {
		this.btnHistorico.addActionListener(actionListener);
	}

	public void sair(ActionListener actionListener) {
		this.btnSair.addActionListener(actionListener);
	}

	public void irInicioADM(ActionListener actionListener) {
		this.btnInicioAdm.addActionListener(actionListener);
	}

	public void irPerfil(ActionListener actionListener) {
		this.btnPerfilAdm.addActionListener(actionListener);
	}
	public void irNovosChamados(ActionListener actionListener) {
		this.btnNovosChamados.addActionListener(actionListener);
	}
	public void irTabela(ActionListener actionListener) {
		this.btnTabela.addActionListener(actionListener);
	}



	



}