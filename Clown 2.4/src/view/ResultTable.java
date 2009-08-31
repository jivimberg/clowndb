package view;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Cloth;

@SuppressWarnings("serial")
public class ResultTable extends JTable {

	private DefaultTableModel tableModel;
	private List<Cloth> clothes;
	
	public ResultTable(){
		tableModel = new DefaultTableModel();
		String[] names = {"Nro. Articulo", "Código", "Descripcion", "Color", "Talle", "Costo", 
				"Cantidad", "P. por mayor", "P. por menor", "Sexo", "Año"};
		tableModel.setColumnIdentifiers(names);
		setModel(tableModel);
		setSize(new Dimension(1500,400));
	}
	
	public void addResult(List<Cloth> clothes){
		this.clothes = clothes;
		for(Cloth cloth : clothes){
			addItem(cloth);
		}
	}

	private void addItem(Cloth cloth) {
		Object[] clothString = new Object[11];
		clothString[0] = tableModel.getRowCount() + 1;
		clothString[1] = cloth.getCode();
		clothString[2] = cloth.getDescription();
		clothString[3] = cloth.getColor().toString();
		clothString[4] = cloth.getSize();
		clothString[5] = cloth.getCost();
		clothString[6] = cloth.getAmount();
		clothString[7] = cloth.getWholesalePrice();
		clothString[8] = cloth.getRetailPrice();
		clothString[9] = cloth.getSex();
		clothString[10] = cloth.getYear();
		tableModel.addRow(clothString);
	}
	
	public void empty(){
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
			tableModel.removeRow(i);
		}
	}

	public List<Cloth> getSelectedObjects() {
		int[] selected = getSelectedRows();
		List<Cloth> selectedClothes = new ArrayList<Cloth>();
		for (int i = 0; i < selected.length; i++) {
			selectedClothes.add(clothes.get(i));
		}
		return selectedClothes;
	}

	public void remove(Cloth cloth) {
		for (int i = 0; i < tableModel.getRowCount(); i++) {
			if(cloth.getCode().equalsIgnoreCase((String) tableModel.getValueAt(i, 1))){
				tableModel.removeRow(i);
				break;
			}
		}
	}
	
	public Cloth getItem(int index) {
		return clothes.get(index);
	}
	
	public void addSelectionListener(ListSelectionListener listener){
		getSelectionModel().addListSelectionListener(listener);
	}

	public void modifyCloth(Cloth cloth) {
		empty();
		addResult(clothes);
	}	
}