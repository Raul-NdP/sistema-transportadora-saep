package br.com.senai.sistematranspotadorasaep.view.components.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.sistematranspotadorasaep.entity.Entrega;

public class EntregaTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;

	private final int QTDE_COLUNAS = 2;
	
	private List<Entrega> entregas;
	
	public  EntregaTableModel(List<Entrega> entregas) {
		this.entregas = entregas;
	}
	
	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		} else if (column == 1) {
			return "Descrição";
		}
		throw new IllegalArgumentException("Indíce inválido");
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return entregas.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return entregas.get(rowIndex).getDescricao();
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
	@Override
	public int getRowCount() {
		return entregas.size();
	}
	
	public Entrega getPor(int rowIndex) {
		return entregas.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		this.entregas.remove(rowIndex);
	}
	
}