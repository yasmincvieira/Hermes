package controller;

import java.util.ArrayList;
import java.util.List;

import models.Patrimonio;
import javax.swing.table.AbstractTableModel;

public class PatrimonioTableModel extends AbstractTableModel {
	
	private final List<Patrimonio> dados;
	private final String[] colunas = {"Patrimonio", "Espaço", "Id", "Status"};

	
	public PatrimonioTableModel(List<Patrimonio> dados) {
		this.dados = dados;
		// TODO Auto-generated constructor stub
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
	public Object getValueAt(int rowIndex, int columnIndex) {
		Patrimonio p = dados.get(rowIndex);
		switch (columnIndex) {
			case 0: return p.getIdpatrimonio();
			case 1: return p.getEspaco().getNomeLocal();
			case 2: return p.getNome();
			case 3: return p.getStatus();
		
		default:
			throw new IllegalArgumentException("Unexpected value: " + columnIndex);
		}
		
	}

}
