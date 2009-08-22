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
		
		/*----EDITAR----*/
		edit = new JMenu("Editar");
		add(edit);
		edit.add(am.getShowChangePasswordDialog());
		if(user.getType().equals(UserType.ADMIN)){
			file.add(am.getRemoveItem());
			
			edit.addSeparator();
			edit.add(am.getAddUser());
			edit.add(am.getRemoveUser());
		}
		file.add(am.getAddProvider());
	}
}