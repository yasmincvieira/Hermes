
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class MenuExpandidoTeste extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbMostrarMenuCont;

	public MenuExpandidoTeste() {

	
		setBackground(new Color(147, 195, 171));

		
		setPreferredSize(new Dimension(200,640));

		setLayout(new MigLayout("gap 18", "[200.00,grow]", "[35.00][31.00][31.00][372.00][31.00][31.00]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(MenuExpandidoTeste.class.getResource("/Imagens/30FecharMenu.png")));
		add(lblNewLabel, "cell 0 0,alignx right");
		
		JButton btnNewButton = new JButton("Inicio");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(new Color(175, 207, 198));
		add(btnNewButton, "cell 0 1,grow");
		
		JButton btnNewButton_3 = new JButton("Histórico");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnNewButton_3, "cell 0 2,grow");
		
		JButton btnNewButton_1 = new JButton("Sair");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnNewButton_1, "cell 0 4,grow");
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuExpandidoTeste.class.getResource("/Imagens/30Usuario.png")));
		add(lblNewLabel_1, "flowx,cell 0 5");
		
		JButton btnNewButton_2 = new JButton("Ver Perfil");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		add(btnNewButton_2, "cell 0 5,growx");



	}
	
	public void mostrarMenuContraido(MouseListener mouseListener) {

		this.lbMostrarMenuCont.addMouseListener(mouseListener);

	}

}
