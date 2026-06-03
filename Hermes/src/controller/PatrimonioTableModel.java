package controller;

import java.util.ArrayList;
import java.util.List;

import models.Patrimonio;
import javax.swing.table.AbstractTableModel;

public class PatrimonioTableModel extends AbstractTableModel {

	private final List<Patrimonio> dados;
	private final String[] colunas = { "Id", "Patrimônio", "Espaço", "Status" };

	public PatrimonioTableModel(List<Patrimonio> dados) {
		this.dados = dados;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Class<?> getColumnClass(int columnIndex) {
	    switch (columnIndex) {
	        case 0: return Integer.class;
	        case 1: return String.class;
	        case 2: return String.class;
	        case 3: return String.class;
	        default: return Object.class;
	    }
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dados.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colunas.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return colunas[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Patrimonio p = dados.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return p.getId_patrimonio();
		case 1:
			return p.getNome();
			
		case 2:
			return p.getEspaco();
		case 3:
			return p.getStatus();

		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}

	}

}
