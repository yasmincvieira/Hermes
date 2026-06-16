package view;

import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.PatrimonioTableModel;
import controller.TabelaController;
import models.Patrimonio;
import models.PatrimonioDAO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JTextField;

import javax.swing.RowFilter;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Label;


public class TelaTabelaPatrimonios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnAdicionarPatri, btnEditarPatri, btnExcluirPatri;
	private JTextField tfBusca;
	private TableRowSorter<PatrimonioTableModel> rowSorter;
	private PatrimonioTableModel patrimonioTableModel;

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
		paneltabelaPatrimonio.setLayout(new MigLayout("", "[grow][grow][177.00,grow][grow][grow][grow][::60px]", "[][::60px,grow][73.00][100px:n,grow][grow][grow][grow]"));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(160, 200, 172));
		paneltabelaPatrimonio.add(panel, "cell 0 1 2 1");

		//@@VER  
		//paneltabelaPatrimonio.setLayout(new MigLayout("", "[5,grow 5][grow][grow][grow][grow][grow][grow][::60px]", "[::60px,grow][100px:n,grow][grow][grow][grow]"));
		
		btVoltar = new JLabel("");
		btVoltar.setIcon(new ImageIcon(TelaTabelaPatrimonios.class.getResource("/Imagens/botao-voltar40.png")));
		paneltabelaPatrimonio.add(btVoltar, "cell 0 0,aligny top");



		JLabel lblNewLabel_1 = new JLabel("Patrimônios");
		lblNewLabel_1.setForeground(new Color(38, 76, 63));
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBackground(new Color(160, 200, 172));

		JLabel lblNewLabel = new JLabel("HERMES");
		lblNewLabel.setForeground(new Color(39, 79, 65));
		lblNewLabel.setIcon(new ImageIcon(TelaTabelaPatrimonios.class.getResource("/Imagens/40.png")));
		lblNewLabel.setFont(new Font("OCR-A BT", Font.PLAIN, 50));
//<<<<<<< HEAD
		paneltabelaPatrimonio.add(lblNewLabel, "cell 3 1 4 1,alignx right");
		
		tfBusca = new JTextField();

		tfBusca.addKeyListener(new KeyAdapter() {
		    @Override
		    public void keyReleased(KeyEvent e) {
		        filtrar();
		    }
		});

		
		Label label = new Label("Buscar");
		label.setFont(new Font("Dialog", Font.PLAIN, 19));
		paneltabelaPatrimonio.add(label, "cell 1 2,alignx right");
		

		paneltabelaPatrimonio.add(tfBusca, "cell 2 2,growx");
		tfBusca.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		paneltabelaPatrimonio.add(scrollPane, "cell 1 3 5 2,grow");
//=======
		//@@@ VERRR
		//paneltabelaPatrimonio.add(lblNewLabel, "cell 4 0 4 1,alignx right");

		//JScrollPane scrollPane = new JScrollPane();
		//paneltabelaPatrimonio.add(scrollPane, "cell 2 1 5 2,grow");
//>>>>>>> origin/branchJulia_voltar

		table = new JTable();
		atualizarTabela(); 
		scrollPane.setViewportView(table);
	
		btnEditarPatri = new JButton("Editar patrimônios");
		btnEditarPatri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEditarPatri.setForeground(new Color(39, 79, 65));
		btnEditarPatri.setBackground(new Color(144, 204, 171));
//<<<<<<< HEAD
		paneltabelaPatrimonio.add(btnEditarPatri, "cell 2 6,alignx right");
//=======
//		paneltabelaPatrimonio.add(btnEditarPatri, "cell 3 4,alignx right");
//>>>>>>> origin/branchJulia_voltar

		btnAdicionarPatri = new JButton("Adicionar patrimônio");
		btnAdicionarPatri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionarPatri.setForeground(new Color(39, 79, 65));
		btnAdicionarPatri.setBackground(new Color(144, 204, 171));
//<<<<<<< HEAD
		paneltabelaPatrimonio.add(btnAdicionarPatri, "cell 3 6,alignx center");
//=======
//		paneltabelaPatrimonio.add(btnAdicionarPatri, "cell 4 4,alignx center");
//>>>>>>> origin/branchJulia_voltar

		btnExcluirPatri = new JButton("Excluir patrimônio");
		btnExcluirPatri.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExcluirPatri.setForeground(new Color(39, 79, 65));
		btnExcluirPatri.setBackground(new Color(144, 204, 171));
//<<<<<<< HEAD
		paneltabelaPatrimonio.add(btnExcluirPatri, "cell 4 6,alignx left");
		
//=======
//		paneltabelaPatrimonio.add(btnExcluirPatri, "cell 5 4,alignx left");
//>>>>>>> origin/branchJulia_voltar
	}

	public JTable getTable() {
		return table;
	}
	

	public void setTable(JTable table) {
		this.table = table;
	}
	

	public int getLinhaSelecionada() {
	  int linhaVisivel = table.getSelectedRow();
	    if (linhaVisivel == -1) {
	        return -1;
	    }
	    return table.convertRowIndexToModel(linhaVisivel);
	}


	public int getCodigoSelecionado() {
		int linhaVisivel = table.getSelectedRow();
	    if (linhaVisivel == -1) {
	        return -1; 
	    }
	    int linhaModel = table.convertRowIndexToModel(linhaVisivel);
	    return (int) table.getModel().getValueAt(linhaModel, 0);
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
	    patrimonioTableModel = new PatrimonioTableModel(lista);
	    table.setModel(patrimonioTableModel);

	    rowSorter = new TableRowSorter<>(patrimonioTableModel);
	    table.setRowSorter(rowSorter);
	}

	public void adicionarOuvinte(ComponentListener listener) {
		this.addComponentListener(listener);
	}
	private void filtrar() {
	    if (rowSorter == null) {
	        return;
	    }

	    String busca = tfBusca.getText().trim();

	    if (busca.length() == 0) {
	        rowSorter.setRowFilter(null);
	    } else {
	        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + java.util.regex.Pattern.quote(busca)));
	    }
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
