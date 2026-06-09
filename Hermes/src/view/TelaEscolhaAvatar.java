package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import net.miginfocom.swing.MigLayout;

public class TelaEscolhaAvatar extends JDialog {

	private static final long serialVersionUID = 1L;
	private String avatarEscolhido = null;

	public TelaEscolhaAvatar() {
		setTitle("Escolha seu avatar");
		setModal(true); 
		setSize(400, 200);
		setBounds(100, 100, 800, 500);
		setLocationRelativeTo(null);
		setLayout(new MigLayout("wrap 5, ins 20", "[]15[]15[]15[]15[]", "[]20[:120:, center]"));

		JLabel titulo = new JLabel("Escolha seu avatar:");
		titulo.setFont(new Font("Tahoma", Font.BOLD, 14));
		add(titulo, "span 5, wrap");

		String[] avatars = { "foto1.png", "foto2.jpg", "foto3.jpg", "foto4.jpg", "foto5.jpg" };

		for (String avatar : avatars) {

			JLabelRedondo lblAvatar = new JLabelRedondo();
			lblAvatar.setIcon(new ImageIcon(TelaEscolhaAvatar.class.getResource("/ImagensPerfil/" + avatar)));
			lblAvatar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
			lblAvatar.setConfiguracaoBorda(Color.GRAY, 1);

			lblAvatar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					avatarEscolhido = avatar;
					dispose(); 
				}

				@Override
				public void mouseEntered(MouseEvent e) {
					lblAvatar.setConfiguracaoBorda(new Color(39, 79, 65), 3);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					lblAvatar.setConfiguracaoBorda(Color.GRAY, 1);
				}
			});

			add(lblAvatar, "aligny center");
		}
	}

	public String getAvatarEscolhido() {
		return avatarEscolhido;
	}
}
