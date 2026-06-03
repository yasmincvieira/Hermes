package view;

import java.awt.Color;
import java.util.List;

import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionListener;

import models.Espaco;
import models.EspacoDAO;
import models.Patrimonio;
import models.PatrimonioDAO;

import net.miginfocom.swing.MigLayout;

public class TelaEditarPatrimonio extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField tfID;
    private JTextField tfPatrimonio;
    private JComboBox<Espaco> cbEspaco;
    private JComboBox<String> cbStatus;

    private PatrimonioDAO patrimonioDAO = new PatrimonioDAO();
    private EspacoDAO espacoDAO = new EspacoDAO();           

    public TelaEditarPatrimonio() {
        setBackground(new Color(240, 240, 240));
        setForeground(new Color(255, 255, 255));
        setBounds(100, 100, 800, 500);
        setLayout(new MigLayout("",
            "[grow][163.00,grow][370.00,grow][grow]",
            "[137.00,grow][43][43][43][43][72.00,grow]"));

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(TelaEditarPatrimonio.class.getResource("/Imagens/botao-voltar40.png")));
        add(lblNewLabel, "cell 0 0,alignx left,aligny top");

        JPanel panel = new JPanel();
        panel.setBackground(new Color(160, 200, 172));
        add(panel, "flowx,cell 2 0,growx,aligny center");

        JLabel lblNewLabel_1 = new JLabel("Editar Patrimônio");
        panel.add(lblNewLabel_1);
        lblNewLabel_1.setForeground(new Color(38, 76, 63));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_1.setBackground(new Color(160, 200, 172));

        JLabel lblNewLabel_2 = new JLabel("HERMES");
        lblNewLabel_2.setIcon(new ImageIcon(TelaEditarPatrimonio.class.getResource("/Imagens/40.png")));
        lblNewLabel_2.setForeground(new Color(39, 79, 65));
        lblNewLabel_2.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
        add(lblNewLabel_2, "flowx,cell 3 0,alignx right,aligny top");

        // --- ID ---
        JLabel lblId = new JLabel("ID");
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblId, "cell 1 1,alignx trailing");

        tfID = new JTextField();
        tfID.setEditable(false); 
        add(tfID, "cell 2 1,growx");
        tfID.setColumns(10);

        // --- Nome ---
        JLabel lblPatrimonio = new JLabel("Patrimônio");
        lblPatrimonio.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblPatrimonio, "cell 1 2,alignx trailing");

        tfPatrimonio = new JTextField();
        add(tfPatrimonio, "cell 2 2,growx");
        tfPatrimonio.setColumns(10);

        // --- Espaço ---
        JLabel lblEspaco = new JLabel("Espaço");
        lblEspaco.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblEspaco, "cell 1 3,alignx trailing");

        cbEspaco = new JComboBox<>();
        carregarEspacos();
        add(cbEspaco, "cell 2 3,growx");

        // --- Status ---
        JLabel lblStatus = new JLabel("Status");
        lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 17));
        add(lblStatus, "cell 1 4,alignx trailing");

        cbStatus = new JComboBox<>(new String[]{"Ativo", "Inativo", "Em manutenção"}); 
        add(cbStatus, "cell 2 4,growx");

        // --- Botão ---
        JButton btnSalvar = new JButton("Salvar Alterações");
        btnSalvar.setBackground(new Color(126, 182, 143));
        btnSalvar.setForeground(new Color(0, 64, 0));
        btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 15));
        add(btnSalvar, "cell 2 5,alignx right,aligny top");
        
    

        btnSalvar.addActionListener(e -> salvarAlteracoes());
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

    public void preencherCampos(String id) {
        try {
            Patrimonio p = patrimonioDAO.buscarPorId(id);
            if (p != null) {
                tfID.setText(p.getId_patrimonio());  
                tfPatrimonio.setText(p.getNome());
                cbStatus.setSelectedItem(p.getStatus());

            
                for (int i = 0; i < cbEspaco.getItemCount(); i++) {
                    if (cbEspaco.getItemAt(i).getId_espaco()
                            .equals(p.getEspaco().getId_espaco())) {
                        cbEspaco.setSelectedIndex(i);
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Patrimônio não encontrado.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao buscar: " + ex.getMessage());
        }
    }

    private void salvarAlteracoes() {
        try {
            Espaco espacoSelecionado = (Espaco) cbEspaco.getSelectedItem();

            Patrimonio p = new Patrimonio();
            p.setId_patrimonio(tfID.getText().trim()); 
            p.setNome(tfPatrimonio.getText().trim());
            p.setEspaco(espacoSelecionado);
            p.setStatus((String) cbStatus.getSelectedItem());

            boolean sucesso = patrimonioDAO.atualizar(p);

            if (sucesso) {
                JOptionPane.showMessageDialog(this, "Patrimônio atualizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(this, "Nenhum registro foi atualizado.");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
        }
    }
    
    public void preencherCampos(Patrimonio patrimonio) {
    	if (patrimonio != null) {
    		tfID.setText(patrimonio.getId());
    		tfPatrimonio.setText(patrimonio.getNome());
    	}
    }
}