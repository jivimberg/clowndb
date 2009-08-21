package view;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Cloth;

@SuppressWarnings("serial")
public class ResultTable extends JTable{

	private DefaultTableModel model;
	
	public ResultTable(){
		super();
		model = new DefaultTableModel();
		String[] names = {"Nro. Articulo", "Código", "Descripcion", "Color", "Talle", "Precio", "Cantidad"};
		model.setColumnIdentifiers(names);
		setModel(model);
		setSize(new Dimension(1500,400));
	}
	
	public void addResult(ArrayList<Cloth> clothes){
		for(Cloth cloth : clothes){
			addItem(cloth);
		}
	}

	public void addItem(Cloth cloth) {
		Object[] clothString = new Object[7];
		clothString[0] = model.getRowCount() + 1;
		clothString[1] = cloth.getCode();
		clothString[2] = cloth.getDescription();
		clothString[3] = cloth.getColor().toString();
		clothString[4] = cloth.getSize();
		clothString[5] = cloth.getPrice();
		clothString[6] = cloth.getAmount();
		model.addRow(clothString);
	}
}
	
