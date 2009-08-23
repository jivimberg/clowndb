package control;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import model.Cloth;
import model.Model;
import model.ModelListener;
import model.Provider;
import model.User;
import view.AddClothDialog;

public class ShowAddItemDialog extends GenericAction {
	
	private AddClothDialog addClothDialog;
	private ActionManager am;

	public ShowAddItemDialog(String text, ImageIcon icon, String desc,
			Integer mnemonic, Model model, ActionManager am) {
		super(text, icon, desc, mnemonic, model);
		this.am = am;
	}

	public void actionPerformed(ActionEvent arg0) {
		addClothDialog = new AddClothDialog(am, model.getProviders());
		addClothDialog.setVisible(true);

	}

}
