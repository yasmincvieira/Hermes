package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JLabelRedondo extends JLabel {
    private static final long serialVersionUID = 1L;
    private Color corBorda = Color.GRAY;
    private int espessuraBorda = 1;
    
    // Define o tamanho padrão fixo para todos os avatares (Pode alterar aqui se quiser maior ou menor)
    private static final int TAMANHO_FIXO = 120; 

    public JLabelRedondo() {
        // Garante que o componente avise o layout manager sobre seu tamanho exato
        Dimension dim = new Dimension(TAMANHO_FIXO, TAMANHO_FIXO);
        setPreferredSize(dim);
        setMinimumSize(dim);
        setMaximumSize(dim);
    }

    public void setConfiguracaoBorda(Color cor, int espessura) {
        this.corBorda = cor;
        this.espessuraBorda = espessura;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        int largura = getWidth();
        int altura = getHeight();
        int diametro = Math.min(largura, altura) - espessuraBorda;
        
        int x = (largura - diametro) / 2;
        int y = (altura - diametro) / 2;
        
        Ellipse2D.Double circulo = new Ellipse2D.Double(x, y, diametro, diametro);
        g2d.setClip(circulo);


        Icon icon = getIcon();
        if (icon instanceof ImageIcon) {
            Image img = ((ImageIcon) icon).getImage();
           
            g2d.drawImage(img, x, y, diametro, diametro, this);
        } else {
            super.paintComponent(g2d);
        }

      
        g2d.setClip(null);
        g2d.setColor(corBorda);
        g2d.setStroke(new java.awt.BasicStroke(espessuraBorda));
        g2d.draw(circulo);

        g2d.dispose();
    }
}
