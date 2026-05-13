package view;

import javax.swing.JPanel;
import models.Chamado;
import java.awt.Color;
import java.awt.Dimension;
import net.miginfocom.swing.MigLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

public class TelinhaHistoricoADM extends JPanel {

	private static final long serialVersionUID = 1L;
	private Chamado chamado;
    private JButton btnVerDetalhes;

    public TelinhaHistoricoADM(Chamado chamado, ActionListener verDetalhesListener) {
        this.chamado = chamado;
        
        setBackground(new Color(187, 215, 194));
        setBorder(BorderFactory.createLineBorder(new Color(39, 79, 65), 1));
        setLayout(new MigLayout("", "[grow]", "[][][grow][]"));
        
        setPreferredSize(new Dimension(300, 120));
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 120));

        JLabel lblTitulo = new JLabel("Chamado " + chamado.getIdChamado() + " - " + chamado.getNome());
        lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(lblTitulo, "cell 0 0, growx");
        
        JLabel lblStatus = new JLabel("Status: " + chamado.getStatus());
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(lblStatus, "cell 0 1, growx");
        
        btnVerDetalhes = new JButton("Ver Detalhes...");
        btnVerDetalhes.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnVerDetalhes.setBackground(new Color(187, 215, 194));
        btnVerDetalhes.setActionCommand(String.valueOf(chamado.getIdChamado()));
        btnVerDetalhes.addActionListener(verDetalhesListener);
        add(btnVerDetalhes, "cell 0 3, alignx left");
    }

    public Chamado getChamado() {
        return chamado;
    }

}
