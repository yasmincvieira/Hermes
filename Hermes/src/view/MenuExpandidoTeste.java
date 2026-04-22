
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

public class MenuExpandidoTeste extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbFechar;
	private JButton btnHistorico, btnSair, btnPerfil, btnInicio;

	public MenuExpandidoTeste() {

		setBackground(new Color(147, 195, 171));

		setPreferredSize(new Dimension(200, 640));

		setLayout(new MigLayout("gap 18", "[200.00,grow]", "[35.00][31.00][31.00][372.00][31.00][31.00]"));

		lbFechar = new JLabel("");
		lbFechar.setIcon(new ImageIcon(MenuExpandidoTeste.class.getResource("/Imagens/30FecharMenu.png")));
		add(lbFechar, "cell 0 0,alignx right");

		btnInicio = new JButton("Inicio");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInicio.setBackground(new Color(175, 207, 198));
		add(btnInicio, "cell 0 1,grow");

		btnHistorico = new JButton("Histórico");
		btnHistorico.setBackground(new Color(175, 207, 198));
		btnHistorico.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnHistorico, "cell 0 2,grow");

		btnSair = new JButton("Sair");
		btnSair.setBackground(new Color(175, 207, 198));
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnSair, "cell 0 4,grow");

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuExpandidoTeste.class.getResource("/Imagens/30Usuario.png")));
		add(lblNewLabel_1, "flowx,cell 0 5");

		btnPerfil = new JButton("Ver Perfil");
		btnPerfil.setBackground(new Color(175, 207, 198));
		btnPerfil.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnPerfil, "cell 0 5,growx");

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
	public void irInicio(ActionListener actionListener) {
		this.btnInicio.addActionListener(actionListener);
	}
	public void irPerfil(ActionListener actionListener) {
		this.btnPerfil.addActionListener(actionListener);
	}
	
}
