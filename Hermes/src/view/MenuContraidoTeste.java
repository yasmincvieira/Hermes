package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class MenuContraidoTeste extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbAbrir;
	private JLabelRedondo lbPerfilCont;

	public MenuContraidoTeste() {

		setBackground(new Color(147, 195, 171));
		setPreferredSize(new Dimension(55, 640));

	
		setLayout(new MigLayout("ins 10 0 15 0, gapy 0", "[center, grow]", "[][]push[bottom]"));

		lbAbrir = new JLabel("");
		lbAbrir.setIcon(new ImageIcon(MenuContraidoTeste.class.getResource("/Imagens/30Menu.png")));
	
		add(lbAbrir, "cell 0 0, alignx center, aligny top");

		lbPerfilCont = new JLabelRedondo();
		lbPerfilCont.setIcon(new ImageIcon(MenuContraidoTeste.class.getResource("/Imagens/30Usuario.png")));
		
		
		java.awt.Dimension tamMenuCont = new java.awt.Dimension(35, 35);
		lbPerfilCont.setPreferredSize(tamMenuCont);
		lbPerfilCont.setMinimumSize(tamMenuCont);
		lbPerfilCont.setMaximumSize(tamMenuCont);
		
		
		add(lbPerfilCont, "cell 0 2, alignx center, aligny bottom, w 35!, h 35!");
	}

	public void mostrarMenuExpandido(MouseListener mouseListener) {
		this.lbAbrir.addMouseListener(mouseListener);
	}
	
	public void atualizarFotoMenu(String avatarEscolhido) {
	    if (this.lbPerfilCont != null) {
	        lbPerfilCont.setIcon(new ImageIcon(MenuContraidoTeste.class.getResource("/ImagensPerfil/" + avatarEscolhido)));
	        lbPerfilCont.repaint(); 
	    }
	}

	public void mostrarMenuExpandidoAdm(MouseAdapter mouseAdapter) {
		 this.lbAbrir.addMouseListener(mouseAdapter);
		
	}

}
