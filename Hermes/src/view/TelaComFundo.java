package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class TelaComFundo extends JPanel{
	
	private Image imagem = new ImageIcon("Hermes/src/Imagens/fundo.png").getImage();
	
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
        }
	
}
