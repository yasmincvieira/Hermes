package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import models.Espaco;
import models.EspacoDAO;
import models.Patrimonio;
import net.miginfocom.swing.MigLayout;

public class TelaEditarPatrimonio extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField tfID;
    private JTextField tfPatrimonio;
    private JComboBox<Espaco> cbEspaco;
    private JComboBox<String> cbStatus;
    private JButton btnSalvar;
    private JLabel lblVoltar;
    private EspacoDAO espacoDAO = new EspacoDAO();

    public TelaEditarPatrimonio() {
        setBackground(new Color(240, 240, 240));
        setBounds(100, 100, 800, 500);
        setLayout(new MigLayout("",
            "[grow][163.00,grow][370.00,grow][grow]",
            "[137.00,grow][43][43][43][43][72.00,grow]"));

        lblVoltar = new JLabel("");
        lblVoltar.setIcon(new ImageIcon(TelaEditarPatrimonio.class.getResource("/Imagens/botao-voltar40.png")));
        add(lblVoltar, "cell 0 0,alignx left,aligny top");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(160, 200, 172));
        add(panel, "flowx,cell 2 0,growx,aligny center");

        JLabel lblTitulo = new JLabel("Editar Patrimônio");
        panel.add(lblTitulo);
        lblTitulo.setForeground(new Color(38, 76, 63));
        lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));

        JLabel lblHermes = new JLabel("HERMES");
        lblHermes.setIcon(new ImageIcon(TelaEditarPatrimonio.class.getResource("/Imagens/40.png")));
        lblHermes.setForeground(new Color(39, 79, 65));
        lblHermes.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
        add(lblHermes, "flowx,cell 3 0,alignx right,aligny top");

        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblId, "cell 1 1,alignx trailing");

        tfID = new JTextField();
        tfID.setEditable(false);
        add(tfID, "cell 2 1,growx");

        JLabel lblPatrimonio = new JLabel("Patrimônio");
        lblPatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblPatrimonio, "cell 1 2,alignx trailing");

        tfPatrimonio = new JTextField();
        add(tfPatrimonio, "cell 2 2,growx");

        JLabel lblEspaco = new JLabel("Espaço");
        lblEspaco.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblEspaco, "cell 1 3,alignx trailing");

        cbEspaco = new JComboBox<>();
        carregarEspacos();
        add(cbEspaco, "cell 2 3,growx");

        JLabel lblStatus = new JLabel("Status");
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblStatus, "cell 1 4,alignx trailing");

        cbStatus = new JComboBox<>(new String[]{"Ativo", "Inativo", "Em manutenção"});
        add(cbStatus, "cell 2 4,growx");

        btnSalvar = new JButton("Salvar Alterações");
        btnSalvar.setBackground(new Color(126, 182, 143));
        btnSalvar.setForeground(new Color(0, 64, 0));
        btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(btnSalvar, "cell 2 5,alignx right,aligny top");
    }


	
	private void carregarEspacos() {
        try {
            List<Espaco> espacos = espacoDAO.listarTodos();
            for (Espaco esp : espacos) {
                cbEspaco.addItem(esp);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar espaços: " + ex.getMessage());
        }
    }

    public void preencherCampos(Patrimonio p) {
        tfID.setText(p.getId_patrimonio());
        tfPatrimonio.setText(p.getNome());
        cbStatus.setSelectedItem(p.getStatus());
        for (int i = 0; i < cbEspaco.getItemCount(); i++) {
            Espaco esp = cbEspaco.getItemAt(i);
            if (esp != null && esp.getId_espaco() != null
                    && p.getEspaco() != null
                    && esp.getId_espaco().equals(p.getEspaco().getId_espaco())) {
                cbEspaco.setSelectedIndex(i);
                break;
            }
        }
    }

    public String getIdPatrimonio() { return tfID.getText().trim(); }
    public String getNomePatrimonio() { return tfPatrimonio.getText().trim(); }
    public Espaco getEspacoSelecionado() { return (Espaco) cbEspaco.getSelectedItem(); }
    public String getStatusSelecionado() { return (String) cbStatus.getSelectedItem(); }

    public void salvar(ActionListener actionListener) {
        this.btnSalvar.addActionListener(actionListener);
    }

    public void voltar(ActionListener actionListener) {
        this.lblVoltar.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                actionListener.actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, null));
            }
        });
    }
}