package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class TelaHistoricoDeChamados extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public TelaHistoricoDeChamados() {
		
		setBounds(100, 100, 800, 500);
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(147, 195, 171));
		add(panel, BorderLayout.WEST);
		panel.setLayout(new MigLayout("", "[]", "[]"));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaHistoricoDeChamados.class.getResource("/Imagens/voltar20.png")));
		panel.add(lblNewLabel, "cell 0 0");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 242, 236));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][][25px:n][grow][][grow][]", "[][][grow][][grow][]"));
		
		JLabel lblNewLabel_2 = new JLabel("HERMES");
		lblNewLabel_2.setIcon(new ImageIcon(TelaHistoricoDeChamados.class.getResource("/Imagens/40.png")));
		lblNewLabel_2.setForeground(new Color(39, 79, 65));
		lblNewLabel_2.setBackground(new Color(39, 79, 65));
		lblNewLabel_2.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		panel_1.add(lblNewLabel_2, "cell 2 0 5 1,alignx right,aligny center");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_2, "cell 1 0");
		
		JLabel lblNewLabel_1 = new JLabel("Histórico de Chamados");
		lblNewLabel_1.setForeground(new Color(39, 79, 65));
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(147, 195, 171));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_7, "cell 1 2,grow");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_4, "cell 3 2,grow");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_3, "cell 5 2,grow");
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_8, "cell 1 4,grow");
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_6, "cell 3 4,grow");
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_5, "cell 5 4,grow");

	}
}
