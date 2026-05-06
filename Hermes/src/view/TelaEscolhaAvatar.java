package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;

public class TelaEscolhaAvatar extends JDialog {

    private String avatarEscolhido = null;

    public TelaEscolhaAvatar() {
        setTitle("Escolha seu avatar");
        setModal(true); // bloqueia a tela de trás
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new MigLayout("", "[][][][][]", "[][]"));

        JLabel titulo = new JLabel("Escolha seu avatar:");
        titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(titulo, "span 5, wrap");

        String[] avatars = {
        	    "foto1.png",
        	    "foto2.jpg",
        	    "foto3.jpg",
        	    "foto4.jpg",
        	    "foto5.jpg"
        	};

        for (String avatar : avatars) {
            JLabel lblAvatar = new JLabel();
            lblAvatar.setIcon(new ImageIcon(TelaEscolhaAvatar.class.getResource("/ImagensPerfil/" + avatar)));
            lblAvatar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            lblAvatar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));

            lblAvatar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    avatarEscolhido = avatar;
                    dispose(); // fecha o dialog
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    lblAvatar.setBorder(BorderFactory.createLineBorder(new Color(39, 79, 65), 3));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    lblAvatar.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                }
            });

            add(lblAvatar);
        }
    }

    public String getAvatarEscolhido() {
        return avatarEscolhido;
    }
}
