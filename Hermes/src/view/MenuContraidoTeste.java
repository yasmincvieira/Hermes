
package view;

import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.Color;

import net.miginfocom.swing.MigLayout;

import javax.swing.JLabel;

import java.awt.event.MouseListener;



import javax.swing.ImageIcon;



public class MenuContraidoTeste extends JPanel {



	private static final long serialVersionUID = 1L;

	private JLabel lbMostrarMenuExp;



	public MenuContraidoTeste() {

		

		setBackground(new Color(147, 195, 171));


		setPreferredSize(new Dimension(55, 640));

		setLayout(new MigLayout("", "[center]", "[91.00,top][597.00,bottom]"));


		lbMostrarMenuExp = new JLabel(""){

		    @Override

		    public java.awt.Point getToolTipLocation(java.awt.event.MouseEvent event) {

		        return new java.awt.Point(getWidth(), 10);

		    }

		};

		
		add(lbMostrarMenuExp, "flowx,cell 0 0");

		
		lbMostrarMenuExp.setToolTipText("Menu");
		
		JLabel lbAbrir = new JLabel("");
		lbAbrir.setIcon(new ImageIcon(MenuContraidoTeste.class.getResource("/Imagens/30Menu.png")));
		add(lbAbrir, "cell 0 0,alignx center");
		
		JLabel lbPerfil = new JLabel("");
		lbPerfil.setIcon(new ImageIcon(MenuContraidoTeste.class.getResource("/Imagens/30Usuario.png")));
		add(lbPerfil, "cell 0 1");


	}


	public void mostrarMenuExpandido(MouseListener mouseListener) {

		this.lbMostrarMenuExp.addMouseListener(mouseListener);

	}



}
