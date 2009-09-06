package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import model.User;

import control.ActionManager;

@SuppressWarnings("serial")
public class MyToolBar extends JToolBar {

	private ActionManager am;
	
	public MyToolBar(ActionManager am){
		this.am = am;
	}

	public void setButtons(User user) {
		// Agregar producto
		JButton product = new JButton();
		product.setAction(am.getShowAddItemDialog());
		product.setText(product.getText());
		add(product);
		
		// Detalles Producto
		JButton detailProduct = new JButton();
		detailProduct.setAction(am.getShowModifyItemDialog());
		detailProduct.setText(detailProduct.getText());
		add(detailProduct);
		
		// Detalles Producto
		JButton sellProduct = new JButton();
		sellProduct.setAction(am.getSell());
		sellProduct.setText(sellProduct.getText());
		add(sellProduct);
		
		setFloatable(false);
	}
}
