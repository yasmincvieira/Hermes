package view;

import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Color;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
<<<<<<< HEAD
=======

import java.awt.event.MouseAdapter;
>>>>>>> origin/branchJulia_voltar
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;

public class MenuContraidoTeste extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lbAbrir;
	private JLabelRedondo lbPerfilCont;

	public MenuContraidoTeste() {

		setBackground(new Color(147, 195, 171));
<<<<<<< HEAD
		setPreferredSize(new Dimension(55, 640));
=======

		setPreferredSize(new Dimension(44, 640));
>>>>>>> origin/branchJulia_voltar

		// AJUSTADO: "pushy" faz com que o espaço vazio empurre os elementos, jogando o perfil para o final sem esticar o componente
		setLayout(new MigLayout("ins 10 0 15 0, gapy 0", "[center, grow]", "[][]push[bottom]"));

		lbAbrir = new JLabel("");
		lbAbrir.setIcon(new ImageIcon(MenuContraidoTeste.class.getResource("/Imagens/30Menu.png")));
<<<<<<< HEAD
		// AJUSTADO: Adicionado explicitamente na célula da primeira linha
		add(lbAbrir, "cell 0 0, alignx center, aligny top");
=======
		add(lbAbrir, "cell 0 0,alignx center,aligny top");

		JLabel lbPerfil = new JLabel("");
		lbPerfil.setIcon(new ImageIcon(MenuContraidoTeste.class.getResource("/Imagens/30Usuario.png")));
		add(lbPerfil, "cell 0 1");
>>>>>>> origin/branchJulia_voltar

		lbPerfilCont = new JLabelRedondo();
		lbPerfilCont.setIcon(new ImageIcon(MenuContraidoTeste.class.getResource("/Imagens/30Usuario.png")));
		
		// Trava as dimensões do componente redondo
		java.awt.Dimension tamMenuCont = new java.awt.Dimension(35, 35);
		lbPerfilCont.setPreferredSize(tamMenuCont);
		lbPerfilCont.setMinimumSize(tamMenuCont);
		lbPerfilCont.setMaximumSize(tamMenuCont);
		
		// AJUSTADO: Adicionado explicitamente na última linha (cell 0 2), centralizado e sem esticar
		add(lbPerfilCont, "cell 0 2, alignx center, aligny bottom, w 35!, h 35!");
	}

	public void mostrarMenuExpandido(MouseListener mouseListener) {
		this.lbAbrir.addMouseListener(mouseListener);
	}
<<<<<<< HEAD
	
	public void atualizarFotoMenu(String avatarEscolhido) {
	    if (this.lbPerfilCont != null) {
	        lbPerfilCont.setIcon(new ImageIcon(MenuContraidoTeste.class.getResource("/ImagensPerfil/" + avatarEscolhido)));
	        lbPerfilCont.repaint(); 
	    }
	}
=======

	public void mostrarMenuExpandidoAdm(MouseAdapter mouseAdapter) {
		 this.lbAbrir.addMouseListener(mouseAdapter);
		
	}

>>>>>>> origin/branchJulia_voltar
}
