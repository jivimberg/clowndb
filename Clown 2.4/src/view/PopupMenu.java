package view;

import javax.swing.JPopupMenu;

import control.ActionManager;

public class PopupMenu extends JPopupMenu {

	ActionManager am;
	
	public PopupMenu (ActionManager actionManager){
		this.am = actionManager;
		addButtons();
	}

	private void addButtons() {
		add(am.getSell());
		add(am.getShowModifyItemDialog());
		add(am.getRemoveItem());
	}
}
