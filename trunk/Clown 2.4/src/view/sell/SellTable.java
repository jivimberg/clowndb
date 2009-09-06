package view.sell;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Cloth;
import model.ClothSold;

public class SellTable extends JTable {
	
	private MyDefaultTableModel tableModel;
	private List<ClothSold> clothSold;
	
	public SellTable(){
		tableModel = new MyDefaultTableModel();
		String[] names = {"Fecha de venta", "Código", "Descripcion", "Talle", "Costo", 
				"Cantidad", "P. por mayor", "P. por menor"};
		tableModel.setColumnIdentifiers(names);
		setModel(tableModel);
		setSize(new Dimension(1500,400));
	}
	
	public void addResult(List<ClothSold> clothSold){
		empty();
		this.clothSold = clothSold;
		for(ClothSold cloth : this.clothSold){
			addItem(cloth);
		}
	}

	private void addItem(ClothSold clothSold) {
		Cloth cloth = clothSold.getSold();
		Object[] clothString = new Object[11];
		clothString[0] = clothSold.getDate();
		clothString[1] = cloth.getCode();
		clothString[2] = cloth.getDescription();
		clothString[3] = cloth.getSize();
		clothString[4] = cloth.getCost();
		clothString[5] = cloth.getAmount();
		clothString[6] = cloth.getWholesalePrice();
		clothString[7] = cloth.getRetailPrice();
		tableModel.addRow(clothString);
	}
	
	public void empty(){
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}
	
	public void addCloth() {
		empty();
		addResult(clothSold);
	}
	
	@SuppressWarnings("serial")
	class MyDefaultTableModel extends DefaultTableModel{
		public MyDefaultTableModel() {  
			super();  
		}  
		
		public boolean isCellEditable(int row, int col) {  
		   return false;  
		}  
	};  
}