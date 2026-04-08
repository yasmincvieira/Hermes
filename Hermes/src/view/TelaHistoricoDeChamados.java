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
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

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
		lblNewLabel.setIcon(new ImageIcon(TelaHistoricoDeChamados.class.getResource("/Imagens/30Menu.png")));
		panel.add(lblNewLabel, "cell 0 0");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(234, 242, 236));
		add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[][265.00,grow][][265.00,grow 5][][265.00,grow][]", "[71.00,grow][150.00,grow][38.00][154.00,grow][grow][grow]"));
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_4_1, "cell 1 1,grow");
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_4, "cell 3 1,grow");
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_2, "cell 1 0");
		
		JLabel lblNewLabel_1 = new JLabel("Histórico de Chamados");
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(147, 195, 171));
		lblNewLabel_1.setForeground(new Color(38, 80, 55));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_5, "cell 5 1,grow");
		
		JPanel panel_3_1_1 = new JPanel();
		panel_3_1_1.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_3_1_1, "cell 1 3,grow");
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_3_1, "cell 3 3,grow");
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(147, 195, 171));
		panel_1.add(panel_3_2, "cell 5 3,grow");

	}
}
