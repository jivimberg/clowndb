package view;

import javax.swing.JButton;
import javax.swing.JToolBar;

import model.User;

import control.ActionManager;

@SuppressWarnings("serial")
public class MyToolBar extends JToolBar {

	private ActionManager am;
	
	public MyToolBar(ActionManager am){
		super();
		this.am = am;
	}

	public void setButtons(User user) {
		// Agregar producto
		JButton product = new JButton();
		product.setAction(am.getShowAddItemDialog());
		product.setText(product.getText());
		add(product);
		
		// Agregar proveedor
		
		/*JButton provider = new JButton();
		provider.setAction(am.getAddProvider());
		provider.setText(provider.getText());
		add(provider);*/	
	}
}
