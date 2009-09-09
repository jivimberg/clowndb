package view;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.ActionManager;

import model.Cloth;

@SuppressWarnings("serial")
public class ResultTable extends JTable implements MouseListener {

	private MyDefaultTableModel tableModel;
	private List<Cloth> clothes;
	private PopupMenu popupMenu;
	
	public ResultTable(ActionManager am){
		tableModel = new MyDefaultTableModel();
		String[] names = {"Nro. Articulo", "Código", "Descripcion", "Color", "Talle", "Costo", 
				"Cantidad", "P. por mayor", "P. por menor", "Sexo", "Año"};
		tableModel.setColumnIdentifiers(names);
		setModel(tableModel);
		popupMenu = new PopupMenu(am);
		addMouseListener(this);
		setSize(new Dimension(1500,400));
	}
	
	public void addResult(List<Cloth> clothes){
		empty();
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
		for (int i = tableModel.getRowCount() - 1; i >= 0; i--) {
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

	class MyDefaultTableModel extends DefaultTableModel{
		public MyDefaultTableModel() {  
			super();  
		}  
		
		public boolean isCellEditable(int row, int col) {  
		   return false;  
		}  
	}

	public void mouseClicked(MouseEvent e) {
		if(e.getModifiers()== e.BUTTON3_MASK)
			popupMenu.show(this, e.getX(), e.getY());
	}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}
}