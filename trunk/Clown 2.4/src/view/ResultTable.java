package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Cloth;

@SuppressWarnings("serial")
public class ResultTable extends JTable{

	private DefaultTableModel tableModel;
	
	public ResultTable(){
		tableModel = new DefaultTableModel();
		String[] names = {"Nro. Articulo", "Código", "Descripcion", "Color", "Talle", "Precio", "Cantidad"};
		tableModel.setColumnIdentifiers(names);
		setModel(tableModel);
		setSize(new Dimension(1500,400));
	}
	
	public void addResult(List<Cloth> clothes){
		for(Cloth cloth : clothes){
			addItem(cloth);
		}
	}

	public void addItem(Cloth cloth) {
		Object[] clothString = new Object[7];
		clothString[0] = tableModel.getRowCount() + 1;
		clothString[1] = cloth.getCode();
		clothString[2] = cloth.getDescription();
		clothString[3] = cloth.getColor().toString();
		clothString[4] = cloth.getSize();
		clothString[5] = cloth.getPrice();
		clothString[6] = cloth.getAmount();
		tableModel.addRow(clothString);
	}
	
	public void empty(){
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			tableModel.removeRow(i);
		}
	}

	public ArrayList<Cloth> getSelected() {
		int[] selected = getSelectedRows();
		for (int i = 0; i < selected.length; i++) {
			Object aux = selected[i];
			//La idea era que devuelva un arreglo con la ropa Seleccionada pero al no tener acceso al model nose puede
		}
		return null;
	}
}
	
