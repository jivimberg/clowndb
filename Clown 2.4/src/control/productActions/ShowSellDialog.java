package control.productActions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import model.Model;
import control.ActionManager;
import control.GenericAction;

public class ShowSellDialog extends GenericAction {
	
	private ActionManager am;

	public ShowSellDialog(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0) {
		am.getMainFrame().getSellDialog().setVisible(true);
	}
}


