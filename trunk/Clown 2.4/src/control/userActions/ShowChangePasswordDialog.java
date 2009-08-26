package control.userActions;

import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;

import control.ActionManager;
import control.GenericAction;

import view.ChangePasswordDialog;

import model.Model;

public class ShowChangePasswordDialog extends GenericAction {
	
	private ChangePasswordDialog changePasswordDialog;
	private ActionManager am;

	public ShowChangePasswordDialog(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0) {
		changePasswordDialog = new ChangePasswordDialog(am);

	}

}
