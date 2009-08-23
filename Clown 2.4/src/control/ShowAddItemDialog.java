package control;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import model.Model;

public class ShowAddItemDialog extends GenericAction {
	
	private ActionManager am;

	public ShowAddItemDialog(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0) {
		am.getMainFrame().getAddItemDialog().openWindow();
	}
}
