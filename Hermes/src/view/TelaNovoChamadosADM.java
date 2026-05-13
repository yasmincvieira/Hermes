package view;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.List;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import models.Chamado;
import javax.swing.SpringLayout;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class TelaNovoChamadosADM extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel containerChamados;
    private JScrollPane scrollPane;

    public TelaNovoChamadosADM() {
        setLayout(new BorderLayout(0, 0));
        setBackground(Color.WHITE);

        containerChamados = new JPanel();
        containerChamados.setBackground(Color.WHITE);
        containerChamados.setLayout(new BoxLayout(containerChamados, BoxLayout.Y_AXIS));
        containerChamados.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        scrollPane = new JScrollPane(containerChamados);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void atualizarChamados(List<Chamado> chamados, ActionListener verDetalhesListener) {
        containerChamados.removeAll();

        for (Chamado chamado : chamados) {
            TelinhaHistorico card = new TelinhaHistorico(chamado, verDetalhesListener);
            containerChamados.add(card);
            containerChamados.add(Box.createVerticalStrut(10));
        }

        containerChamados.revalidate();
        containerChamados.repaint();
    }
}
