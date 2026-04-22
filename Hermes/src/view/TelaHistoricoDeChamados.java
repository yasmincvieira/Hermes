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

	/**
	 * Create the panel.
	 */
	public TelaHistoricoDeChamados() {

		setBounds(100, 100, 800, 500);
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new MigLayout("", "[36px][743px,grow]", "[486px,grow]"));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "cell 0 0,alignx left,growy");
		panel_1.setLayout(new MigLayout("", "[]", "[][][]"));

		JLabel lblNewLabel_3 = new JLabel("New label");
		panel_1.add(lblNewLabel_3, "cell 0 0");

		JLabel lblNewLabel_4 = new JLabel("New label");
		panel_1.add(lblNewLabel_4, "cell 0 1");

		JLabel lblNewLabel_2 = new JLabel("New label");
		panel_1.add(lblNewLabel_2, "cell 0 2");

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, "cell 1 0,grow");
		panel_2.setLayout(new MigLayout("", "[][grow][][][][]", "[][][grow]"));

		JLabel lblNewLabel = new JLabel("New label");
		panel_2.add(lblNewLabel, "cell 5 0");

		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, "cell 1 0");

		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_3.add(lblNewLabel_1);

	}
}
