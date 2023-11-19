package br.com.senai.sistematranspotadorasaep.view.components.table;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.com.senai.sistematranspotadorasaep.entity.Motorista;

public class MotoristaTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;

	private final int QTDE_COLUNAS = 3;
	
	private List<Motorista> motoristas;
	
	public  MotoristaTableModel(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}
	
	@Override
	public int getColumnCount() {
		return QTDE_COLUNAS;
	}
	
	public String getColumnName(int column) {
		if (column == 0) {
			return "ID";
		} else if (column == 1) {
			return "Nome";
		} else if (column == 2) {
			return "CNH";
		}
		throw new IllegalArgumentException("Indíce inválido");
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		if (columnIndex == 0) {
			return motoristas.get(rowIndex).getId();
		} else if (columnIndex == 1) {
			return motoristas.get(rowIndex).getNome();
		} else if (columnIndex == 2) {
			return motoristas.get(rowIndex).getCnh();
		}
		throw new IllegalArgumentException("Índice inválido");
	}
	
	@Override
	public int getRowCount() {
		return motoristas.size();
	}
	
	public Motorista getPor(int rowIndex) {
		return motoristas.get(rowIndex);
	}
	
	public void removerPor(int rowIndex) {
		this.motoristas.remove(rowIndex);
	}
	
}