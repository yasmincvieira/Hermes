package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import controller.PatrimonioTableModel;
import models.Patrimonio;
import models.PatrimonioDAO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;

public class TelaTabelaPatrimonios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnAdicionarPatri, btnEditarPatri, btnExcluirPatri;
	private Object btnTabela;
	private JLabel btVoltar; 

	/**
	 * Create the panel.
	 */
	public TelaTabelaPatrimonios() {

		setBounds(100, 100, 1100, 700);
		setLayout(new BorderLayout(0, 0));

		JPanel paneltabelaPatrimonio = new JPanel();
		add(paneltabelaPatrimonio, BorderLayout.CENTER);
		paneltabelaPatrimonio.setLayout(new MigLayout("", "[5,grow 5][grow][grow][grow][grow][grow][grow][::60px]", "[::60px,grow][100px:n,grow][grow][grow][grow]"));
		
		btVoltar = new JLabel("");
		btVoltar.setIcon(new ImageIcon(TelaTabelaPatrimonios.class.getResource("/Imagens/botao-voltar40.png")));
		paneltabelaPatrimonio.add(btVoltar, "cell 0 0,aligny top");

		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 200, 172));
		paneltabelaPatrimonio.add(panel, "cell 1 0 2 1");

		JLabel lblNewLabel_1 = new JLabel("Patrimônios");
		lblNewLabel_1.setForeground(new Color(38, 76, 63));
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(160, 200, 172));

		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaTabelaPatrimonios.class.getResource("/Imagens/40.png")));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
		paneltabelaPatrimonio.add(lblNewLabel, "cell 4 0 4 1,alignx right");

		JScrollPane scrollPane = new JScrollPane();
		paneltabelaPatrimonio.add(scrollPane, "cell 2 1 5 2,grow");

		table = new JTable();
		atualizarTabela();
		scrollPane.setViewportView(table);

		btnEditarPatri = new JButton("Editar patrimônios");
		btnEditarPatri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarPatri.setForeground(new Color(39, 79, 65));
		btnEditarPatri.setBackground(new Color(144, 204, 171));
		paneltabelaPatrimonio.add(btnEditarPatri, "cell 3 4,alignx right");

		btnAdicionarPatri = new JButton("Adicionar patrimônio");
		btnAdicionarPatri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionarPatri.setForeground(new Color(39, 79, 65));
		btnAdicionarPatri.setBackground(new Color(144, 204, 171));
		paneltabelaPatrimonio.add(btnAdicionarPatri, "cell 4 4,alignx center");

		btnExcluirPatri = new JButton("Excluir patrimônio");
		btnExcluirPatri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirPatri.setForeground(new Color(39, 79, 65));
		btnExcluirPatri.setBackground(new Color(144, 204, 171));
		paneltabelaPatrimonio.add(btnExcluirPatri, "cell 5 4,alignx left");
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public void excluirPatri(ActionListener actionListener) {
		this.btnExcluirPatri.addActionListener(actionListener);
	}

	public void editarPatri(ActionListener actionListener) {
		this.btnEditarPatri.addActionListener(actionListener);
	}

	public void adicionarPatri(ActionListener actionListener) {
		this.btnAdicionarPatri.addActionListener(actionListener);
	}

	public void atualizarTabela() {
		PatrimonioDAO patrimonioDao = new PatrimonioDAO();
		List<Patrimonio> lista = patrimonioDao.listarpatrimonio();
		PatrimonioTableModel model = new PatrimonioTableModel(lista);
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Cadeira", "Corredor", "01", "Em manuten\u00E7\u00E3o"},
			},
			new String[] {
				"Patrim\u00F4nio", "Espa\u00E7o", "ID", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});

	}
	
	public void irInicioADM(ActionListener actionListener) {
	    this.btVoltar.addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	            actionListener.actionPerformed(new ActionEvent(e.getSource(), ActionEvent.ACTION_PERFORMED, null));
	        }
	    });
	}

	

}
