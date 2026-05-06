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

public class TelaHistoricoDeChamados extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaHistoricoDeChamados() {

		setBounds(100, 100, 800, 500);
		setLayout(new MigLayout("", "[][grow][][grow][]", "[][grow][][grow][]"));
		
		JPanel panel = new JPanel();
		add(panel, "cell 1 1,grow");
		
		JPanel panel_1 = new JPanel();
		add(panel_1, "cell 3 1,grow");
		
		JPanel panel_2 = new JPanel();
		add(panel_2, "cell 1 3,grow");
		
		JPanel panel_3 = new JPanel();
		add(panel_3, "cell 3 3,grow");
		

	}
}
