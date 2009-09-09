package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import model.User;

import control.ActionManager;
import enums.UserType;

@SuppressWarnings("serial")
public class MyMenuBar extends JMenuBar {

	JMenu file;
	JMenu edit;
	JMenu help;
	
	private ActionManager am;

	
	public MyMenuBar(ActionManager am){
		super();
		this.am = am;
	}

	public void setButtons(User user) {
		/*----FILE----*/
		file = new JMenu("Archivo");
		add(file);
		file.add(am.getShowAddItemDialog());
		file.add(am.getShowModifyItemDialog());
		
		/*----EDITAR----*/
		edit = new JMenu("Editar");
		add(edit);
		edit.add(am.getSell());
		edit.add(am.getShowSellDialog());
		edit.add(am.getShowChangePasswordDialog());
		if(user.getType().equals(UserType.ADMIN)){
			file.add(am.getRemoveItem());
			
			file.addSeparator();
			file.add(am.getAddUser());
			file.add(am.getAddAdmin());
			file.add(am.getRemoveUser());
			
			edit.addSeparator();
			edit.add(am.getProductsToXLS());
			//edit.add(am.getProductsFromXLS());
		}
		file.addSeparator();
		file.add(am.getAddProvider());
		if(user.getType().equals(UserType.ADMIN)){
			file.add(am.getRemoveProvider());
		}
	}
}